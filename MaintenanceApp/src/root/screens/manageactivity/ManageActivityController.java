package root.screens.manageactivity;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import root.entities.Activity;
import root.screenbuilders.ModifySelectedActivityBuilder;


public class ManageActivityController {
    private ManageActivityView view;
    private ManageActivityModel model;
    private DefaultTableModel activitiesTableModel;

    public ManageActivityController(ManageActivityModel model,
            ManageActivityView view) {
        this.view = view;
        this.model = model;
        activitiesTableModel = (DefaultTableModel) view.getActivitiesTable().getModel();

             
        view.addBackButtonListener((e)-> view.getNav().pop());
        
        // call the function that delete from the database the activiy and
        // delete the row in the table
        view.addDeleteSelectedButtonListener((e) ->{
            javax.swing.JTable tb = view.getActivitiesTable();
            int row = tb.getSelectedRow();
            if (row == -1){
                view.showErrorMsg("Error", "No activities selected");
            } else {                
                if (model.delete((int) tb.getValueAt(row, 0))){
                    view.showMsg("Deleted", "Deleted selected activity");
                    activitiesTableModel.removeRow(row);                    
                } else {
                    view.showErrorMsg("Error", "Error while deleting");
                }
            }
        });
        
        view.addModifySelectedButtonListener((e) ->{
            javax.swing.JTable tb = view.getActivitiesTable();
            int row = tb.getSelectedRow();
            if (row == -1){
                view.showErrorMsg("Error", "No activities selected");
            } else {                           
                view.getNav().push(new ModifySelectedActivityBuilder((int) tb.getValueAt(row, 0)));
            }
        });
        
        List<Activity> activities = model.getActivities();       
        
        // add the activities in the table
        activities.forEach((activity) -> {
            activitiesTableModel.addRow(new Object[] {activity.getId(),
            activity.getBranchOffice(), activity.getArea(),
            activity.getTypology(), activity.getTime(),
            activity.getWeek(), activity.isInterruptible()});

        });              
    }
    
    
    
}
