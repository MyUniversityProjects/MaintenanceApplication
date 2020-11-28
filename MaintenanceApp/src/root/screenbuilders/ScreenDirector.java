package root.screenbuilders;

import root.Navigable;
import root.Screen;

public class ScreenDirector {
    public static Screen build(ScreenBuilder b, Navigable nav) {
        b.buildModel();
        b.buildView(nav);
        b.buildController();
        return b.getScreen();
    }
}

