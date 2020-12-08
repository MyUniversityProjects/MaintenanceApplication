package root.screens.manageusers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUsersController {
    private final ManageUsersModel model;
    private final ManageUsersView view;

    public ManageUsersController(ManageUsersModel model, ManageUsersView view) {
        this.model = model;
        this.view = view;
    }
    
    private class BackBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {}
    }
    
    private class CreateBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {}
    }
    
    private class DeleteBtnListener implements ButtonColumnActionListener {
        @Override
        public void actionPerformed(int rowIndex) {}
    }
    
    private class EditBtnListener implements ButtonColumnActionListener {
        @Override
        public void actionPerformed(int rowIndex) {}
    }
}
