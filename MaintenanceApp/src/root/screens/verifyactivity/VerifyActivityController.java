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
        view.addSkillAddBtnListener(new AddSkillBtnListener());
        view.addMaterialAddBtnListener(new AddMaterialBtnListener());
        view.addMaterialRemoveBtnListener(new RemoveMaterialBtnListener());
        view.addBackBtnListener(new BackBtnListener());
        view.addHomeBtnListener(new HomeBtnListener());
    }
    
    public boolean isTimeInputValid() {
        try {
            return Integer.parseInt(view.getTimeValue()) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private class ForwardBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (!isTimeInputValid()) {
                view.showErrorMsg("Input error", "Estimated time must be a positive integer");
                return;
            }
            
            model.setTime(Integer.parseInt(view.getTimeValue()));
            model.setNotes(view.getTextAreaNotes());
            model.setDescription(view.getTextAreaDescription());
            try {
                model.forward();
            } catch (SQLException | NotFoundException ex) {
                view.showErrorMsg("Unable to forward", ex.getMessage());
                EventQueue.invokeLater(() -> {
                    view.getNav().goHome();
                });
            }
        }
    }
    
    private class SmpBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {}
    }
    
    private class AddSkillBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String name = view.getSelectedSkill();
            if (name != null)
                view.addSkill(name);            
        }
    }
    
    private class AddMaterialBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String name = view.popMaterialInputValue();
            if (name.length() == 0) {
                view.showErrorMsg("Input error", "Material name can't be empty");
            } else {
                view.addMaterial(name);
            }
        }
    }
    
    private class RemoveMaterialBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String name = view.popMaterialInputValue();
            if (name.length() == 0) {
                view.showErrorMsg("Input error", "Material name can't be empty");
            } else {
                view.removeMaterial(name);
            }
        }
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
