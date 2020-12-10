package root;

import java.awt.EventQueue;
import root.screenbuilders.PlannerHomeBuilder;
import root.screenbuilders.ScreenBuilder;

public class MaintenanceApp {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) { 
            System.out.println("ERROR: postgresql Driver required");
            return;
        }
        
        EventQueue.invokeLater(() -> {
            ScreenBuilder b = new PlannerHomeBuilder();
            new Navigator("Smart Maintenance App", b).setVisible(true);
        });
    }
}
