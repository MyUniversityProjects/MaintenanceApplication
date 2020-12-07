package root.screenbuilders;

import queries.UserQueries;
import root.Navigable;
import root.Screen;
import root.screens.manageusers.*;

public class ManageUsersBuilder extends ScreenBuilder {
    private ManageUsersModel model;
    private ManageUsersView view;
    private ManageUsersController controller;

    @Override
    public void buildController() {
        controller = new ManageUsersController(model, view);
    }

    @Override
    public void buildModel() {
        UserQueries queryTool = new UserQueries();
        model = new ManageUsersModel(queryTool);
        model.fetch();
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
