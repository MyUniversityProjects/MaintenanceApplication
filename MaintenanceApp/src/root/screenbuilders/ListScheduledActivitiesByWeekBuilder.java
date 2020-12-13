/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screenbuilders;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.ActivityQueries;
import root.Navigable;
import root.Screen;
import root.screens.listscheduledactivitiesbyweek.ListScheduledActivitiesByWeekController;
import root.screens.listscheduledactivitiesbyweek.ListScheduledActivitiesByWeekModel;
import root.screens.listscheduledactivitiesbyweek.ListScheduledActivitiesByWeekView;

public class ListScheduledActivitiesByWeekBuilder extends ScreenBuilder {
    private ListScheduledActivitiesByWeekController controller;
    private ListScheduledActivitiesByWeekModel model;
    private ListScheduledActivitiesByWeekView view;
    
   
    
    @Override
    public void buildModel(){
        try {
            model = new ListScheduledActivitiesByWeekModel(new ActivityQueries());
        } catch (SQLException ex) {
            Logger.getLogger(ListScheduledActivitiesByWeekBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void buildController(){
        controller = new ListScheduledActivitiesByWeekController((ListScheduledActivitiesByWeekView) view,model);
    }

    @Override
    public void buildView(Navigable nav) {
        view = new ListScheduledActivitiesByWeekView(nav,model);
    }

    @Override
    public Screen getScreen() {
        return view;
    }
    
}
