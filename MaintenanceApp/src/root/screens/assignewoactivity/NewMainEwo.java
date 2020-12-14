/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignewoactivity;

import java.awt.EventQueue;
import root.Navigable;
import root.Navigator;
import root.Screen;
import root.screenbuilders.AssignEwoActivityBuilder;
import root.screenbuilders.ScreenBuilder;
import root.screens.showcasehome.ShowcaseHomeBuilder;

/**
 *
 * @author lex99
 */
public class NewMainEwo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) { 
            System.out.println("ERROR: postgresql Driver required");
            return;
        }
        
        EventQueue.invokeLater(() -> {
            ScreenBuilder b = new AssignEwoActivityBuilder(2222, 2);
            new Navigator("Smart Maintenance App", b).setVisible(true);
        });
        
    }
    
}
