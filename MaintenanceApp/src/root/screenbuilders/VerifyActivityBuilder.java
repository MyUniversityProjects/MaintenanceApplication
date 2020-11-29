package root.screenbuilders;

import java.sql.SQLException;
import root.Navigable;
import root.Screen;
import root.exceptions.NotFoundException;
import root.screens.verifyactivity.VerifyActivityController;
import root.screens.verifyactivity.VerifyActivityModel;
import root.screens.verifyactivity.VerifyActivityView;

public class VerifyActivityBuilder extends ScreenBuilder {
    private final int id;
    private VerifyActivityView view;
    private VerifyActivityModel model;
    private VerifyActivityController controller;

    public VerifyActivityBuilder(int id) {
        this.id = id;
    }

    @Override
    public void buildController() {
        controller = new VerifyActivityController(model, view);
    }

    @Override
    public void buildModel() {
        try {
            model = VerifyActivityModel.fromDatabase(id);
        } catch (SQLException | NotFoundException ex) {
            model = null;
        }
    }
    
    @Override
    public void buildView(Navigable nav) {
        view = new VerifyActivityView(nav, model);
    }

    @Override
    public Screen getScreen() {
        return view;
    }
}
