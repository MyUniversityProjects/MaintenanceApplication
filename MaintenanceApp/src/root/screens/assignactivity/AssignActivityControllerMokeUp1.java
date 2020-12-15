/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignactivity;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import root.screenbuilders.AssignActivityMokeUp2Builder;

/**
 *
 * @author lex99
 */
public class AssignActivityControllerMokeUp1 extends AssignActivityController{
    private String[][] maintainers = null;
    
    public AssignActivityControllerMokeUp1(AssignActivityView view, AssignActivityModel model, int activityID) throws SQLException {
        super(view, model, activityID);
        setTable();
        setArea();
        System.out.println(maintainers);
        view.getLabelNumberOfWeek().setText(week);
        
        
        
    }
    
    @Override
    protected void setTable() throws SQLException{
        String[] cols = {"Maintainer","Skills","Mon","Tue","Wed", "Thu","Fri","Sat","Sun"};
        tableModel.setColumnIdentifiers(cols);

        maintainers = model.getMaintainers();
        tableModel.setNumRows(maintainers[0].length);
        int avaibilityDay;
        for(int j=0; j<maintainers[1].length;j++) {   
            tableModel.setValueAt(maintainers[0][j] + " " + maintainers[2][j], j, 0);
            for(int i=1; i<8;i++) {
                avaibilityDay=(sumIntVector(model.getDayAvaibility(maintainers[1][j], week, i))) * 100 / 420;
                tableModel.setValueAt(avaibilityDay, j, i+1);                    
            }
        }
    }
    
    @Override
    protected void setArea() throws SQLException{
        
    }
    
    
    @Override
    protected void setButtonBack() {
        view.getNav().pop();
    }
    
    @Override
    protected void setButtonAssign() {
        String cf = maintainers[1][view.getRow()];
        int col = view.getCol()-1;
        view.getNav().push(new AssignActivityMokeUp2Builder(activityID, col, cf));
        
    }
    
    public static int sumIntVector(int[] vector) {
        if((vector == null) || (vector.length < 1))
            return 0;
        int sum = vector[0];
        for(int i=1; i<vector.length; i++)
            sum += vector[i];
        return sum;
    }
    
    
}
