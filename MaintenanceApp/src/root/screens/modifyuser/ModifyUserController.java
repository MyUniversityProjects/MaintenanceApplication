package root.screens.modifyuser;

import java.sql.SQLException;

public class ModifyUserController {
    
    private final ModifyUserView view;
    private final ModifyUserModel model;

    public ModifyUserController(ModifyUserView view, ModifyUserModel model) {
        this.view = view;
        this.model = model;    
        
        view.addBackButtonListener((e) -> view.getNav().pop());
        view.addModifyButtonListener((e)->{
            if(checkout()){
                try {
                    if(model.modify()){
                        view.showMsg("Modified", "User changed successfully");
                    } else {
                        view.showErrorMsg("Error", "Error while editing");
                    }
                } catch (SQLException ex) {
                    view.showErrorMsg("Error", "Error while editing");
                }
            }
        });
    }
    
    /**
     *Check if the id is integer and the other fields are not empty
     * 
     * @return if the inputs are correct
     */
    public boolean checkout(){
        
        String name = view.getNameInput();
        String surname = view.getSurnameInput();
        String address = view.getAddressInput();
        String email = view.getEmailInput();
        String cf = view.getCfInput();
        String username = view.getUsernameInput();
        String password = view.getPasswordInput();
        String role = view.getRoleInput();
        String errStr = "";       
        
        if(name.equals("")){ errStr += "Name cannot be empty\n"; }
        if(surname.equals("")){ errStr += "Surname cannot be empty\n"; }
        if(address.equals("")){ errStr += "Address cannot be empty\n"; }
        if(email.equals("")){ errStr += "Email cannot be empty\n"; }
        if(cf.equals("")){ errStr += "CF cannot be empty\n"; }
        if(username.equals("")){ errStr += "Username cannot be empty\n"; }
        if(password.equals("")){ errStr += "Password cannot be empty\n"; }
        if(role.equals("")){ errStr += "Role cannot be empty\n"; }
        
        if(!errStr.equals("")){
            view.showErrorMsg("Error", errStr);
            return false;
        }
        
        return true;
    }

}
