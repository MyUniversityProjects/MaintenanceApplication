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
    private DefaultTableModel activitiesTableModel;

    public ManageActivityController(ManageActivityModel model,
            ManageActivityView view) {
        this.view = view;
        this.model = model;
        activitiesTableModel = (DefaultTableModel) view.getActivitiesTable().getModel();
        
        view.addSelectButtonListener((e) -> {
            javax.swing.JTable tb = view.getActivitiesTable();
            int row = tb.getSelectedRow();
            if (row == -1){
                view.getSelectedIdLabel().setText("No activities selected");
            } else {
                view.getSelectedIdLabel().setText(tb.getValueAt(row, 0).toString());
            }
        });
        
        view.addBackButtonListener((e)-> view.getNav().pop());
        
        view.addDeleteSelectedButtonListener((e) ->{
            javax.swing.JTable tb = view.getActivitiesTable();
            int row = tb.getSelectedRow();
            if (row == -1){
                view.getSelectedIdLabel().setText("No activities selected");
            } else {                
                if (model.delete((int) tb.getValueAt(row, 0))){
                    view.getSelectedIdLabel().setText("Deleted selected activity");
                    activitiesTableModel.removeRow(row);                    
                } else {
                    view.getSelectedIdLabel().setText("Error while deleting");
                }
            }
        });
        
        view.addModifySelectedButtonListener((e) ->{
            javax.swing.JTable tb = view.getActivitiesTable();
            int row = tb.getSelectedRow();
            if (row == -1){
                view.getSelectedIdLabel().setText("No activities selected");
            } else {                
                if (model.delete((int) tb.getValueAt(row, 0))){
                    view.getSelectedIdLabel().setText("Deleted selected activity");
                    activitiesTableModel.removeRow(row);                    
                } else {
                    view.getSelectedIdLabel().setText("Error while deleting");
                }
            }
        });
        
        List<Activity> activities = model.getActivities();       
        
        activities.forEach((activity) -> {
            activitiesTableModel.addRow(new Object[] {activity.getId(),
            activity.getBranchOffice(), activity.getArea(),
            activity.getTypology(), activity.getEstimatedTime(),
            activity.getWeek(), activity.isInterruptible()});

        });              
    }
    
    
    
}
