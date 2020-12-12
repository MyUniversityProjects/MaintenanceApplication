package root.screens.modifyuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import root.Database;
import root.exceptions.NotFoundException;

public class UserQueries {

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

    public User getUser(String cf) throws SQLException, NotFoundException {
        String query = "SELECT * FROM appuser WHERE cf=?";
        try (Connection conn = Database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, cf);
            ResultSet rst = stmt.executeQuery();

            if (!rst.next()) {
                throw new NotFoundException();
            }

            User user = new User(
                    rst.getString("name"),
                    rst.getString("surname"),
                    rst.getString("cf"),
                    rst.getString("email"),
                    rst.getString("address"),
                    rst.getString("username"),
                    rst.getString("pass"),
                    ModifyUserModel.UserType.valueOf(rst.getString("user_role"))
            );
            conn.close();
            return user;
        }
    }
}
