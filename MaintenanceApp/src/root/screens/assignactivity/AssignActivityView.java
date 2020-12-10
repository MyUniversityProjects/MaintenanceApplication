/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package root.screens.assignactivity;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import root.Navigable;
import root.Screen;

/**
 *
 * @author lex99
 */
public class AssignActivityView extends Screen {
    private  AssignActivityController controller;
    private int activityID;
    private int day;
    private String cf;
    private String week;
    private int timeActivity;
    private DefaultTableModel tableModel;
    private int nCols = 9;
    private int rowSelected = 0;
    private int colSelected = 0;

    /**
     * Creates new form AssignActivityView
     */
    public AssignActivityView(Navigable nav) throws SQLException {
        super(nav);
        initComponents();
        jLabelError.setVisible(false);
        /*
        controller = new AssignActivityController();
        week = controller.weekActivity(this.activityID);
        timeActivity = controller.estimatedTimeActivity(this.activityID);
        jLabelError.setVisible(false);
        jLabelNameActivity.setText(controller.stringActivity(this.activityID));
        jLabelNumberOfWeek.setText(week);
        jArea.setText(controller.notes(this.activityID));
        formatTable();
        setTable(); */
        
        
          
        
    }
    
    /*
    private void formatTable() {
        // inizializate the structure of the table with the cols
        String[] cols = {"Maintainer","Skills","8-00 - 9.00","9.00 - 10.00","10.00 - 11.00", "11.00-12-00","14.00 - 15.00","15.00 - 16.00","16-00 - 17.00"};
        tableModel = new DefaultTableModel(cols,1);
        jTableAvaibility.setModel(tableModel);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTableAvaibility.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        
    }
    
    private void setTable() throws SQLException {
        // set the table with the avaibility of maintainer in time slots
        int[] avaibility = controller.dayAvaibility(cf, week, day);
        String nameMaintainer = controller.nameMaintainer(cf);
        tableModel.setValueAt(nameMaintainer, 0, 0);
        for(int i=0; i<nCols-2; i++)
            tableModel.setValueAt(avaibility[i], 0, i+2);
    } */
    
    public void setColZero() {
        colSelected = 0;
    }
    
    public void setRowZero() {
        rowSelected = 0;
    }
    
    public JTable getTable() {
        return jTableAvaibility;
    }
    
    public int getCol() {
        return colSelected;
    }
    
    public int getRow() {
        return rowSelected;
    }
    
    public JLabel getLabelError() {
        return jLabelError;
    }
    
    public JTextArea getTxtArea() {
        return jArea;
    }
    
    public JLabel getLabelNameActivity() {
        return jLabelNameActivity;
    }
    
    public JLabel getLabelNumberOfWeek() {
        return jLabelNumberOfWeek;
    }
    
    public void addButtonAssignListener(ActionListener al){
        jButtonAssign.addActionListener(al);
    }
    
    public void addButtonBackListener(ActionListener al){
        jButtonBack.addActionListener(al);
    }
    
    

    /*protected void assign() {
            if((colSelected < 2) || (tableModel.getValueAt(rowSelected, colSelected).equals(0))) {
            jLabelError.setText("ERRORE: Devi selezionare una cella con dei minuti disponibili");
            jLabelError.setVisible(true);
            return;
        }
        
        int hourStart, minuteStart, hourEnd, minuteEnd;
        
        if((Integer.parseInt(tableModel.getValueAt(rowSelected, colSelected).toString()))< timeActivity) {
            int time = Integer.parseInt(tableModel.getValueAt(rowSelected, colSelected).toString());
            int i = 1;
                while(((Integer.parseInt(tableModel.getValueAt(rowSelected, colSelected+i).toString())) == 60) && (time < timeActivity)) {
                    time += 60;
                    i++;
                }
                if(time < timeActivity) {
                    jLabelError.setText("ERRORE: Non c'è abbastanza tempo per svolgere l' attività di manutenzione selezionata");
                    jLabelError.setVisible(true);
                    return;
                }
                            
        }
        if(colSelected > 5)
            hourStart = colSelected + 8;
        else
            hourStart = colSelected + 6;
                    
        minuteStart = 60 - Integer.parseInt(tableModel.getValueAt(rowSelected, colSelected).toString());
                    
                    
        LocalTime start = LocalTime.of(hourStart, minuteStart);
        LocalTime end = start.plusMinutes(timeActivity);
        
        try {
            int x = controller.assignActivity(day, start, end);
            if (x > 0) {
                jLabelError.setText("Assignment carry out with success");
                jLabelError.setBackground(Color.green);
                jLabelError.setVisible(true);
                setTable();
            } else {
                jLabelError.setText("Activity is already assigned");
                jLabelError.setBackground(Color.red);
                jLabelError.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println("ERRORE: ASSEGNAMENTO COL BUTTON NON RIUSCITO");
            Logger.getLogger(AssignActivityView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelNumberOfWeek = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelNameActivity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAvaibility = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jArea = new javax.swing.JTextArea();
        jButtonAssign = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();

        jLabel1.setText("Week Number");

        jLabelNumberOfWeek.setText("27");

        jLabel3.setText("Activity to Assign");

        jLabelNameActivity.setText("Name Activity");

        jLabel5.setText("Notes");

        jLabel6.setText("Maintaner AVAIBILITY");
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTableAvaibility.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Maintainer", "Skills", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
            }
        ));
        jTableAvaibility.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAvaibilityMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableAvaibility);

        jArea.setColumns(20);
        jArea.setRows(5);
        jScrollPane2.setViewportView(jArea);

        jButtonAssign.setText("Assign");
        jButtonAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssignActionPerformed(evt);
            }
        });

        jLabelError.setText("jLabelError");

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45)
                                .addComponent(jLabelNumberOfWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jLabelNameActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(jButtonAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(361, 361, 361))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNumberOfWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNameActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBack))))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jButtonAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jLabelError)
                .addGap(70, 70, 70))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignActionPerformed
    
        
    }//GEN-LAST:event_jButtonAssignActionPerformed

    private void jTableAvaibilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAvaibilityMouseClicked
        rowSelected = jTableAvaibility.getSelectedRow();
        colSelected = jTableAvaibility.getSelectedColumn();
    }//GEN-LAST:event_jTableAvaibilityMouseClicked

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        Screen pop = this.getNav().pop();
    }//GEN-LAST:event_jButtonBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jArea;
    private javax.swing.JButton jButtonAssign;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelNameActivity;
    private javax.swing.JLabel jLabelNumberOfWeek;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAvaibility;
    // End of variables declaration//GEN-END:variables
}
