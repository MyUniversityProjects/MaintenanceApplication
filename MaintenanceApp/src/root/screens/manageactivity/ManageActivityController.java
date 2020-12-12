package root.screens.manageactivity;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import root.entities.Activity;
import root.screenbuilders.CreateActivityBuilder;
import root.screenbuilders.ModifySelectedActivityBuilder;


public class ManageActivityController {
    private final ManageActivityView view;
    private final ManageActivityModel model;

    public ManageActivityController(ManageActivityModel model,
            ManageActivityView view) {
        this.view = view;
        this.model = model;
             
        view.addBackButtonListener((e)-> view.getNav().pop());
        
        // call the function that delete from the database the activiy and
        // delete the row in the table
        view.setDeleteActivityButtonListener((rowIndex) -> {
            javax.swing.JTable tb = view.getActivitiesTable();
            String id = (String) tb.getValueAt(rowIndex, 0);
            if (model.delete(Integer.parseInt(id))){
                view.showMsg("Deleted", "Deleted selected activity");
                model.getTableModel().removeRow(rowIndex);
            } else {
                view.showErrorMsg("Error", "Error while deleting");
            }
        });
        
        view.setEditActivityButtonListener((int rowIndex) -> {
            javax.swing.JTable tb = view.getActivitiesTable();
            String id = (String) tb.getValueAt(rowIndex, 0);
            view.getNav().push(new ModifySelectedActivityBuilder(Integer.parseInt(id)));
        });
        
        view.addPlanActivityButtonListener((e) -> {
            view.getNav().push(new CreateActivityBuilder());
        });
    }
    
    
    
}
