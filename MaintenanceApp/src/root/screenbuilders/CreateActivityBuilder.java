package root.screenbuilders;

import root.Navigator;
import root.Screen;
import root.screens.createactivity.ActivityController;
import root.screens.createactivity.ActivityModel;
import root.screens.createactivity.ActivityView;

public class CreateActivityBuilder extends ScreenBuilder{
    
    private ActivityView view;
    private ActivityController controller;
    private ActivityModel model;
    

    @Override
    public void buildView(Navigator nav) {
        view = new ActivityView(nav);   
    }
    
    @Override
    public void buildController() {
        controller = new ActivityController(model, view);   
    }
    
    @Override
    public void buildModel() {
        model = new ActivityModel();   
    }

    @Override
    public Screen getScreen() {
        return view;
    }
    
}
