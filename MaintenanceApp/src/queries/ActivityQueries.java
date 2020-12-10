package queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
