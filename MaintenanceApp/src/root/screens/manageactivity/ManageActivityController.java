package root.screens.manageactivity;


import java.util.List;
import javax.swing.table.DefaultTableModel;
import root.Activity;

/**
 *
 * @author giand
 */
public class ManageActivityController {
    private ManageActivityView view;
    private ManageActivityModel model;

    public ManageActivityController(ManageActivityModel model,
            ManageActivityView view) {
        this.view = view;
        this.model = model;
        
        view.addSelectButtonListener((e) -> {
            javax.swing.JTable tb = view.getActivitiesTable();
            int row = tb.getSelectedRow();
            if (row == -1){
                view.getSelectedIdLabel().setText("No activities selected");
            } else {
                view.getSelectedIdLabel().setText(tb.getValueAt(row, 0).toString());
            }
        });
        
        view.addBackButtonListener((e)-> {view.getNav().pop();});
        
        List<Activity> activities = model.getActivities();
        
        DefaultTableModel activities_table_model = (DefaultTableModel) view.getActivitiesTable().getModel();               
        
        activities.forEach((activity) -> {
            
            activities_table_model.addRow(new Object[] {activity.getId(),
            activity.getBranch_office(), activity.getArea(),
            activity.getTypology(), activity.getEstimated_time(),
            activity.getWeek(), activity.isInterruptible()});

        });      
        
    }
    
    
    
    
}
