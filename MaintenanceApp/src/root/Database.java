package root;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class that provides utility methods to access a remote database
 */
public class Database {
    public static final String DBMS_URL = "jdbc:postgresql://ec2-54-170-100-209.eu-west-1.compute.amazonaws.com:5432/dequdpq0n89gn3";
    public static final String USER = "fpttaduzjtshag";
    public static final String PWD = "dbf8afb3321a3a9907fc6c4e351deb0895d8a01f62e4f3441cea8d5c28fb9321";
    
    /**
     * Create and returns a new connection to a remote database
     * @return a connection to the database
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBMS_URL, USER, PWD);
    }
}
