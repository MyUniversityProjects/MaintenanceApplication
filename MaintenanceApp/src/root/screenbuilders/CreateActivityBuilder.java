package root.screenbuilders;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import queries.ActivityQueries;
import root.Navigable;
import root.Screen;
import root.screens.createactivity.ActivityController;
import root.screens.createactivity.ActivityModel;
import root.screens.createactivity.ActivityView;

public class CreateActivityBuilder extends ScreenBuilder{
    
    private ActivityView view;
    private ActivityController controller;
    private ActivityModel model;
    

    @Override
    public void buildView(Navigable nav) {
        view = new ActivityView(nav,model);   
    }
    
    @Override
    public void buildController() {
        controller = new ActivityController(model, view);   
    }
    
    @Override
    public void buildModel() {
        try {   
            model = new ActivityModel(new ActivityQueries());
        } catch (SQLException ex) {
            Logger.getLogger(CreateActivityBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Screen getScreen() {
        return view;
    }
    
}
