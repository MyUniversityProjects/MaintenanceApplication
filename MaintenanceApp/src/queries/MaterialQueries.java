package queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import root.Database;
import root.exceptions.QueryFailedException;

public class MaterialQueries {
    public String[] fetchAll() {
        try (Connection conn = Database.getConnection()) {
            ResultSet rst = conn.prepareStatement("SELECT name FROM Material").executeQuery();
            
            List<String> materials = new LinkedList<>();
            while (rst.next())
                materials.add(rst.getString("name"));
            return materials.toArray(new String[materials.size()]);
        } catch (SQLException ex) {
            throw new QueryFailedException(ex.getMessage());
        }
    }
}
