package root.screenbuilders;

import root.Navigator;
import root.screens.verifyactivity.VerifyActivityView;

public class VerifyActivityBuilder extends ScreenBuilder {

    @Override
    public void buildView(Navigator nav) {
        view = new VerifyActivityView(nav);
    }
    
}
