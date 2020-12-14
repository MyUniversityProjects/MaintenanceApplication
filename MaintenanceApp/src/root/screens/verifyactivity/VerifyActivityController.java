package root.screens.verifyactivity;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import root.exceptions.NotFoundException;
import root.exceptions.QueryFailedException;
import root.screenbuilders.AssignActivityBuilder;

public class VerifyActivityController {
    private final VerifyActivityModel model;
    private final VerifyActivityView view;
    
    /**
     * Create the controller and register buttons listeners of the view
     * @param model the model of the view
     * @param view the view to control
     */
    public VerifyActivityController(VerifyActivityModel model, VerifyActivityView view) {
        this.model = model;
        this.view = view;
        
        view.addForwardBtnListener(new ForwardBtnListener());
        view.addSmpBtnListener(new SmpBtnListener());
        view.addSkillAddBtnListener(new AddSkillBtnListener());
        view.addSkillRemoveBtnListener(new RemoveSkillBtnListener());
        view.addMaterialAddBtnListener(new AddMaterialBtnListener());
        view.addMaterialRemoveBtnListener(new RemoveMaterialBtnListener());
        view.addBackBtnListener(new BackBtnListener());
        view.addHomeBtnListener(new HomeBtnListener());
    }
    
    /**
     * Used to check the raw time input value
     * @return true if the raw time string is valid; otherwise false
     */
    public boolean isTimeInputValid() {
        try {
            return Integer.parseInt(view.getTimeValue()) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private class ForwardBtnListener implements ActionListener {
        /**
         * Validate input, update the model with the user input, than it 
         * calls the method forward of the model
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            if (!isTimeInputValid()) {
                view.showErrorMsg("Input error", "Estimated time must be a positive integer");
            } else {
                model.setTime(Integer.parseInt(view.getTimeValue()));
                model.setNotes(view.getTextAreaNotes());
                model.setDescription(view.getTextAreaDescription());
                
                try {
                    model.forward();
                    view.getNav().push(new AssignActivityBuilder(model.getId()));
                } catch (QueryFailedException | NotFoundException ex) {
                    view.showErrorMsg("Unable to forward", ex.getMessage());
                    EventQueue.invokeLater(() -> {
                        view.getNav().goHome();
                    });
                }
            }
        }
    }
    
    private class SmpBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {}  // TODO
    }
    
    private class AddSkillBtnListener implements ActionListener {
        /**
         * Add the selected skill to the skill UI list
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            model.addSelectedSkill();            
        }
    }
    
    private class RemoveSkillBtnListener implements ActionListener {
        /**
         * Remove the selected skill from the skill UI list
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            model.removeSelectedSkill();            
        }
    }
    
    private class AddMaterialBtnListener implements ActionListener {
        /**
         * Add the selected material to the material UI list
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            model.addSelectedMaterial();
        }
    }
    
    private class RemoveMaterialBtnListener implements ActionListener {
        /**
         * Remove the selected material from the material UI list
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            model.removeSelectedMaterial();
        }
    }
    
    private class BackBtnListener implements ActionListener {
        /**
         * Go back to the previous screen
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            view.getNav().pop();
        }
    }
    
    private class HomeBtnListener implements ActionListener {
        /**
         * Go back to the home screen
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            view.getNav().goHome();
        }
    }
}
