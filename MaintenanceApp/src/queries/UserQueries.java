package queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import root.Database;
import root.entities.User;
import root.exceptions.QueryFailedException;

public class UserQueries {

    private String error;
    private String databaseError = "";
    
    
    public User[] fetchPlannersMaintainers() {
        String query = "SELECT cf, username, user_role, name, surname FROM AppUser WHERE user_role='P' or user_role='M'";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rst = stmt.executeQuery();
            
            List<User> users = new LinkedList<>();
            while (rst.next()) {
                users.add(new User(
                        rst.getString("cf"),
                        rst.getString("username"),
                        User.convertRawRole(rst.getString("user_role")),
                        rst.getString("name"),
                        rst.getString("surname"),
                        null,
                        null
                ));
            }
            return users.toArray(new User[users.size()]);
        } catch (SQLException ex) {
            throw new QueryFailedException(ex.getMessage());
        }
    }
    
    public boolean delete(String cf) {
        String query = "DELETE FROM AppUser WHERE cf=?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, cf);
            return stmt.executeUpdate() != 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    /**
     * insert  a new user in the database
     * 
     * @param user
     * @return  true if the insert was successful
     */
    public boolean insertIntoAppUser(root.screens.createuser.User user){
        String query = "INSERT INTO appuser "+
            "(cf, username, pass, user_role, name,"+
            "surname, email, address) VALUES "+
            "(?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = Database.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, user.getCf());
                stmt.setString(2,user.getUsername());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getRole().toString());
                stmt.setString(5, user.getName());
                stmt.setString(6, user.getSurname());
                stmt.setString(7, user.getEmail());
                stmt.setString(8, user.getAddress());                
                return stmt.executeUpdate() != 0;  
            } catch(SQLException ex){
                error = ex.getMessage();
                return false;    
        }    
    }
    
    public String getCreateDatabaseError(){
        databaseError = "";
        if(error.contains("appuser_pkey")){
            databaseError += "the cf has already been entered\n";
        }
        
        if(error.contains("username_un")){
            databaseError += "user has already been used\n";
        }
        
        if(error.contains("ck_cf")){
            databaseError += "The cf doesn't respect the standard format\n";
        }
        
        if(error.contains("ck_email")){
            databaseError += "The email doesn't respect the standard format\n";
        }
        
        if(error.contains("ck_user_role")){
            databaseError += "Role error type \n";
        }
        
        return databaseError;    
    }

    
}
