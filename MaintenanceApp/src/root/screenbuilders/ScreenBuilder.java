package root.screenbuilders;

import root.Navigator;
import root.Screen;

abstract public class ScreenBuilder {
    public void buildModel() {}
    public abstract void buildView(Navigator nav);
    public void buildController() {}
    
    public abstract Screen getScreen();
}
