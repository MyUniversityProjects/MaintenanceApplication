/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignactivity;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalTime;
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
    
    private AssignActivityModel model;
    private AssignActivityView view;
    private int activityID;
    private int day;
    private String cf;
    private String week;
    private boolean mokeUp = true;
    private JTable table;
    private DefaultTableModel tableModel;
    private int nCols = 9;
    private JLabel jLabelError;
    private JTextArea jArea;
    private String[][] maintainers = null;
      
    public AssignActivityController(AssignActivityView view, AssignActivityModel model, int activityID) throws SQLException {
        
        this.model = model;
        this.view = view;
        this.activityID = activityID;
        
        week = model.getWeekActivity(activityID);
        view.getLabelNameActivity().setText(model.getStringActivity(activityID));
        
        table = view.getTable();
        String[] cols = {"Maintainer","Skills","Mon","Tue","Wed", "Thu","Fri","Sat","Sun"};     
        tableModel = new DefaultTableModel(cols,1);
        table.setModel(tableModel);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        
        jLabelError = view.getLabelError();
        jArea = view.getTxtArea();
        
        mokeUp = true; 
        fillFrame();
        
    }
    
    private void setTableMaintainers() throws SQLException {
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
    
    private void setTableAssign() throws SQLException {
        String[] cols = {"Maintainer","Skills","8-00 - 9.00","9.00 - 10.00","10.00 - 11.00", "11.00-12-00","14.00 - 15.00","15.00 - 16.00","16-00 - 17.00"};
        tableModel.setColumnIdentifiers(cols);
        writeRowAvaibilityDayMaintainer(cf);
    }
    
    protected void writeRowAvaibilityDayMaintainer(String code) throws SQLException {
        int[] avaibility = model.getDayAvaibility(code, week, day);
        String nameMaintainer = model.getNameMaintainer(code);
        tableModel.setValueAt(nameMaintainer, 0, 0);
        for(int i=0; i<nCols-2; i++)
            tableModel.setValueAt(avaibility[i], 0, i+2);
    }
    
    private void setArea1() {
        
    }
    
    private void setArea2() throws SQLException {
        jArea.setText(model.getNotes(activityID));
    }
    
    private void ButtonAssign1() throws SQLException {
        cf = maintainers[1][view.getRow()];
        day = view.getCol()-1;
        mokeUp = false;
        fillFrame();
        view.setColZero();
        view.setRowZero();
    }
    
    private void ButtonAssign2() throws SQLException {
        int result = assignActivity(view.getCol(), activityID, cf, week, day);
            
            if(result == 1) {
                jLabelError.setText("Assignment success");
                view.getNav().goHome();
            }
            if(result == 0) jLabelError.setText("Activity is already assigned");
            if(result == -1) jLabelError.setText("Devi selezionare una cella con dei minuti disponibili");
            if(result == -2) jLabelError.setText("Non c'è abbastanza tempo per svolgere l' attività di manutenzione selezionata");
            
            jLabelError.setVisible(true);
    }
    
    private void ButtonBack1() {
        view.getNav().pop();
    }
    
    private void ButtonBack2() throws SQLException {
        changeFrame();
    }
    
    protected void emptyTable() {
        int i = tableModel.getRowCount()-1;
        while(tableModel.getRowCount() > 0) {
            tableModel.removeRow(i);
            i--;
        }
    }
    
    private void fillFrame() throws SQLException {
        view.removeButtonAssignListener();
        view.removeButtonBackListener();
        emptyTable();
        
        if (mokeUp) {
            view.getLabelNumberOfWeek().setText(week);
            setTableMaintainers();
            setArea1();
            view.addButtonBackListener((e) -> ButtonBack1());
            view.addButtonAssignListener((e) -> {
                try {
                    ButtonAssign1();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignActivityController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        else {
            view.getLabelNumberOfWeek().setText(week+" "+tableModel.getColumnClass(day+1));
            setTableAssign();
            setArea2();
            view.addButtonBackListener((e) -> {
                try {
                    ButtonBack2();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignActivityController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            view.addButtonAssignListener((e) -> {
                try {
                    ButtonAssign2();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignActivityController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }
    
    protected void changeFrame() throws SQLException {
        mokeUp = !mokeUp;
        fillFrame();
    }
    
    public Integer assignActivity(int col, int activityID, String cf, String week, int day) throws SQLException {
        int index = col-2;
        int[] avaibility = model.getDayAvaibility(cf, week, day);
        int timeActivity = model.getEstimatedTimeActivity(activityID);
        if(avaibility[index] == 0) {
            return -1; //"ERRORE: Devi selezionare una cella con dei minuti disponibili"
        }
        
        int hourStart, minuteStart, hourEnd, minuteEnd;
        
        if(avaibility[index] < timeActivity) {
            int time = avaibility[index];
            int i = 1;
                while(((index+i)<7) && (avaibility[index+i] == 60) && (time < timeActivity)) {
                    time += 60;
                    i++;
                }
                if(time < timeActivity) 
                    return -2; //"ERRORE: Non c'è abbastanza tempo per svolgere l' attività di manutenzione selezionata"
                                        
        }
        if(col > 5)
            hourStart = col + 8;
        else
            hourStart = col + 6;
                    
        minuteStart = 60 - avaibility[index];
                    
                    
        LocalTime start = LocalTime.of(hourStart, minuteStart);
        LocalTime end = start.plusMinutes(timeActivity);
        
        try {
            int x = model.insertAssign(cf, activityID, day, start, end);
            if (x > 0)
                return 1; //"Assignment carry out with success"
            else 
                return 0;//"Activity is already assigned"
            
        } catch (SQLException ex) {
            System.out.println("ERRORE: ASSEGNAMENTO NON RIUSCITO");
        }
        return -3;
    }
    
    private int sumIntVector(int[] vector) {
        if((vector == null) || (vector.length < 1))
            return 0;
        int sum = vector[0];
        for(int i=1; i<vector.length; i++)
            sum += vector[i];
        return sum;
    }
    
}
