package root;

import java.awt.EventQueue;

public class MaintenanceApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Navigator().setVisible(true);
        });
    }
}
