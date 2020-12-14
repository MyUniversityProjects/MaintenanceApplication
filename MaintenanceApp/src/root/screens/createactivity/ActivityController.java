package root.screens.createactivity;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import root.entities.Activity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import root.screenbuilders.VerifyActivityBuilder;

public class ActivityController {

    private final ActivityModel model;
    private final ActivityView view;
    private String checkoutError;

    public ActivityController(ActivityModel model, ActivityView view) {
        this.model = model;
        this.view = view;
        view.addMaterialAddBtnListener(new AddMaterialBtnListener());
        view.addMaterialRemoveBtnListener(new RemoveMaterialBtnListener());
        view.addCreateButtonListener((e) -> {
            Map<String, String> inputMap = getInputs();
            if (createCheckout(inputMap)) {
                fillModel();
                if (!model.create()){ 
                    view.showErrorMsg("Id error", "The id is already present");
                } else {
                    if(!model.assignMaterialsToActivity(model.getId())){
                        view.showErrorMsg("Materials error", "The materials cannot be assigned to the activity");
                    }
                    view.showMsg("Success", "Activity entered successfully");
                    if(model.getType().equals(ActivityModel.ActivityType.UNPLANNED)
                        || model.getType().equals(ActivityModel.ActivityType.EXTRA)){
                        view.getNav().replace(
                            new VerifyActivityBuilder(model.getId()));
                    }   
                }
            } else {
                view.showErrorMsg("Input error", checkoutError);
            }
        });
        
        view.addBackButtonListener((e)-> {view.getNav().pop();});
        
        view.addTypeButtonListener((e)->{
            String type = view.getType();
            boolean enabled = type.equals("UNPLANNED") || type.equals("EXTRA");
            view.setEnableWeek(!enabled);
        });
        
        
    }
    
    public void fillModel(){
        model.setId(Integer.parseInt(view.getId()));
        model.setArea(view.getArea());
        model.setBranchOffice(view.getBranchOffice());
        model.setDescription(view.getDescription());
        model.setInterruptible(Boolean.parseBoolean(view.getInterruptible()));
        model.setNotes(view.getNotes());
        model.setType(Activity.ActivityType.valueOf(view.getType()));
        model.setTypology(view.getTypology());
        model.setWeek(Integer.parseInt(view.getWeek()));
        model.setTime(Integer.parseInt(view.getEstimatedTime()));
    }

    /**
     * Take the input field from the view and
     * added them in a map, and return the map.
    */
    
    private Map<String, String> getInputs() {
        Map<String, String> inputMap = new HashMap<>();

        inputMap.put("id", view.getId());
        inputMap.put("branch_office", view.getBranchOffice());
        inputMap.put("area", view.getArea());
        inputMap.put("estimated_time", view.getEstimatedTime());
        inputMap.put("interruptible", view.getInterruptible());
        inputMap.put("typology", view.getTypology());
        inputMap.put("week", view.getWeek());
        inputMap.put("notes", view.getNotes());
        inputMap.put("description", view.getDescription());
        inputMap.put("type", view.getType());

        return inputMap;
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
    public boolean createCheckout(Map<String, String> inputMap) {
        
        checkoutError = "";
        List<String> keyList = Arrays.asList("id", "branch_office", "area",
            "estimated_time", "interruptible", "typology", "week",
            "description", "type");       
        Integer week, time;
        boolean flag = true;
        
        if ( !inputMap.keySet().containsAll(keyList)) {
            checkoutError += "The required fields have not been entered\n";
            flag = false;
        }
        
        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            if(entry.getKey().equals("id") && !validateId(entry.getValue())){
                checkoutError += "The id field must be a positive integer\n";
                flag = false;
            }
             
            if(entry.getKey().equals("estimated_time") && !validateTime(entry.getValue())){
                checkoutError += "The estimated time field must be a positive integer\n";
                flag = false;
            }
             
            if(entry.getKey().equals("week") && !validateId(entry.getValue())){
                checkoutError += "the week fiels must have a positive value between 1 and 52\n";
                flag = false;
            }
             
            
            
            if (!entry.getKey().equals("notes")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError = "The required fields can not be empty\n";
                    flag = false;
                }
            }
        }
        return flag;
    }

    /**
     *
     * @param str
     * @return if str is a correct string to rappresent an id
     */
    public boolean validateId(String str){
        try {
            return Integer.parseInt(str) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     *
     * @param str
     * @return if str is a correct string to rappresent a week
     */
    public boolean validateWeek(String str){
        try {
            Integer value = Integer.parseInt(str);
            return !(value <= 0 || value >= 53);
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
     /**
     *
     * @param str
     * @return if str is a correct string to rappresent an estimated time
     */
    public boolean validateTime(String str){
        try {
            return Integer.parseInt(str) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private class RemoveMaterialBtnListener implements ActionListener {
        /**
         * Remove the selected skill from the skill UI list
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            model.removeSelectedMaterial();            
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

}
