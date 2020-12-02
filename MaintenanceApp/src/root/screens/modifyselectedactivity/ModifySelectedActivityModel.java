package root.screens.modifyselectedactivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import root.Database;
import static root.Database.getConnection;
import root.entities.Activity;
import root.exceptions.NotFoundException;


public class ModifySelectedActivityModel extends Activity {
    public ModifySelectedActivityModel(int id, String area, String branchOffice, String typology, String description, int time, boolean interruptible, int week, String notes, ActivityType type) {
        super(id, area, branchOffice, typology, description, time, interruptible, week, notes, type);
    }
    
    private String error = "";
    private int errorCode;
    /**
     * Create and return an instance of ModifySelectedActivityModel by fetching the
     * data of the activity, from the database
     * @param id activity identifier
     * @return and instance of ModifySelectedActivityModel
     * @throws SQLException
     * @throws NotFoundException 
     */
    public static ModifySelectedActivityModel fromDatabase(int id) throws SQLException, NotFoundException {
        String query = "SELECT id, area, branch_office, typology, description, estimated_time, interruptible, week, workspace_notes, type_activity, verified FROM AppActivity WHERE id=?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rst = stmt.executeQuery();
            
            if (!rst.next()) throw new NotFoundException();
            return new ModifySelectedActivityModel(
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
        }
    }
    /**
     * Modify the activity. 
     * @param inputMap
     * @return true if the modify was successful, false if not successful
     */
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
            stmt.setInt(8, this.getId());

            stmt.executeUpdate();   
            return true;
        } catch(SQLException ex){
            error = ex.getMessage();
            errorCode = ex.getErrorCode();            
            return false;      
        }
    
    }

    public int getErrorCode(){
        return errorCode;
    }
}
    

