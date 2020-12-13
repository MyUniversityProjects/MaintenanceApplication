
package root.screenbuilders;

import root.Navigable;
import root.Screen;
import root.screens.modifyuser.*;
import queries.UserQueries;

public class ModifyUserBuilder extends ScreenBuilder{
    private ModifyUserView view;
    private ModifyUserController controller;
    private ModifyUserModel model;
    private final String cf;
    private final UserQueries query;
    
    public ModifyUserBuilder(String cf){
        this.cf = cf;
        this.query = new UserQueries();
    }
    
    @Override
    public void buildView(Navigable nav){
        view = new ModifyUserView(nav, model);
    }
    
    @Override
    public void buildModel(){
        model = ModifyUserModel.fromDatabase(cf, query);
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
