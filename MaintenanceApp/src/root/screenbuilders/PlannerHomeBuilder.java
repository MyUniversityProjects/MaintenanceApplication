package root.screenbuilders;

import root.Navigator;
import root.Screen;
import root.screens.plannerhome.PlannerHomeView;

public class PlannerHomeBuilder extends ScreenBuilder {
    private PlannerHomeView view;

    @Override
    public void buildView(Navigator nav) {
        view = new PlannerHomeView(nav);
    }

    @Override
    public Screen getScreen() {
        return view;
    }
}
