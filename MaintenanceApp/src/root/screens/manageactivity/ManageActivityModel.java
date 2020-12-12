
package root.screens.manageactivity;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import queries.ActivityQueries;
import root.entities.Activity;

/**
 *
 * @author giand
 */
public class ManageActivityModel {
    
    public static final String[] columnNames = {"ID", "Branch Office", "Area", "Typology", "Estimated Time", "Week", "Interruptible", "delete", "edit"};
    private final ActivityQueries query;
    private final DefaultTableModel tableModel;

    public ManageActivityModel(ActivityQueries query) {
        this.query = query;
        this.tableModel = createTableModel(query.fetchAll());
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public static DefaultTableModel createTableModel(List<Activity> activities) {
        String[][] data = new String[activities.size()][columnNames.length];
        for (int i=0; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            data[i][0] = "" + activity.getId();
            data[i][1] = activity.getBranchOffice();
            data[i][2] = activity.getArea();
            data[i][3] = activity.getTypology();
            data[i][4] = "" + activity.getTime();
            data[i][5] = "" + activity.getWeek();
            data[i][6] = "" + activity.isInterruptible();
            data[i][7] = "delete";
            data[i][8] = "edit";
        }
        return new DefaultTableModel(data, columnNames);
    }
    
    /**
     * Take from the database the activities
     * 
     * @return a list of Activities
     */
    
    public List<Activity> getActivities(){
        
       List<Activity> activities = query.fetchAll();
        
        return activities;
    }
    
    /**
     * 
     * Delete from the database tha activity that have 
     * id equal to the passed param
     * 
     * @param id
     * @return if the delete was successful
     */
    
    public boolean delete(int id){
        return query.delete(id);
    }
        
}
