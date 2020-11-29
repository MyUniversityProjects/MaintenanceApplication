package root;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String DBMS_URL = "jdbc:postgresql://ec2-46-137-124-19.eu-west-1.compute.amazonaws.com:5432/d5qf11bpj4ug0e";
    public static final String USER = "iekjwlviubdoza";
    public static final String PWD = "4b7ae6fe88334715c35cdabf0aa73c90d9102dd1f89a240cc164971a1c63e4ca";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBMS_URL, USER, PWD);
    }
}
