package root.screens.createactivity;


import root.Activity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import root.Settings;

public class ActivityModel {

    private Connection conn = null;
    private String error = "";
    private int errorCode;

    public ActivityModel() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(
                    Settings.DBMS_URL,
                    Settings.USER,
                    Settings.PWD
            );
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
    public String getError(){
        return error;
    }
    
    
    public int getErrorCode(){
        return errorCode;
    }

    public boolean create(Activity activity){
        String query = "INSERT INTO appactivity "+
            "(id, branch_office, area, typology, description,"+
            "estimated_time, interruptible, week, workspace_notes,"+
            "type_activity) VALUES "+
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, activity.getId());
            stmt.setString(2,activity.getBranch_office());
            stmt.setString(3, activity.getArea());
            stmt.setString(4, activity.getTypology());
            stmt.setString(5, activity.getDescription());
            stmt.setInt(6, activity.getEstimated_time());
            stmt.setBoolean(7, activity.isInterruptible());
            stmt.setInt(8, activity.getWeek());
            stmt.setString(9, activity.getWorkspace_notes());
            stmt.setString(10, activity.getType_activity());

            stmt.executeUpdate();   
            return true;
        } catch(SQLException ex){
            error = ex.getMessage();
            errorCode = ex.getErrorCode();            
            return false;      
        }
    }
}
