
package root;

import java.awt.EventQueue;
import root.screenbuilders.ScreenBuilder;
import root.screens.showcasehome.ShowcaseHomeBuilder;

public class MaintenanceApp {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) { 
            System.out.println("ERROR: postgresql Driver required");
            return;
        }
        
        EventQueue.invokeLater(() -> {
            ScreenBuilder b = new ShowcaseHomeBuilder();
            new Navigator("Smart Maintenance App", b).setVisible(true);
        });
    }
}
