/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignactivity;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lex99
 */
public class AssignActivityControllerMokeUp2 extends AssignActivityController{
    int day;
    String cf;
    
    public AssignActivityControllerMokeUp2(AssignActivityView view, AssignActivityModel model, int activityID, int day, String cf) throws SQLException {
        super(view, model, activityID);
        this.day = day;
        this.cf = cf;
        setTable();
        setArea();
        view.getLabelNumberOfWeek().setText(week + " Day: "+stringDay(day));
          
    }
    
    @Override
    protected void setTable() throws SQLException{
        String[] cols = {"Maintainer","Skills","8-00 - 9.00","9.00 - 10.00","10.00 - 11.00", "11.00-12-00","14.00 - 15.00","15.00 - 16.00","16-00 - 17.00"};
        tableModel.setColumnIdentifiers(cols);
        writeRowAvaibilityDayMaintainer(cf, 0);
    }
    
    @Override
    protected void setArea() throws SQLException{
        jArea.setText(model.getNotes(activityID));
    }
    
    @Override
    protected void setButtonAssign() {
        int result = -3;
        try {
            result = assignActivity(view.getCol(), activityID, cf, week, day);
        } catch (SQLException ex) {
            Logger.getLogger(AssignActivityControllerMokeUp2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        if(result == 1) {
            jLabelError.setText("Assignment success");
            view.getNav().goHome();
        }
        if(result == 0) jLabelError.setText("Activity is already assigned");
        if(result == -1) jLabelError.setText("Devi selezionare una cella con dei minuti disponibili");
        if(result == -2) jLabelError.setText("Non c'è abbastanza tempo per svolgere l' attività di manutenzione selezionata");
        if(result == -3) jLabelError.setText("It is verify a error during the assignment");
            
        jLabelError.setVisible(true);
    }
    
    @Override
    protected void setButtonBack() {
        view.getNav().pop();
    }
    
    protected void writeRowAvaibilityDayMaintainer(String code, int index) throws SQLException {
        int[] avaibility = model.getDayAvaibility(code, week, day);
        String nameMaintainer = model.getNameMaintainer(code);
        tableModel.setValueAt(nameMaintainer, 0, 0);
        for(int i=0; i<nCols-2; i++)
            tableModel.setValueAt(avaibility[i], index , i+2);
    }
    
    public Integer assignActivity(int col, int activityID, String cf, String week, int day) throws SQLException {
        int index = col-2;
        int[] avaibility = model.getDayAvaibility(cf, week, day);
        int timeActivity = model.getEstimatedTimeActivity(activityID);
        if((index < 0) || (avaibility[index] == 0)) {
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
    
    protected String stringDay(int day) {
        switch (day) {
            case 1:
                return "Monday";
               
            case 2:
                return "Tuesday";
                
            case 3:
                return "Wednesday";
               
            case 4:
                return "Thursday";
                
            case 5:
                return "Friday";
                
            case 6:
                return "Saturday";
 
            case 7:
                return "Sunday";
            }
        return null;
    }
}
