package root.screens.manageactivity;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import root.Activity;
import static root.Database.getConnection;

/**
 *
 * @author giand
 */
public class ManageActivityModel {
    private Connection conn = null;

    public ManageActivityModel() {
    }
    
    /**
     * Take from the database the activities
     * 
     * @return a list of Activities
     */
    
    public List<Activity> getActivities(){
        
        if (conn == null){
            try {
            conn = getConnection();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
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
    
    /**
     * 
     * Delete from the database tha activity that have 
     * id equal to the passed param
     * 
     * @param id
     * @return 
     */
    
    public boolean delete(int id){
        
        if(conn == null){
            try {
            conn = getConnection();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        String query = "DELETE FROM appactivity WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            stmt.executeUpdate();   
            return true;
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;      
        }        
    }
    
    
}
