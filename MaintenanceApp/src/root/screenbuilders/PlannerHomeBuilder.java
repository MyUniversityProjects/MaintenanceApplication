package root.screenbuilders;

import root.Navigable;
import root.Screen;
import root.screens.plannerhome.PlannerHomeView;

public class PlannerHomeBuilder extends ScreenBuilder {
    private Screen screen;

    @Override
    public void buildView(Navigable nav) {
        screen = new PlannerHomeView(nav);
    }

    @Override
    public Screen getScreen() {
        return screen;
    }
}
