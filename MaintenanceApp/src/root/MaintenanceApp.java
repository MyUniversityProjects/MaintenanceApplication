package root;

import java.awt.EventQueue;
import root.screenbuilders.PlannerHomeBuilder;
import root.screenbuilders.ScreenBuilder;

public class MaintenanceApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ScreenBuilder b = new PlannerHomeBuilder();
            new Navigator("Smart Maintenance App", b).setVisible(true);
        });
    }
}
