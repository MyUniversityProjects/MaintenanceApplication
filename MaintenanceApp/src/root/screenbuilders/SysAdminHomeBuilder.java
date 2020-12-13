
package root.screenbuilders;

import root.Navigable;
import root.Screen;
import root.screens.sysadminhome.SysAdminHomeView;

public class SysAdminHomeBuilder extends ScreenBuilder{
    
    private Screen screen;
    
    @Override
    public void buildView(Navigable nav){
        screen = new SysAdminHomeView(nav);
    }
    
    @Override
    public Screen getScreen(){
        return screen;
    }
    
}
