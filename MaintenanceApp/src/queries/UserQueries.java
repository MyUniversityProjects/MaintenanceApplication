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
}
