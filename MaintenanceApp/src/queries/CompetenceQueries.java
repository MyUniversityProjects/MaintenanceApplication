package queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import root.Database;
import root.exceptions.QueryFailedException;

public class CompetenceQueries {
    public String[] fetchAll() {
        try (Connection conn = Database.getConnection()) {
            ResultSet rst = conn.prepareStatement("SELECT name FROM Competence").executeQuery();
            
            List<String> competences = new LinkedList<>();
            while (rst.next())
                competences.add(rst.getString("name"));
            return competences.toArray(new String[competences.size()]);
        } catch (SQLException ex) {
            throw new QueryFailedException(ex.getMessage());
        }
    }
}
