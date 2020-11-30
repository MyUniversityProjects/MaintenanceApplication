/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignactivity;

import java.sql.SQLException;

/**
 *
 * @author lex99
 */
public class AssignActivityController {
    private int activityID;
    private String cf;
    private int day;
    private AssignActivityModel model;
      
    public AssignActivityController(int activityID, String cf, int day) throws SQLException {
        this.activityID = activityID;
        this.cf = cf;
        this.day = day;
        model = new AssignActivityModel();
    }
    public String weekActivity() throws SQLException {
        return model.getWeekActivity(activityID);
    }
    
    public int estimatedTimeActivity() {
        return model.getEstimatedTimeActivity(activityID);
    }
    
    public String stringActivity() throws SQLException {
        return model.getStringActivity(activityID);
    }
    
    public String nameMaintainer() throws SQLException {
        return model.getNameMaintainer(cf);
    }
    
    public int[] dayAvaibility(String week) throws SQLException {
        return model.getDayAvaibility(cf, week, day);
    }
    
    public int assignActivity(int day, int start_time, int end_time) throws SQLException {
        return model.insertAssign(cf, activityID, day, start_time, end_time);
        
                                              
    }
}
