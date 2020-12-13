/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignewoactivity;

import java.sql.SQLException;
import root.screens.assignactivity.AssignActivityController;
import root.screens.assignactivity.AssignActivityModel;
import root.screens.assignactivity.AssignActivityView;

/**
 *
 * @author lex99
 */
public class AssignEwoActivityController extends AssignActivityController{
    
    public AssignEwoActivityController(AssignActivityView view, AssignActivityModel model, int activityID) throws SQLException {
        super(view, model, activityID);
    }
    
}
