/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignewoactivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import root.screens.assignactivity.AssignActivityModel;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author lex99
 */
public class AssignEwoActivityModel extends AssignActivityModel{
    
    public AssignEwoActivityModel() throws SQLException {
        super();
    }
    
    @Override
    protected String getStringQueryDayAvaibility(String cf, String week, int day) {
        String query = super.getStringQueryDayAvaibility(cf, week, day) + " AND (interruptible = false) ";
        return query;     
    }
    
    protected LocalTime getStartTimeAssignment(int activityID) {
        try {
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT start_time FROM public.appactivity WHERE id = "+activityID+" ");
            rst.next();
            return rst.getTime("start_time").toLocalTime();
        } catch(Exception e){
        System.out.println("ERRORE weekActivity");}
        return null;
    }
    
    protected LocalTime getEndTimeAssignment(int activityID) {
        try {
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT end_time FROM public.appactivity WHERE id = "+activityID+" ");
            rst.next();
            return rst.getTime("end_time").toLocalTime();
        } catch(Exception e){
        System.out.println("ERRORE weekActivity");}
        return null;
    }
    
    
}
