/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.createuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static root.Database.getConnection;

/**
 *
 * @author ficca
 */
public class UserQueries {
    private Connection conn;
    private String error;
    private int errorCode;
    private String databaseError = "";

    private boolean openConnection(){
        try {
            conn = getConnection();
            return true;
        } catch (SQLException ex) {
            error = ex.getMessage();
            errorCode = ex.getErrorCode();            
            return false;
        }
    }
    
    private boolean closeConnection(){
        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            error = ex.getMessage();
            errorCode = ex.getErrorCode();            
            return false;
        }
    }
    
    public boolean insertIntoAppUser(User user){
        boolean flag;
        String query = "INSERT INTO appuser "+
            "(cf, username, pass, user_role, name,"+
            "surname, email, address) VALUES "+
            "(?, ?, ?, ?, ?, ?, ?, ?)";
        flag = openConnection();
        if(flag){     
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, user.getCf());
                stmt.setString(2,user.getUsername());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getRole().toString());
                stmt.setString(5, user.getName());
                stmt.setString(6, user.getSurname());
                stmt.setString(7, user.getEmail());
                stmt.setString(8, user.getAddress());
                
                stmt.executeUpdate();   
                flag = closeConnection();
            } catch(SQLException ex){
                error = ex.getMessage();
                errorCode = ex.getErrorCode();            
                flag = false;    
            }
        }
        
        
        return flag;
    }

    public String getDatabaseError(){
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
