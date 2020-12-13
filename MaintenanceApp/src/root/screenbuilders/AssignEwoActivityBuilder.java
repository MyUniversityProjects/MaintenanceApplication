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
import root.screens.assignactivity.AssignActivityView;

import root.screens.assignewoactivity.AssignEwoActivityController;
import root.screens.assignewoactivity.AssignEwoActivityModel;
import root.screens.assignewoactivity.AssignEwoActivityView;

/**
 *
 * @author lex99
 */
public class AssignEwoActivityBuilder extends ScreenBuilder{
    private AssignEwoActivityController controller;
    private AssignEwoActivityModel model;
    private AssignActivityView view;
    private int activityID;
    private int day;
    
    public AssignEwoActivityBuilder(int id, int day) {
        this.activityID = id;
        this.day = day;
    }

    @Override
    public void buildController() {
        try {
            controller = new AssignEwoActivityController(view, model, activityID, day, "CCCCCC00C00C000C");
        } catch (SQLException ex) {
            Logger.getLogger(AssignEwoActivityBuilder.class.getName()).log(Level.SEVERE, null, ex);
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
            model = new AssignEwoActivityModel();
        } catch (SQLException ex) {
            Logger.getLogger(AssignEwoActivityBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public Screen getScreen() {
        return view;
    }
}
