package root.screens.verifyactivity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerifyActivityController {
    private VerifyActivityModel model;
    private VerifyActivityView view;

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
        public void actionPerformed(ActionEvent event) {}
    }
    
    private class SmpBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {}
    }
    
    private class BackBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {}
    }
    
    private class HomeBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {}
    }
}
