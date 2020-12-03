/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignactivity;

import java.sql.SQLException;
import java.time.LocalTime;

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
    
    public String notes() throws SQLException {
        return model.getNotes(activityID);
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
    
    public Integer assignActivity(int col, String week) throws SQLException {
        int index = col-2;
        int[] avaibility = dayAvaibility(week);
        int timeActivity = estimatedTimeActivity();
        if(avaibility[index] == 0) {
            return -1; //"ERRORE: Devi selezionare una cella con dei minuti disponibili"
        }
        
        int hourStart, minuteStart, hourEnd, minuteEnd;
        
        if(avaibility[index] < timeActivity) {
            int time = avaibility[index];
            int i = 1;
                while(((index+i)<7) && (avaibility[index+i] == 60) && (time < timeActivity)) {
                    time += 60;
                    i++;
                }
                if(time < timeActivity) 
                    return -2; //"ERRORE: Non c'è abbastanza tempo per svolgere l' attività di manutenzione selezionata"
                                        
        }
        if(col > 5)
            hourStart = col + 8;
        else
            hourStart = col + 6;
                    
        minuteStart = 60 - avaibility[index];
                    
                    
        LocalTime start = LocalTime.of(hourStart, minuteStart);
        LocalTime end = start.plusMinutes(timeActivity);
        
        try {
            int x = model.insertAssign(cf, activityID, day, start, end);
            if (x > 0)
                return 1; //"Assignment carry out with success"
            else 
                return 0;//"Activity is already assigned"
            
        } catch (SQLException ex) {
            System.out.println("ERRORE: ASSEGNAMENTO NON RIUSCITO");
        }
        return -3;
    }
}
