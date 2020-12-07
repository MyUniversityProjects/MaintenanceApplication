
package root.screenbuilders;

import java.sql.SQLException;
import root.Navigable;
import root.Screen;
import root.exceptions.NotFoundException;
import root.screens.modifyuser.*;

public class ModifyUserBuilder extends ScreenBuilder{
    private ModifyUserView view;
    private ModifyUserController controller;
    private ModifyUserModel model;
    private final String cf;
    
    public ModifyUserBuilder(String cf){
        this.cf = cf;
    }
    
    @Override
    public void buildView(Navigable nav){
        view = new ModifyUserView(nav, model);
    }
    
    @Override
    public void buildModel(){
        try{
            model = ModifyUserModel.fromDatabase(cf);
        } catch (SQLException | NotFoundException ex){
            model = null;
        }
    }
    
    @Override
    public void buildController(){
        controller = new ModifyUserController(view, model);
    }
    
    @Override
    public Screen getScreen(){
        return view;
    }
    
}
