package root.screenbuilders;

import root.Navigator;
import root.Screen;

public class ScreenDirector {
    public static Screen build(ScreenBuilder b, Navigator nav) {
        b.buildModel();
        b.buildView(nav);
        b.buildController();
        return b.getScreen();
    }
}

