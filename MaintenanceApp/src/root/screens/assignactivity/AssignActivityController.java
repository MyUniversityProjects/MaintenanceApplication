/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignactivity;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lex99
 */
public class AssignActivityController {
    protected AssignActivityView view;
    protected AssignActivityModel model;
    protected int activityID;
    protected String week;
    protected JTable table;
    protected DefaultTableModel tableModel;
    protected int nCols = 9;
    protected JLabel jLabelError;
    protected JTextArea jArea;
               
    public AssignActivityController(AssignActivityView view, AssignActivityModel model, int activityID) throws SQLException {
        this.view = view;
        this.model = model;
        this.activityID = activityID;
        
        week = model.getWeekActivity(activityID);
        view.getLabelNameActivity().setText(model.getStringActivity(activityID));
        table = view.getTable();
        String[] cols = {"Maintainer","Skills","Mon","Tue","Wed", "Thu","Fri","Sat","Sun"};     
        tableModel = new DefaultTableModel(cols, 1);
        table.setModel(tableModel);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        
        jLabelError = view.getLabelError();
        jArea = view.getTxtArea();
        
        addButtonBackListener();
        addButtonAssignListener();
    }
    
    protected void setTable() throws SQLException{}
    protected void setArea() throws SQLException{}
    protected void setButtonAssign(){}
    protected void setButtonBack(){}
    
    protected void addButtonBackListener() {
        view.addButtonBackListener((e) -> setButtonBack());
    }
    
    protected void addButtonAssignListener() {
        view.addButtonAssignListener((e) -> setButtonAssign());
    }
    
    protected void emptyTable() {
        int i = tableModel.getRowCount()-1;
        while(tableModel.getRowCount() > 0) {
            tableModel.removeRow(i);
            i--;
        }
    }
     
}
