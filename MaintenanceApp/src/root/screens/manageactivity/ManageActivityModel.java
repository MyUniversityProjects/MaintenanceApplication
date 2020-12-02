package root.screens.manageactivity;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import root.entities.Activity;
import static root.Database.getConnection;

/**
 *
 * @author giand
 */
public class ManageActivityModel {

    public ManageActivityModel() {
    }
    
    /**
     * Take from the database the activities
     * 
     * @return a list of Activities
     */
    
    public List<Activity> getActivities(){
        
        Connection conn = openConnection();
        
        if(conn == null){
            return new LinkedList<>();
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
                        rs.getString("workspace_notes"), Activity.ActivityType.valueOf(rs.getString("type_activity")));
                    activities.add(activity);
                }
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());                
        }
        
        closeConnection(conn);
        
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
        
        boolean flag;
        Connection conn = openConnection();
        
        if(conn == null){
            return false;
        }
        
        String query = "DELETE FROM appactivity WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            stmt.executeUpdate();
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());                
            }
            flag=true;
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
            flag = false;      
        }        
        closeConnection(conn);
        return flag;
    }
    
    private void closeConnection( Connection conn ){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());                
        }
    }
    
    private Connection openConnection(){
        try {
            Connection conn = getConnection();
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    
}
