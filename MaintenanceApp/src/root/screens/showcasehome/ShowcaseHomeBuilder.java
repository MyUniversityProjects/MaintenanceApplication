package root.screens.showcasehome;

import root.Navigable;
import root.Screen;
import root.screenbuilders.ScreenBuilder;

public class ShowcaseHomeBuilder extends ScreenBuilder {
    private Screen screen;

    @Override
    public void buildView(Navigable nav) {
        screen = new ShowcaseHomeView(nav);
    }

    @Override
    public Screen getScreen() {
        return screen;
    }
}
