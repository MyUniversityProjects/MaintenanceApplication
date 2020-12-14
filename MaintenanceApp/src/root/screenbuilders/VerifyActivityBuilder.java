package root.screenbuilders;

import queries.ActivityQueries;
import queries.CompetenceQueries;
import queries.MaterialQueries;
import root.Navigable;
import root.Screen;
import root.exceptions.NotFoundException;
import root.exceptions.QueryFailedException;
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
        ActivityQueries queryTool = new ActivityQueries();
        MaterialQueries matQueryTool = new MaterialQueries();
        CompetenceQueries compQueryTool = new CompetenceQueries();
        try {
            model = VerifyActivityModel.fromDatabase(id, queryTool, matQueryTool, compQueryTool);
        } catch (QueryFailedException | NotFoundException ex) {
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
