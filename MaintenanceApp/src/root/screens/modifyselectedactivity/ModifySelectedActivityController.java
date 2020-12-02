package root.screens.modifyselectedactivity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModifySelectedActivityController {
    private final ModifySelectedActivityModel model;
    private final ModifySelectedActivityView view;
    private String checkoutError;

    /**
     * Create the controller and register buttons listeners of the view
     * @param model the model of the view
     * @param view the view to control
     */
    public ModifySelectedActivityController(ModifySelectedActivityModel model, ModifySelectedActivityView view) {
        this.model = model;
        this.view = view;
        
        view.addBackButtonListener(new BackBtnListener());
        view.addHomeButtonListener(new HomeBtnListener());
        view.addModifyButtonListener(new ModifyBtnListener());
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
    
    private class ModifyBtnListener implements ActionListener {
        /**
         * Modify the activity with the inputs of the user.
         * if the inputs don't respect the checkout conditions,
         * an error message will be given
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            Map<String, String> inputMap = getInputs();
            if (modifyCheckout(inputMap)) {
                model.modify(inputMap);
                view.showMsg("Success", "Activity modified successfully");
                view.getNav().goHome();
                
            } else {
                view.showErrorMsg("Input error", checkoutError);
            }
        }
    }
    
    /**
     * Do the check below:
     *  1 - check that all fields are present
     *  2 - check that integer fields have an integer value
     *  3 - check that the required fields are not empty
     * 
     * @param inputMap
     * @return if the checks are passed
     */
    public boolean modifyCheckout(Map<String, String> inputMap) {
        
        List<String> keyList = Arrays.asList("branch_office", "area",
            "estimated_time", "interruptible", "typology", 
            "description");       
        
        if ( !inputMap.keySet().containsAll(keyList)) {
            checkoutError = "Error: The required fields have not been entered";
            return false;
        }
        
        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            if ( entry.getKey().equals("estimated_time") ) {
                if (!isInteger(entry.getValue())) {
                    checkoutError = "Error: The fields  estimated_time  must be an integer";
                    return false;
                }
            }
            if (!entry.getKey().equals("notes")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError = "Error: The required fields can not be empty";
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * check if a String has an integer value
     * 
     * @param str
     * @return  true if it is a Integer, false otherwise
     */
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Take the input field from the view and
     * added them in a map, and return the map.
     * @return  map having the inputs from the user
     */
    private Map<String, String> getInputs() {
        Map<String, String> inputMap = new HashMap<>();
        inputMap.put("branch_office", view.getBranchOffice());
        inputMap.put("area", view.getArea());
        inputMap.put("estimated_time", view.getEstimatedTime());
        inputMap.put("interruptible", view.getInterruptible());
        inputMap.put("typology", view.getTypology());
        inputMap.put("notes", view.getNotes());
        inputMap.put("description", view.getDescription());

        return inputMap;
    }
}
