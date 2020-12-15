/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignewoactivity;

import java.sql.SQLException;
import root.screens.assignactivity.AssignActivityControllerMokeUp2;
import root.screens.assignactivity.AssignActivityModel;
import root.screens.assignactivity.AssignActivityView;

/**
 *
 * @author lex99
 */
public class AssignEwoActivityController extends AssignActivityControllerMokeUp2{
    
    String[][] maintainers = null;
    
    public AssignEwoActivityController(AssignActivityView view, AssignEwoActivityModel model, int activityID, int day, String cf) throws SQLException {
        super(view, model, activityID, day, cf);
        
    }
    
    @Override
    protected void setTable() throws SQLException {
        
        super.setTable();
        maintainers = model.getMaintainers();
        
        tableModel.setNumRows(maintainers[1].length);
        
        for(int j=0; j<maintainers[1].length;j++) {   
            tableModel.setValueAt(maintainers[0][j] + " " + maintainers[2][j], j, 0);
            writeRowAvaibilityDayMaintainer(maintainers[1][j], j);
        }
        
    }
    
    @Override
    protected void setButtonAssign() {
        // Implemetns this function on the next user stories
    } 
    
    
}
