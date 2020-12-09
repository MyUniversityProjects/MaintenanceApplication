/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screenbuilders;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import root.Navigable;
import root.Screen;
import root.screens.assignactivity.AssignActivityController;
import root.screens.assignactivity.AssignActivityModel;
import root.screens.assignactivity.AssignActivityView;
/**
 *
 * @author lex99
 */
public class AssignActivityBuilder extends ScreenBuilder{
    
    private AssignActivityController controller;
    private AssignActivityModel model;
    private AssignActivityView view;
    
    private int activityID;
    private int day;
    private String cf;
    
    

    public AssignActivityBuilder(int id) {
        this.activityID = id;
    }

    @Override
    public void buildController() {
        try {
            controller = new AssignActivityController(view, model, activityID);
        } catch (SQLException ex) {
            Logger.getLogger(AssignActivityBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void buildView(Navigable nav) {
        try {
            view = new AssignActivityView(nav);
        } catch (SQLException ex) {
            Logger.getLogger(AssignActivityBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void buildModel() {
        try {
            model = new AssignActivityModel();
        } catch (SQLException ex) {
            Logger.getLogger(AssignActivityBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public Screen getScreen() {
        return view;
    }
    
}
