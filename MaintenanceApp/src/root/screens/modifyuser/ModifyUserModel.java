package root.screens.modifyuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import root.Database;
import root.exceptions.NotFoundException;

public class ModifyUserModel extends User{

    public ModifyUserModel(String name, String surname, String cf, String email,
            String address, String username, String password, UserType role) {
        super(name, surname, cf, email, address, username, password, role);
    }
    
    /**
     *Create and return an istance of ModifyUserModel fetching
     * data from database
     * 
     * @param cf User identifier
     * @return an istance of ModifyUserModel
     * @throws java.sql.SQLException
     * @throws root.exceptions.NotFoundException
     */
    public static ModifyUserModel fromDatabase(String cf) throws SQLException, NotFoundException{
        String query = "SELECT * FROM appuser WHERE cf=?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, cf);
            ResultSet rst = stmt.executeQuery();
            
            if (!rst.next()) throw new NotFoundException();
            
            ModifyUserModel model = new ModifyUserModel(
                    rst.getString("name"),
                    rst.getString("surname"),
                    rst.getString("cf"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("username"),
                    rst.getString("pass"),
                    ModifyUserModel.UserType.valueOf(rst.getString("role"))
            );
            conn.close();
            return model;
        } 
    }
    
    /**
     *Execute the query to modify the user and return if successful
     * 
     * @return if the user has been successfully modified
     * @throws java.sql.SQLException
     */
    public boolean modify() throws SQLException{
        String query = "UPDATE appuser SET"
                + "cf= ?,"
                + "name = ?,"
                + "surname = ?,"
                + "address = ?,"
                + "email = ?,"
                + "username = ?,"
                + "pass = ?,"
                + "role = ? "
                + "WHERE cf = ?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, getCf());
            stmt.setString(2, getName());
            stmt.setString(3, getSurname());
            stmt.setString(4, getAddress());
            stmt.setString(5, getEmail());
            stmt.setString(6, getUsername());
            stmt.setString(7, getPassword());
            stmt.setString(8, getRole().toString());
            stmt.setString(9, getInitCf());
            
            ResultSet rst = stmt.executeQuery();
            
            if (!rst.next()) throw new NotFoundException();
            
            conn.close();
            return true;
        }catch(Exception ex){
            return false;
        }
    }

}
