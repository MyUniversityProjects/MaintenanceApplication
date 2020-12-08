/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.createuser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        return null;
    }

    public boolean createCheckout(Map<String, String> inputMap) {
        return false;
    }
    public User createUser(Map<String, String> inputMap){
        return null;
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
         * Go back to the previous screen
         */
        @Override
        public void actionPerformed(ActionEvent event) {
              //TODO
        }
    }
}
