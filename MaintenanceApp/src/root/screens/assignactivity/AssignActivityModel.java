/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignactivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import root.Database;
import java.lang.String;
        
/**
 *
 * @author lex99
 */
public class AssignActivityModel {
    
    private Connection conn;
    private static Statement stm;
    
    public AssignActivityModel() throws SQLException {
        conn = Database.getConnection();
    }
    
    public Connection getConnection() throws SQLException {
        
        return conn;
    }
    
    public String getWeekActivity(int activityID) throws SQLException {
        
        try {
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT week FROM public.appactivity WHERE id = "+activityID+" ");
            rst.next();
            return rst.getString("week");
        } catch(Exception e){
        System.out.println("ERRORE weekActivity");}
        
        return null;     
    }
    
    public String getNotes(int activityID) throws SQLException {
        
        try {
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT workspace_notes FROM public.appactivity WHERE id = "+activityID+" ");
            rst.next();
            return rst.getString("workspace_notes");
        } catch(Exception e){
        System.out.println("ERRORE notes");}
        
        return null;     
    }
    
    public int getEstimatedTimeActivity(int activityID) {
        try {
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT estimated_time FROM public.appactivity WHERE id = "+activityID+" ");
            rst.next();
            return rst.getInt("estimated_time");
        } catch(Exception e){
        System.out.println("ERRORE estimatedTimeActivity");}
        
        return -1;  
    }
    
    public String getStringActivity(int activityID) throws SQLException {
        try {
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM public.appactivity WHERE id = "+activityID+" ");
            rst.next();
            String s = "";
            s += rst.getString("id") + " - ";
            s += rst.getString("area") + " - ";
            s += rst.getString("typology") + " - ";
            s += rst.getString("estimated_time") + "'";
            
            return s;
        } catch(Exception e){
        System.out.println("ERRORRE stringActivity");}
        
        return null;     
    }
    
    public String getNameMaintainer(String cf) {
        try {
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM public.appuser WHERE cf = '"+cf+"' ");
            rst.next();
            return rst.getString("name") + " " + rst.getString("surname");
        } catch(Exception e){
        System.out.println("ERRORE nameMaintainer");}
        
        return null;  
    }
    
    public int[] getDayAvaibility(String cf, String week, int day) throws SQLException{
        
        int[] avaibilityDay = {60, 60, 60, 60, 60, 60, 60};
        int i = 0;
        
        
        try {
            stm = conn.createStatement();
            String query = "SELECT * FROM (public.appactivity INNER JOIN public.assignment ON public.appactivity.id = public.assignment.activity)"
                + " WHERE (day = "+Integer.toString(day)+") AND (week = "+week+") AND (maintainer = '"+cf+"')";
            ResultSet rst = stm.executeQuery(query);
            while(rst.next()) {
                int oraInizio = rst.getTime("start_time").toLocalTime().getHour();
                int durata = rst.getInt("estimated_time");
                if(oraInizio > 12) 
                    i = oraInizio - 10;
                else
                    i = oraInizio - 8;
                if (avaibilityDay[i] <= durata) {
                    int d = durata;
                    d -= avaibilityDay[i];
                    avaibilityDay[i+1] -= d;
                    avaibilityDay[i] = 0;
                    
                    
                } 
                else
                    avaibilityDay[i] -= durata;
                    
                
            }
            
        } catch(Exception e){
        System.out.println("ERRORE getDayAvaibility");}
        
        return avaibilityDay;
    }
    
    public int insertAssign(String cf, int activityID, int day, LocalTime start_time, LocalTime end_time) throws SQLException {
        try {
            String query = "INSERT INTO public.assignment(day,start_time,end_time,maintainer,activity)"
                + "VALUES ("+ Integer.toString(day) +",'"
                + start_time.toString() + "','"
                + end_time.toString() + "','"
                + cf + "',"
                + Integer.toString(activityID) + ")";
            stm = conn.createStatement();
            return stm.executeUpdate(query);
            
            
        } catch(Exception e){
        System.out.println("");   
        return 0;
        }
    }
    
    public int removeAssign(String cf, int activityID) throws SQLException{
        try {
            String query = "DELETE FROM public.assignment WHERE maintainer = '" + cf + "' AND activity = " + activityID;
            System.out.println(query);
            stm = conn.createStatement();
            int u = stm.executeUpdate(query);
            System.out.println("DELETE: " + u);
            return u;
            
            
        } catch(Exception e){
        System.out.println("ERRORE removeAssign");   
        return 0;
        }
    }
    
    public String[][] getMaintainers() throws SQLException{
        try {
            stm = conn.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM public.appuser WHERE user_role = 'M'");
            int i = 0;
            
            ArrayList<ArrayList<String>> maintainers = new ArrayList<ArrayList<String>>();
            
            while(rst.next()) {
                ArrayList<String> field = new ArrayList<String>();
                field.add(rst.getString("name"));
                field.add(rst.getString("cf"));
                field.add(rst.getString("surname"));
                maintainers.add(field);
                i++;
                
            }
            
            String[][] vector = new String[3][i];
            
            for(int j=0; j<i; j++) {
                vector[0][j] = (String) maintainers.get(j).get(0);
                vector[1][j] = (String)  maintainers.get(j).get(1);
                vector[2][j] = (String)  maintainers.get(j).get(1);
            }
            
            return vector;
            
        } catch(Exception e){
        System.out.println("ERRORE Maintainers");}
        
        return null;  
    }
    
}
