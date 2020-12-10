/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.createuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ficca
 */
public class UserController {
    private final UserModel model;
    private final UserView view;
    private String checkoutError;
    

    public UserController(UserModel model, UserView view) {
        this.model = model;
        this.view = view;
        view.addBackButtonListener(new BackBtnListener());
        view.addCreateButtonListener(new CreateBtnListener());
    }
    
    private Map<String, String> getInputs(){
        Map<String, String> inputMap = new HashMap<>();

        inputMap.put("cf", view.getCf());
        inputMap.put("username", view.getUsername());
        inputMap.put("pass", view.getPassword());
        inputMap.put("user_role", view.getRole());
        inputMap.put("name", view.getName());
        inputMap.put("surname", view.getSurname());
        inputMap.put("email", view.getEmail());
        inputMap.put("address", view.getAddress());
        
        return inputMap;
    }

    public boolean createCheckout(Map<String, String> inputMap) {
        checkoutError = "";     
        boolean flag = true;
        for(Map.Entry<String, String> entry : inputMap.entrySet()){
            if (entry.getKey().equals("cf")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError += " CF cannot be void\n";
                    flag = false;
                }
            }
            if (entry.getKey().equals("username")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError += " Username cannot be void\n";
                    flag = false;
                }
            }
            if (entry.getKey().equals("pass")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError += " Password cannot be void\n";
                    flag = false;
                }
            }
            if (entry.getKey().equals("user_role")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError += " Role need to be selected\n";
                    flag = false;
                }
            }
            if (entry.getKey().equals("name")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError += " Name cannot be void\n";
                    flag = false;
                }
            }
            if (entry.getKey().equals("surname")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError += " Surname cannot be void\n";
                    flag = false;
                }
            }
            if (entry.getKey().equals("email")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError += " Email cannot be void\n";
                    flag = false;
                }
            }
            if (entry.getKey().equals("address")) {
                if (entry.getValue().length() <= 0) {
                    checkoutError += " Address cannot be void\n";
                    flag = false;
                }
            }
        }
        return flag;
    }
    public User createUser(Map<String, String> inputMap){
        return new User(inputMap.get("cf"),inputMap.get("username"),inputMap.get("pass"),
            inputMap.get("name"),inputMap.get("surname"),inputMap.get("email"),
            inputMap.get("address"),User.RoleType.valueOf(inputMap.get("user_role")));
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
    
    private class CreateBtnListener implements ActionListener {
        /**
         * Create a new user
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            Map<String, String> inputMap = getInputs();
            if (createCheckout(inputMap)) {
                User user = createUser(inputMap);
                boolean flag =  model.create(user);
                if(flag){
                    view.showMsg("Success", "User registred successfully");
                }
                else{
                    view.showErrorMsg("DataBase error", model.getDatabaseError());
                }               
            } else {
                view.showErrorMsg("Input error", checkoutError);
            }
        }
    }
}
