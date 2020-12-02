
package root.screens.listscheduledactivitiesbyweek;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import root.Database;

public class ListScheduledActivitiesByWeekModel implements Serializable {
    // Used when notifying listeners so they know what has changed
    public static final String NUMWEEK_CHANGE = "numweek";
    
    private Integer currentNumWeek;
    private final ComboBoxModel<Integer> numWeekComboBoxModel;
    private DefaultTableModel ScheduledActivitiesTableModel;
    // This class is observable
    private PropertyChangeSupport changeSupport;
    
    /**
     * Create and return an instance of ListScheduledActivitiesByWeekModel that supports
     * the propertychangesupport.
     * @throws SQLException
     */
    public ListScheduledActivitiesByWeekModel() throws SQLException {
        changeSupport = new PropertyChangeSupport(this);
        numWeekComboBoxModel = new  DefaultComboBoxModel(numWeekIntegerArray());
        currentNumWeek = numWeekComboBoxModel.getElementAt(0);
        createTableModel();
        changeSupport = new PropertyChangeSupport(this);
    } 
    
    /**
     * Returns the comboboxmodel for the combobox used in the view. 
     * @return  the comboboxmodel of the NumWeekComboBox of the view.
     */
    public ComboBoxModel<Integer> getNumWeekComboBoxModel(){
        return this.numWeekComboBoxModel;
    }
    
    /**
     * Returns the tablemodel for the table used in the view. 
     * @return  the DefaultTableModel of the scheduledActivitiesTable of the view.
     */
    public DefaultTableModel getScheduledActivitiesTableModel(){
        return this.ScheduledActivitiesTableModel;
    }
    
    /**
     * Set the new currentNumWeek, giving a notification to the listener, using the changeSupport 
     * @param newNumWeek new current week to set 
     */
    public void setNumWeek(Integer newNumWeek){
         if (!Objects.equals(newNumWeek, currentNumWeek)) {
            Integer previousNumWeek = currentNumWeek;
            currentNumWeek = newNumWeek;
            changeSupport.firePropertyChange
                                    (NUMWEEK_CHANGE,
                                     previousNumWeek,
                                     currentNumWeek);
        }
    }
    
    /**
     * Returns the current number of the week  
     * @return  current week number.
     */
    public Integer getNumWeek(){
        return currentNumWeek;
    }
    
    /**
     * Add the propertyChangeListener
     * @param pcl propertyChangeListener
     */
    public void addPropertyChangeListener(
                        PropertyChangeListener pcl) {
        changeSupport.addPropertyChangeListener(pcl);
    }
    
    /**
     * Remove the propertyChangeListener
     * @param pcl propertyChangeListener
     */
    public void removePropertyChangeListener(
                        PropertyChangeListener pcl) {
        changeSupport.removePropertyChangeListener(pcl);
    }
    
     /**
     * Gets the id,area,typology and estimated time of the Scheduled Activities of the current num week from the database
     * @return a Matrix of Strings having the elements that are going to be used to create the tablemodel 
     * @throws java.sql.SQLException
     */
    public String[][] getCurrentNumWeekScheduledActivities() throws SQLException{
        try {
            String[][] currentNumWeekScheduledActivitiesMatrix = null;    
            Connection conn = Database.getConnection();
            Statement stmQuery = conn.createStatement();
            String queryCount = "select count(*) as num from appactivity WHERE week = " + currentNumWeek +"AND type_activity = 'PLANNED'";
            ResultSet rst = stmQuery.executeQuery(queryCount);
            rst.next();
            int numActivities = rst.getInt("num");
            currentNumWeekScheduledActivitiesMatrix = new String[numActivities][4];
            String queryCurrentNumWeekScheduledActivities = "SELECT id,area,typology,estimated_time FROM appactivity WHERE week = " + currentNumWeek+"AND type_activity = 'PLANNED' order by id";            
            rst = stmQuery.executeQuery(queryCurrentNumWeekScheduledActivities);
            int count = 0;
            while (rst.next()) {
                currentNumWeekScheduledActivitiesMatrix[count][0] = Integer.toString(rst.getInt("id"));
                currentNumWeekScheduledActivitiesMatrix[count][1] = rst.getString("area");
                currentNumWeekScheduledActivitiesMatrix[count][2] = rst.getString("typology");
                currentNumWeekScheduledActivitiesMatrix[count][3] = Integer.toString(rst.getInt("estimated_time"));
                count++;
            }
            return currentNumWeekScheduledActivitiesMatrix;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    /**
     * Create the DefaultTableModel used for the table of the view
     * @return DefaultTableModel having as the columns ID,AREA,TYPE and ESTIMATED INTERVTION TIME 
     * @throws java.sql.SQLException
     */
    public  DefaultTableModel createTableModel() throws SQLException{
        this.ScheduledActivitiesTableModel = new DefaultTableModel(this.getCurrentNumWeekScheduledActivities(),new String [] {"ID", "AREA", "TYPE", "ESTIMATED INTERVENTION TIME [min]"});
        return ScheduledActivitiesTableModel;
    }
    
    /**
     * Returns the id of the Activity selected
     * @param index index of Activity in the table 
     * @return the id of the activity
     */
    public int getSelectedActivity(int index){
        return  Integer.parseInt((String) this.ScheduledActivitiesTableModel.getValueAt(index, 0)) ;
    }
    
    /**
     * Returns the array  of week numbers
     * @return array  of week numbers
     */
    private Integer[] numWeekIntegerArray() {
        int[] a = new int[52];
        for (int i = 0; i < 52; ++i) {
            a[i] = i+1;
        }
        //Converting the int array, to an Integer one
        return Arrays.stream(a).boxed().toArray( Integer[]::new );
    }
    
    
}
