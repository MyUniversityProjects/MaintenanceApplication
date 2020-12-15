package root.screens.manageactivity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import root.screenbuilders.CreateActivityBuilder;
import root.screenbuilders.ModifySelectedActivityBuilder;
import ui.ButtonColumnActionListener;


public class ManageActivityController {
    private final ManageActivityView view;
    private final ManageActivityModel model;

    public ManageActivityController(ManageActivityModel model,
            ManageActivityView view) {
        this.view = view;
        this.model = model;
             
        // call the function that delete from the database the activiy and
        // delete the row in the table
        view.setDeleteActivityButtonListener(new DeleteBtnListener());
        view.setEditActivityButtonListener((new EditBtnListener()));
        view.addBackButtonListener(new BackBtnListener());
        view.addPlanActivityButtonListener(new PlanBtnListener());
    }
    
      
    private class BackBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getNav().pop();
        }
    }
    
    private class PlanBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getNav().push(new CreateActivityBuilder());
        }
    }
    
    private class DeleteBtnListener implements ButtonColumnActionListener {
        @Override
        public void actionPerformed(int rowIndex) {
            javax.swing.JTable tb = view.getActivitiesTable();
            String id = (String) tb.getValueAt(rowIndex, 0);
            if (model.delete(Integer.parseInt(id))){
                view.showMsg("Deleted", "Deleted selected activity");
                model.getTableModel().removeRow(rowIndex);
            } else {
                view.showErrorMsg("Error", "Error while deleting");
            }
        }
    }
    
    private class EditBtnListener implements ButtonColumnActionListener {
        @Override
        public void actionPerformed(int rowIndex) {
            javax.swing.JTable tb = view.getActivitiesTable();
            String id = (String) tb.getValueAt(rowIndex, 0);
            view.getNav().push(new ModifySelectedActivityBuilder(Integer.parseInt(id)));
        }
    }
    
    
    
}
