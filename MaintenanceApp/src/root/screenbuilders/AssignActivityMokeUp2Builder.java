/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screenbuilders;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import root.screens.assignactivity.AssignActivityControllerMokeUp2;
import root.screens.assignactivity.AssignActivityModel;
import root.screens.assignactivity.AssignActivityView;

/**
 *
 * @author lex99
 */
public class AssignActivityMokeUp2Builder extends AssignActivityBuilder{
    AssignActivityControllerMokeUp2 controller;
    int day;
    String cf;
    
    public AssignActivityMokeUp2Builder(int id, int day, String cf) {
        super(id);
        this.day = day;
        this.cf = cf;
    }
    
    @Override
    public void buildController() {
        try {
            controller = new AssignActivityControllerMokeUp2(view, model, activityID, day, cf);
        } catch (SQLException ex) {
            Logger.getLogger(AssignActivityBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
