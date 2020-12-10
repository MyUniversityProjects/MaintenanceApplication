package root.screens.manageusers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import root.entities.User;
import root.exceptions.QueryFailedException;

/**
 * Handle User interaction of the view ManageUsersView
 */
public class ManageUsersController {
    private final ManageUsersModel model;
    private final ManageUsersView view;
    
    /**
     * Create an istance of ManageUsersController and register the listeners
     * to the ManageUsersView
     * @param model the model of the view
     * @param view the view to control
     */
    public ManageUsersController(ManageUsersModel model, ManageUsersView view) {
        this.model = model;
        this.view = view;
        
        view.addBackActionListener(new BackBtnListener());
        view.addCreateActionListener(new CreateBtnListener());
        view.setDeleteUserActionListener(new DeleteBtnListener());
        view.setEditUserActionListener(new EditBtnListener());
    }
    
    private class BackBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getNav().pop();
        }
    }
    
    private class CreateBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: push create user screen
        }
    }
    
    private class DeleteBtnListener implements ButtonColumnActionListener {
        @Override
        public void actionPerformed(int rowIndex) {
            User user = model.getUsers()[rowIndex];
            String msg = "Sei sicuro di voler cancellare " + user.getUsername();
            if (view.confirmDialog("Conferma Operazione", msg)) {
                try {
                    model.delete(rowIndex);
                } catch (QueryFailedException ex) {
                    view.showErrorMsg("Unable to delete", ex.getMessage());
                }
            }
        }
    }
    
    private class EditBtnListener implements ButtonColumnActionListener {
        @Override
        public void actionPerformed(int rowIndex) {
            // TODO: push edit user screen
        }
    }
}
