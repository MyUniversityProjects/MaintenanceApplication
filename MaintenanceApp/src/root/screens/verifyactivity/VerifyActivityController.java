package root.screens.verifyactivity;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import root.exceptions.NotFoundException;

public class VerifyActivityController {
    private final VerifyActivityModel model;
    private final VerifyActivityView view;

    public VerifyActivityController(VerifyActivityModel model, VerifyActivityView view) {
        this.model = model;
        this.view = view;
        
        view.addForwardBtnListener(new ForwardBtnListener());
        view.addSmpBtnListener(new SmpBtnListener());
        view.addBackBtnListener(new BackBtnListener());
        view.addHomeBtnListener(new HomeBtnListener());
    }
    
    private class ForwardBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            model.setNotes(view.getTextAreaNotes());
            try {
                model.forward();
            } catch (SQLException | NotFoundException ex) {
                EventQueue.invokeLater(() -> {
                    view.showErrorMsg("Unable to forward", ex.getMessage());
                    view.getNav().goHome();
                });
            }
        }
    }
    
    private class SmpBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {}
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
