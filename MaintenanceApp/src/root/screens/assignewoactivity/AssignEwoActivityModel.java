/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignewoactivity;

import java.sql.SQLException;
import root.screens.assignactivity.AssignActivityModel;

/**
 *
 * @author lex99
 */
public class AssignEwoActivityModel extends AssignActivityModel{
    
    public AssignEwoActivityModel() throws SQLException {
        super();
    }
    
    @Override
    protected String getStringQueryDayAvaibility(String cf, String week, int day) {
        String query = super.getStringQueryDayAvaibility(cf, week, day) + " AND (interruptible = false) ";
        return query;     
    }
    
}
