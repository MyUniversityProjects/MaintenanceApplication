package root.screenbuilders;

import root.Navigable;
import root.Screen;

abstract public class ScreenBuilder {
    public void buildModel() {}
    public abstract void buildView(Navigable nav);
    public void buildController() {}
    
    public abstract Screen getScreen();
}
