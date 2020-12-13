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
import root.screens.modifyuser.ModifyUserModel;

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
     *Database query that modify a user
     * @param user information to be entered
     * @return if the modify was successful
     */
    public boolean modify(User user) {

        String query = "UPDATE appuser SET cf = ?, name = ?, surname = ?,"
                + " address = ?, email = ?, username = ?, pass = ?,"
                + " user_role = ? WHERE cf = ?";
        
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getCf());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getSurname());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getUsername());
            stmt.setString(7, user.getPassword());
            stmt.setString(8, user.getRole().toString());
            stmt.setString(9, user.getInitCf());

            int ris = stmt.executeUpdate();
            
            if(ris == 0){
                return false;
            }

            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
            return false;
        }
    }

    /**
     *Database query that return a User
     * @param cf user identifier
     * @return an instance of User if it is present otherwise null
     */
    public User getUser(String cf) {
        String query = "SELECT * FROM appuser WHERE cf=?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, cf);
            ResultSet rst = stmt.executeQuery();

            if (!rst.next()) {
                return null;
            }

            User user = new User(
                    rst.getString("name"),
                    rst.getString("surname"),
                    rst.getString("cf"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("username"),
                    rst.getString("pass"),
                    ModifyUserModel.convertRawRole(rst.getString("user_role"))
            );
            conn.close();
            return user;
        } catch(Exception ex){
            return null;
        }
    }
    /*
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
