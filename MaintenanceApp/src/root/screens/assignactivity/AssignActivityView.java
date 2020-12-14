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
    //private DefaultTableModel tableModel;
    private int rowSelected = 0;
    private int colSelected = 0;

    /**
     * Creates new form AssignActivityView
     */
    public AssignActivityView(Navigable nav) throws SQLException {
        super(nav);
        initComponents();
        jLabelError.setVisible(false);
    
    }
    
    
    
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
    
    public void removeButtonAssignListener() {
        for( ActionListener al : jButtonAssign.getActionListeners()) 
            jButtonAssign.removeActionListener( al );
        
    }
    
    public void removeButtonBackListener() {
        for( ActionListener al : jButtonBack.getActionListeners()) 
            jButtonBack.removeActionListener( al );
        
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelWN = new javax.swing.JLabel();
        jLabelNumberOfWeek = new javax.swing.JLabel();
        jLabelATA = new javax.swing.JLabel();
        jLabelNameActivity = new javax.swing.JLabel();
        jLabelNotes = new javax.swing.JLabel();
        jLabelMA = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAvaibility = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jArea = new javax.swing.JTextArea();
        jButtonAssign = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();

        jLabelWN.setText("Week");

        jLabelNumberOfWeek.setText("27");

        jLabelATA.setText("Activity to Assign");

        jLabelNameActivity.setText("Name Activity");

        jLabelNotes.setText("Notes");

        jLabelMA.setText("Maintaner AVAIBILITY");
        jLabelMA.setFocusable(false);
        jLabelMA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabelNotes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(438, 438, 438)
                        .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelMA, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelWN)
                        .addGap(48, 48, 48)
                        .addComponent(jLabelNumberOfWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(jButtonAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabelATA, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabelNameActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelWN)
                            .addComponent(jLabelNumberOfWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelATA, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNameActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBack))
                        .addGap(38, 38, 38)
                        .addComponent(jLabelNotes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelMA)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addComponent(jButtonAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabelError)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignActionPerformed
    
        
    }//GEN-LAST:event_jButtonAssignActionPerformed

    private void jTableAvaibilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAvaibilityMouseClicked
        rowSelected = jTableAvaibility.getSelectedRow();
        colSelected = jTableAvaibility.getSelectedColumn();
    }//GEN-LAST:event_jTableAvaibilityMouseClicked

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        
    }//GEN-LAST:event_jButtonBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jArea;
    private javax.swing.JButton jButtonAssign;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabelATA;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelMA;
    private javax.swing.JLabel jLabelNameActivity;
    private javax.swing.JLabel jLabelNotes;
    private javax.swing.JLabel jLabelNumberOfWeek;
    private javax.swing.JLabel jLabelWN;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAvaibility;
    // End of variables declaration//GEN-END:variables
}
