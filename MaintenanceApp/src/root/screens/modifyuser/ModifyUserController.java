package root.screens.modifyuser;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class ModifyUserController {
    
    private final ModifyUserView view;
    private final ModifyUserModel model;

    public ModifyUserController(ModifyUserView view, ModifyUserModel model) {
        
        if(model == null){
            view.showErrorMsg("Error", "Error while fetching user data");
            view.getNav().pop();
        }
        
        this.view = view;
        this.model = model;    
        
        view.fillForm();
        
        view.addBackButtonListener((e) -> view.getNav().pop());
        view.addModifyButtonListener((e)->{
            if(checkout()){
                
                model.setCf(view.getCfInput());
                model.setName(view.getNameInput());
                model.setSurname(view.getSurnameInput());
                model.setAddress(view.getAddressInput());
                model.setEmail(view.getEmailInput());
                model.setUsername(view.getUsernameInput());
                model.setPassword(view.getPasswordInput());
                model.setRole(User.UserType.valueOf(view.getRoleInput()));
                
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
        Pattern patternCf = Pattern.compile("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$");
        Pattern patternEmail = Pattern.compile("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$");
        String errStr = "";       
        
        if(name.equals("")){ errStr += "Name cannot be empty\n"; }
        if(surname.equals("")){ errStr += "Surname cannot be empty\n"; }
        if(address.equals("")){ errStr += "Address cannot be empty\n"; }
        if(email.equals("")){ errStr += "Email cannot be empty\n"; }
        if(!patternEmail.matcher(email).matches()){ errStr += "Email format not valid\n";}
        if(cf.equals("")){ errStr += "CF cannot be empty\n"; }
        if(!patternCf.matcher(cf).matches()){ errStr += "CF format not valid\n";}
        if(username.equals("")){ errStr += "Username cannot be empty\n"; }
        if(password.equals("")){ errStr += "Password cannot be empty\n"; }
        if(role.equals("")){ errStr += "Role cannot be empty\n"; }
        
        if(!errStr.equals("")){
            //view.showErrorMsg("Error", errStr);
            return false;
        }
        
        return true;
    }

}
