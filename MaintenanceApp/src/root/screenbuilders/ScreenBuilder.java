package root.screenbuilders;

import root.Navigator;
import root.Screen;

abstract public class ScreenBuilder {
    protected Screen view;
    
    public void buildModel() {}
    public abstract void buildView(Navigator nav);
    public void buildController() {}
    
    public Screen getScreen() {
        return view;
    }
    
}
