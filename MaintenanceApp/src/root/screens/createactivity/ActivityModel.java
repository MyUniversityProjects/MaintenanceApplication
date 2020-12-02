package root.screens.createactivity;


import root.entities.Activity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static root.Database.getConnection;

public class ActivityModel {

    private String error = "";
    private int errorCode;

    public ActivityModel() {
    }
    
    public String getError(){
        return error;
    }
    
    
    public int getErrorCode(){
        return errorCode;
    }
    /**
     * get an Activity an insert it in the database
     * 
     * @param activity
     * @return 
     */
    public boolean create(Activity activity){
        
        boolean flag;
        Connection conn = null;
        
        try {
            conn = getConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        String query = "INSERT INTO appactivity "+
            "(id, branch_office, area, typology, description,"+
            "estimated_time, interruptible, week, workspace_notes,"+
            "type_activity) VALUES "+
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
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

            stmt.executeUpdate();   
            flag = true;
        } catch(SQLException ex){
            error = ex.getMessage();
            errorCode = ex.getErrorCode();            
            flag = false;      
        }
        
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());                
        }
        
        return flag;
    }
}
