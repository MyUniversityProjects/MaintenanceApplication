/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screenbuilders;

import queries.ActivityQueries;
import root.Navigable;
import root.Screen;
import root.exceptions.NotFoundException;
import root.exceptions.QueryFailedException;
import root.screens.modifyselectedactivity.*;
/**
 *
 * @author ficca
 */
public class ModifySelectedActivityBuilder extends ScreenBuilder{
    private final int id;
    private ModifySelectedActivityView view;
    private ModifySelectedActivityModel model;
    private ModifySelectedActivityController controller;

    public ModifySelectedActivityBuilder(int id) {
        this.id = id;
    }

    @Override
    public void buildController() {
        controller = new ModifySelectedActivityController(model, view);
    }

    @Override
    public void buildModel() {
        ActivityQueries query = new ActivityQueries();
        try {
            model = ModifySelectedActivityModel.fromDatabase(id, query);
        } catch (QueryFailedException | NotFoundException ex) {
            model = null;
        }
    }
    
    @Override
    public void buildView(Navigable nav) {
        view = new ModifySelectedActivityView(nav, model);
    }

    @Override
    public Screen getScreen() {
        return view;
    }
}
