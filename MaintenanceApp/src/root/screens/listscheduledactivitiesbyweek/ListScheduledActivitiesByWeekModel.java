
package root.screens.listscheduledactivitiesbyweek;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ListScheduledActivitiesByWeekModel implements Serializable {
    private String title;
    private boolean isVisible;
    // Used when notifying listeners so they know what has changed
    public static final String NUMWEEK_CHANGE = "numweek";
    
    private Integer currentNumWeek;
    private final ComboBoxModel<Integer> numWeekComboBoxModel;
    private DefaultTableModel ScheduledActivitiesTableModel;
    // This class is observable
    private PropertyChangeSupport changeSupport;
    static final String DBMS_URL = "jdbc:postgresql://ec2-46-137-124-19.eu-west-1.compute.amazonaws.com:5432/d5qf11bpj4ug0e";
    static final String USER = "iekjwlviubdoza";
    static final String PWD = "4b7ae6fe88334715c35cdabf0aa73c90d9102dd1f89a240cc164971a1c63e4ca";    
    
    public ListScheduledActivitiesByWeekModel() throws SQLException {
        changeSupport = new PropertyChangeSupport(this);
        numWeekComboBoxModel = new  DefaultComboBoxModel(numWeekIntegerArray());
        currentNumWeek = numWeekComboBoxModel.getElementAt(0);
        createTableModel();
        changeSupport = new PropertyChangeSupport(this);
    }
    
    
    public String getTitle(){
        return null;
    }
    
    public boolean getIsVisible(){
        return false;
    }
    
    public ComboBoxModel<Integer> getNumWeekComboBoxModel(){
        return this.numWeekComboBoxModel;
    }
    
    public DefaultTableModel getScheduledActivitiesTableModel(){
        return this.ScheduledActivitiesTableModel;
    }
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
    
    public Integer getNumWeek(){
        return currentNumWeek;
    }
    
    public void addPropertyChangeListener(
                        PropertyChangeListener pcl) {
        changeSupport.addPropertyChangeListener(pcl);
    }
    
    public void removePropertyChangeListener(
                        PropertyChangeListener pcl) {
        changeSupport.removePropertyChangeListener(pcl);
    }
    
    public String[][] getCurrentNumWeekScheduledActivities() throws SQLException{
        try {
            String[][] currentNumWeekScheduledActivitiesMatrix = null;    
            Connection conn = DriverManager.getConnection(DBMS_URL, USER, PWD);
            Statement stmQuery = conn.createStatement();
            System.out.print("connessione riuscita");
            String queryCount = "select count(*) as num from appactivity WHERE week = " + currentNumWeek;
            ResultSet rst = stmQuery.executeQuery(queryCount);
            rst.next();
            int numActivities = rst.getInt("num");
            currentNumWeekScheduledActivitiesMatrix = new String[numActivities][4];
            String queryCurrentNumWeekScheduledActivities = "SELECT id,area,typology,estimated_time FROM appactivity WHERE week = " + currentNumWeek + "order by id";            
            rst = stmQuery.executeQuery(queryCurrentNumWeekScheduledActivities);
            System.out.print(rst);
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
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public  DefaultTableModel createTableModel() throws SQLException{
        this.ScheduledActivitiesTableModel = new DefaultTableModel(this.getCurrentNumWeekScheduledActivities(),new String [] {"ID", "AREA", "TYPE", "ESTIMATED INTERVENTION TIME [min]"});
        return ScheduledActivitiesTableModel;
    }
    
    public String getSelectedActivity(int index){
        return  (String) this.ScheduledActivitiesTableModel.getValueAt(index, 0);
    }
    private Integer[] numWeekIntegerArray() {
        int[] a = new int[52];
        for (int i = 0; i < 52; ++i) {
            a[i] = i+1;
        }
        //Converting the int array, to an Integer one
        return Arrays.stream(a).boxed().toArray( Integer[]::new );
    }
    
    
}
