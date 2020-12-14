package root;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import root.screenbuilders.ScreenBuilder;
import root.screens.showcasehome.ShowcaseHomeBuilder;

public class MaintenanceApp {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            displayError("postgresql Driver required");
            System.exit(1);
        }
        
        try (Connection conn=Database.getConnection()) {
        } catch (SQLException ex) {
            if (ex.getMessage().contains("authentication failed")) {
                displayError("Authentication to the database failed!");
            } else {
                displayError(ex.getMessage());
            }
            System.exit(2);
        }
        
        EventQueue.invokeLater(() -> {
            ScreenBuilder b = new ShowcaseHomeBuilder();
            new Navigator("Smart Maintenance App", b).setVisible(true);
        });
    }
    
    public static void displayError(String msg) {
        System.out.println("ERROR: " + msg);
        JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
