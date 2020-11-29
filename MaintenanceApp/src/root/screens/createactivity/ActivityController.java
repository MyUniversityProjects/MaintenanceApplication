package root.screens.createactivity;


import root.entities.Activity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityController {

    private final ActivityModel model;
    private final ActivityView view;
    private String checkoutError;

    public ActivityController(ActivityModel model, ActivityView view) {
        this.model = model;
        this.view = view;

        view.addCreateButtonListener((e) -> {
            Map<String, String> inputMap = getInputs();
            if (createCheckout(inputMap)) {
                Activity act = createActivity(inputMap);
                if (!model.create(act) && model.getErrorCode() == 0){                    
                    view.getMsgLabel().setForeground(java.awt.Color.red);
                    view.getMsgLabel().setText("Id già presente");
                } else {
                    view.getMsgLabel().setForeground(java.awt.Color.green);
                    view.getMsgLabel().setText("Activity entered successfully");
                }
            } else {
                view.getMsgLabel().setForeground(java.awt.Color.red);
                view.getMsgLabel().setText(checkoutError);
            }
        });
        
        view.addBackButtonListener((e)-> {view.getNav().pop();});
    }

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

    public boolean createCheckout(Map<String, String> inputMap) {
        
        List<String> keyList = Arrays.asList("id", "branch_office", "area",
            "estimated_time", "interruptible", "typology", "week",
            "description", "type");       
        
        if ( !inputMap.keySet().containsAll(keyList)) {
            checkoutError = "Error: The required fields have not been entered";
            return false;
        }
        
        for (Map.Entry<String, String> entry : inputMap.entrySet()) {
            if (entry.getKey().equals("id") || entry.getKey().equals("estimated_time") || entry.getKey().equals("week")) {
                if (!isInteger(entry.getValue())) {
                    checkoutError = "Error: The fields id, estimated_time and week must be an integer";
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
    
    public Activity createActivity(Map<String, String> inputMap){       
        
        boolean interruptible = Boolean.parseBoolean(inputMap.get("interruptible"));
        int id = Integer.parseInt(inputMap.get("id"));
        int estimated_time = Integer.parseInt(inputMap.get("estimated_time"));
        int week = Integer.parseInt(inputMap.get("week"));
        return new Activity(id,inputMap.get("area"),
            inputMap.get("branch_office"), inputMap.get("typology"),
            inputMap.get("description"), estimated_time, interruptible,
            week, inputMap.get("workspace_notes"),
            Activity.ActivityType.valueOf(inputMap.get("type")));
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
