package root.screens.manageactivity;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import root.Activity;
import root.Settings;

/**
 *
 * @author giand
 */
public class ManageActivityModel {
    private Connection conn;

    public ManageActivityModel() {
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
    
    public List<Activity> getActivities(){
        List<Activity> activities = new LinkedList<>();
        
        String query = "SELECT * FROM appactivity";
        
        System.out.println("Fetch infos");
        
        try {
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
                        rs.getString("workspace_notes"), rs.getString("type_activity"));
                    activities.add(activity);
                }
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());                
        }
        
        return activities;
    }
    
    
}
