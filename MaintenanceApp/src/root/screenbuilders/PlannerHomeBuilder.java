package root.screenbuilders;

import root.Navigator;
import root.screens.plannerhome.PlannerHomeView;

public class PlannerHomeBuilder extends ScreenBuilder {

    @Override
    public void buildView(Navigator nav) {
        view = new PlannerHomeView(nav);
    }
    
}
