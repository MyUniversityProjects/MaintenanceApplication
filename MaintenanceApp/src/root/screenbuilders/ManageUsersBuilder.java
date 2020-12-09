package root.screenbuilders;

import queries.UserQueries;
import root.Navigable;
import root.Screen;
import root.exceptions.QueryFailedException;
import root.screens.manageusers.*;

public class ManageUsersBuilder extends ScreenBuilder {
    private ManageUsersModel model;
    private ManageUsersView view;
    private ManageUsersController controller;

    @Override
    public void buildController() {
        if (model != null)
            controller = new ManageUsersController(model, view);
    }

    @Override
    public void buildModel() {
        UserQueries queryTool = new UserQueries();
        try {
            model = ManageUsersModel.fromDatabase(queryTool);
        } catch(QueryFailedException ex) {
            model = null;
        }
    }

    @Override
    public void buildView(Navigable nav) {
        view = new ManageUsersView(nav, model);
    }

    @Override
    public Screen getScreen() {
        return view;
    }
}
