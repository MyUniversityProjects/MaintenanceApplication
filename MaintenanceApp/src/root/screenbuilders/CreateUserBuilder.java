package root.screenbuilders;

import queries.UserQueries;
import root.Navigable;
import root.Screen;
import root.screens.createuser.*;

public class CreateUserBuilder extends ScreenBuilder{
    
    private UserView view;
    private UserController controller;
    private UserModel model;
    

    @Override
    public void buildView(Navigable nav) {
        view = new UserView(nav);   
    }
    
    @Override
    public void buildController() {
        controller = new UserController(model, view);   
    }
    
    @Override
    public void buildModel() {
        model = new UserModel(new UserQueries());   
    }

    @Override
    public Screen getScreen() {
        return view;
    }
    
}
