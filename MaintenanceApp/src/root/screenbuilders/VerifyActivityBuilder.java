package root.screenbuilders;

import root.Navigator;
import root.screens.verifyactivity.VerifyActivityController;
import root.screens.verifyactivity.VerifyActivityModel;
import root.screens.verifyactivity.VerifyActivityView;

public class VerifyActivityBuilder extends ScreenBuilder {
    private final int id;
    private VerifyActivityModel model;
    private VerifyActivityController controller;

    public VerifyActivityBuilder(int id) {
        this.id = id;
    }

    @Override
    public void buildController() {
        controller = new VerifyActivityController(model, (VerifyActivityView)view);
    }

    @Override
    public void buildModel() {
        model = new VerifyActivityModel(id);
    }
    
    @Override
    public void buildView(Navigator nav) {
        view = new VerifyActivityView(nav, model);
    }
}
