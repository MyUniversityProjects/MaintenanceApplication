package queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import root.Database;
import root.entities.Activity;
import root.exceptions.NotFoundException;
import root.exceptions.QueryFailedException;

public class ActivityQueries {
    /**
     * Create and return an instance of Activity by fetching the data from
     * the database
     * @param id activity identifier
     * @return the fetched activity
     * @throws NotFoundException if the activity is not found
     * @throws QueryFailedException if app is unable to query the database
     */
    public Activity fetch(int id) throws NotFoundException {
        String query = "SELECT id, area, branch_office, typology, description, estimated_time, interruptible, week, workspace_notes, type_activity, verified FROM AppActivity WHERE id=?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rst = stmt.executeQuery();
            
            if (!rst.next()) throw new NotFoundException();
            return new Activity(
                rst.getInt("id"),
                rst.getString("area"),
                rst.getString("branch_office"),
                rst.getString("typology"),
                rst.getString("description"),
                rst.getInt("estimated_time"),
                rst.getBoolean("interruptible"),
                rst.getInt("week"),
                rst.getString("workspace_notes"),
                Activity.convertRawType(rst.getString("type_activity"))
            );
        } catch(SQLException ex) {
            throw new QueryFailedException(ex.getMessage());
        }
    }
    
    /**
     * Database query that verify and updates a schedulated activity.
     * @param id activity identifier
     * @param notes the new notes of the activity
     * @throws NotFoundException if the activity is not found
     * @throws QueryFailedException if app is unable to query the database
     */
    public void forwardScheduled(int id, String notes) throws NotFoundException {
        String query = "UPDATE AppActivity SET workspace_notes=?, verified=TRUE WHERE id=?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, notes);
            stmt.setInt(2, id);
            int res = stmt.executeUpdate();
            if (res == 0) throw new NotFoundException("Activity not found");
        } catch(SQLException ex) {
            throw new QueryFailedException(ex.getMessage());
        }
    }
    
    /**
     * Database query that verify and updates an EWO activity.
     * @param id activity identifier
     * @param desc the new desctiption of the activity
     * @param time the new estimated time of the activity
     * @throws NotFoundException if the activity is not found
     * @throws QueryFailedException if app is unable to query the database
     */
    public void forwardEwo(int id, String desc, int time) throws NotFoundException {
        String query = "UPDATE AppActivity SET description=?, estimated_time=?, verified=TRUE WHERE id=?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, desc);
            stmt.setInt(2, time);
            stmt.setInt(3, id);
            int res = stmt.executeUpdate();
            if (res == 0) throw new NotFoundException("Activity not found");
        } catch(SQLException ex) {
            throw new QueryFailedException(ex.getMessage());
        }
    }
    
    /**
     *Database query that create an activity
     * @param activity information to be entered
     * @return if the create was successful
     */
    public boolean create(Activity activity){
        String query = "INSERT INTO appactivity "+
            "(id, branch_office, area, typology, description,"+
            "estimated_time, interruptible, week, workspace_notes,"+
            "type_activity) VALUES "+
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = Database.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setInt(1, activity.getId());
            stmt.setString(2,activity.getBranchOffice());
            stmt.setString(3, activity.getArea());
            stmt.setString(4, activity.getTypology());
            stmt.setString(5, activity.getDescription());
            stmt.setInt(6, activity.getTime());
            stmt.setBoolean(7, activity.isInterruptible());
            stmt.setInt(8, activity.getWeek());
            stmt.setString(9, activity.getNotes());
            stmt.setString(10, activity.getType().toString());
            
            return stmt.executeUpdate() != 0;
        } catch(SQLException ex){
            return false;
        }
    }
    
    /**
     *Database query that fetch all activity
     * @return a List of activity
     */
    public List<Activity> fetchAll(){
        List<Activity> activities = new LinkedList<>();
        String query = "SELECT * FROM appactivity";
        
        try(Connection conn = Database.getConnection()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);   
            if(rs != null){
                while(rs.next()){                   
                    Activity activity = new Activity(rs.getInt("id"),
                        rs.getString("branch_office"),
                        rs.getString("area"), rs.getString("typology"),
                        rs.getString("description"),
                        rs.getInt("estimated_time"), rs.getBoolean("interruptible"),
                        rs.getInt("week"),
                        rs.getString("workspace_notes"),
                        Activity.ActivityType.valueOf(rs.getString("type_activity")));
                    activities.add(activity);
                }
                return activities;
            }
        } catch(Exception ex){
            return null;
        }
        return null;
    }
    
    /**
     *Database query that delete an activity
     * @param id activity identifier
     * @return if the delete was successful
     */
    public boolean delete(int id){
        String query = "DELETE FROM appactivity WHERE id = ?";
        
        try(Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            return stmt.executeUpdate() != 0;
        } catch(SQLException ex){
            return false;
        }
    }
}
