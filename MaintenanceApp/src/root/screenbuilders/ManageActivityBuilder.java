
package root.screenbuilders;

import root.Navigator;
import root.Screen;
import root.screens.manageactivity.ManageActivityController;
import root.screens.manageactivity.ManageActivityModel;
import root.screens.manageactivity.ManageActivityView;

public class ManageActivityBuilder extends ScreenBuilder{
    
    private ManageActivityView view;
    private ManageActivityController controller;
    private ManageActivityModel model;

    @Override
    public void buildView(Navigator nav) {
        view = new ManageActivityView(nav);
    }
    
    @Override
    public void buildController() {
        controller = new ManageActivityController(model, view);   
    }
    
    @Override
    public void buildModel() {
        model = new ManageActivityModel();   
    }

    @Override
    public Screen getScreen() {
        return view;
    }
    
}
