package root.screens.modifyselectedactivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import root.Database;
import root.entities.Activity;
import root.exceptions.NotFoundException;


public class ModifySelectedActivityModel extends Activity {
    public ModifySelectedActivityModel(int id, String area, String branchOffice, String typology, String description, int time, boolean interruptible, int week, String notes, ActivityType type) {
        super(id, area, branchOffice, typology, description, time, interruptible, week, notes, type);
    }
    
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
    
    
}
