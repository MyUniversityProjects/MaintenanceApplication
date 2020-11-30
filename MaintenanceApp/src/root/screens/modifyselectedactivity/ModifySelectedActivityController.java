package root.screens.modifyselectedactivity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifySelectedActivityController {
    private final ModifySelectedActivityModel model;
    private final ModifySelectedActivityView view;

    public ModifySelectedActivityController(ModifySelectedActivityModel model, ModifySelectedActivityView view) {
        this.model = model;
        this.view = view;
        
        view.addBackButtonListener(new BackBtnListener());
        view.addHomeButtonListener(new HomeBtnListener());
    }

    private class BackBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            view.getNav().pop();
        }
    }
    
    private class HomeBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            view.getNav().goHome();
        }
    }
}
