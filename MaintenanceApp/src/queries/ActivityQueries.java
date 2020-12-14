package queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import root.Database;
import static root.Database.getConnection;
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
        try (Connection conn = Database.getConnection()) {
            // fetch activity and check if there is a result
            ResultSet activityRes = simpleFetch(conn, id);
            if (!activityRes.next()) throw new NotFoundException();
            
            return new Activity(
                activityRes.getInt("id"),
                activityRes.getString("area"),
                activityRes.getString("branch_office"),
                activityRes.getString("typology"),
                activityRes.getString("description"),
                activityRes.getInt("estimated_time"),
                activityRes.getBoolean("interruptible"),
                activityRes.getInt("week"),
                activityRes.getString("workspace_notes"),
                Activity.convertRawType(activityRes.getString("type_activity"))
            );
        } catch(SQLException ex) {
            throw new QueryFailedException(ex.getMessage());
        }
    }
    
    /**
     * Create and return an instance of Activity by fetching the activity,
     * materials and competences data.
     * @param id activity identifier
     * @return the fetched activity
     * @throws NotFoundException if the activity is not found
     * @throws QueryFailedException if app is unable to query the database
     */
    public Activity fetchComplete(int id) throws NotFoundException {
        try (Connection conn = Database.getConnection()) {
            // fetch activity and check if there is a result
            ResultSet activityRes = simpleFetch(conn, id);
            if (!activityRes.next()) throw new NotFoundException();
            
            // fetch activity materials
            String[] materials = fetchActivityMaterials(conn, id);
            // fetch activity competences
            String[] competences = fetchActivityCompetences(conn, id);
            
            return new Activity(
                activityRes.getInt("id"),
                activityRes.getString("area"),
                activityRes.getString("branch_office"),
                activityRes.getString("typology"),
                activityRes.getString("description"),
                activityRes.getInt("estimated_time"),
                activityRes.getBoolean("interruptible"),
                activityRes.getInt("week"),
                activityRes.getString("workspace_notes"),
                Activity.convertRawType(activityRes.getString("type_activity")),
                materials,
                competences
            );
        } catch (SQLException ex) {
            throw new QueryFailedException(ex.getMessage());
        }
    }
    
    private ResultSet simpleFetch(Connection conn, int id) throws SQLException {
        String query = "SELECT id, area, branch_office, typology, description, estimated_time, interruptible, week, workspace_notes, type_activity, verified FROM AppActivity WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        return stmt.executeQuery();
    }
    
    private String[] fetchActivityMaterials(Connection conn, int id) throws SQLException {
        String query = "SELECT material FROM ActivityMaterials WHERE activity=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rst = stmt.executeQuery();
        
        List<String> materials = new LinkedList<>();
        while (rst.next())
            materials.add(rst.getString("material"));
        return materials.toArray(new String[materials.size()]);
    }
    
    private String[] fetchActivityCompetences(Connection conn, int id) throws SQLException {
        String query = "SELECT competence FROM ActivityCompetences WHERE activity=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rst = stmt.executeQuery();
        
        List<String> competences = new LinkedList<>();
        while (rst.next())
            competences.add(rst.getString("competence"));
        return competences.toArray(new String[competences.size()]);
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
     * @param materials to add to the activity
     * @param competences to add to the activity
     * @throws NotFoundException if the activity is not found
     * @throws QueryFailedException if app is unable to query the database
     */
    public void forwardEwo(int id, String desc, int time, String[] materials, String[] competences) throws NotFoundException {
        String query = "UPDATE AppActivity SET description=?, estimated_time=?, verified=TRUE WHERE id=?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, desc);
            stmt.setInt(2, time);
            stmt.setInt(3, id);
            int res = stmt.executeUpdate();
            if (res == 0) throw new NotFoundException("Activity not found");
            
            
            // remove all the materials not needed
            query = "DELETE FROM ActivityMaterials WHERE activity=?";
            if (materials.length > 0) {
                String[] tmp = new String[materials.length];
                for (int i = 0; i < tmp.length; i++) tmp[i] = "?";
                query += " AND material not in (" + String.join(", ", tmp) + ")";
            }
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            for (int i = 0; i < materials.length; i++) {
                stmt.setString(i + 2, materials[i]);
            }
            stmt.executeUpdate();
            
            // add all materials to the activity
            query = "INSERT INTO ActivityMaterials(activity, material) VALUES (?, ?)";
            for (String material: materials) {
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, id);
                stmt.setString(2, material);
                try {
                    stmt.executeUpdate();
                } catch(SQLException ex) {}
            }
            
            // remove all competences not needed
            query = "DELETE FROM ActivityCompetences WHERE activity=?";
            if (competences.length > 0) {
                String[] tmp = new String[competences.length];
                for (int i = 0; i < tmp.length; i++) tmp[i] = "?";
                query += " AND competence not in (" + String.join(", ", tmp) + ")";
            }
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            for (int i = 0; i < competences.length; i++) {
                stmt.setString(i + 2, competences[i]);
            }
            stmt.executeUpdate();
            
            // add all competences to the activity
            query = "INSERT INTO ActivityCompetences(activity, competence) VALUES (?, ?)";
            for (String competence: competences) {
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, id);
                stmt.setString(2, competence);
                try {
                    stmt.executeUpdate();
                } catch(SQLException ex) {}
            }
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
    
    public boolean modify(Map<String, String> inputMap){
        String query = "UPDATE appactivity "
                + "SET branch_office = ?,area = ?,typology = ?,description = ?,estimated_time = ?,interruptible = ?,workspace_notes = ? "
                + "WHERE id = ? ";
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, inputMap.get("branch_office"));
            stmt.setString(2, inputMap.get("area"));
            stmt.setString(3, inputMap.get("typology"));
            stmt.setString(4, inputMap.get("description"));
            stmt.setInt(5, Integer.parseInt(inputMap.get("estimated_time")));
            stmt.setBoolean(6, Boolean.parseBoolean(inputMap.get("interruptible")));
            stmt.setString(7, inputMap.get("workspace_notes"));
            stmt.setInt(8, Integer.parseInt(inputMap.get("id")));

            stmt.executeUpdate();   
            return true;
        } catch(SQLException ex){
            return false;      
        }
    }
 
    /**
     * Gets the id,area,typology and estimated time of the Scheduled Activities of the current num week from the database
     * @param currentNumWeek
     * @return a Matrix of Strings having the elements that are going to be used to create the tablemodel 
     * @throws java.sql.SQLException
     */
    public String[][] getCurrentNumWeekScheduledActivities(int currentNumWeek) throws SQLException{
        try {
            String[][] currentNumWeekScheduledActivitiesMatrix = null;    
            Connection conn = Database.getConnection();
            Statement stmQuery = conn.createStatement();
            String queryCurrentNumWeekScheduledActivities = "SELECT appactivity.id,appactivity.area,"
                    + "appactivity.typology,appactivity.estimated_time FROM appactivity"
                    + " WHERE week = " + currentNumWeek +"AND type_activity = 'PLANNED' "
                    + " EXCEPT "
                    + "select appactivity.id,appactivity.area,"
                    + "appactivity.typology,appactivity.estimated_time "
                    + "FROM appactivity INNER JOIN assignment ON appactivity.id=assignment.activity "
                    + "WHERE week = " + currentNumWeek +"AND type_activity = 'PLANNED' order by id"; 
            String queryCount = "select count(*) as num "
                    + "FROM ("+ queryCurrentNumWeekScheduledActivities + ") as notassigned";
            ResultSet rst = stmQuery.executeQuery(queryCount);
            rst.next();
            int numActivities = rst.getInt("num");
            currentNumWeekScheduledActivitiesMatrix = new String[numActivities][5];           
            rst = stmQuery.executeQuery(queryCurrentNumWeekScheduledActivities);
            int count = 0;
            while (rst.next()) {
                currentNumWeekScheduledActivitiesMatrix[count][0] = Integer.toString(rst.getInt("id"));
                currentNumWeekScheduledActivitiesMatrix[count][1] = rst.getString("area");
                currentNumWeekScheduledActivitiesMatrix[count][2] = rst.getString("typology");
                currentNumWeekScheduledActivitiesMatrix[count][3] = Integer.toString(rst.getInt("estimated_time"));
                currentNumWeekScheduledActivitiesMatrix[count][4] = "select";
                count++;
            }
            return currentNumWeekScheduledActivitiesMatrix;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<String> getTypologies(){
        String query = "SELECT * FROM typology";
        List<String> typologies = new LinkedList<>();
        try(Connection conn = Database.getConnection()){
            Statement stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(query);
            if (rst== null){
                return null;           
            }
            while(rst.next()){
                typologies.add(rst.getString("name"));
            }
            if(typologies.isEmpty()){
                return null;
            } else {
                return typologies;
            }
        }catch(Exception e){
            return null;
        }
    }
}
