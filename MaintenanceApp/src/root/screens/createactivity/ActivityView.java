package root.screens.createactivity;


import java.awt.event.ActionListener;
import root.Navigable;
import root.Screen;

public class ActivityView extends Screen {

    public ActivityView(Navigable nav) {
        super(nav);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        interruptible_input_group = new javax.swing.ButtonGroup();
        type_input_group = new javax.swing.ButtonGroup();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        type_input_unscheduled = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        description_input = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        id_input = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        type_input_scheduled = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        create_btn = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        estimated_time_input = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        area_input = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        interruptible_input_no = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        branch_office_input = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        week_input = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        notes_input = new javax.swing.JTextArea();
        interruptible_input_yes = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        typology_input = new javax.swing.JTextArea();
        msg_label = new javax.swing.JLabel();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(1);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("branch office");

        setAutoscrolls(true);
        setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jPanel1.setAutoscrolls(true);

        type_input_group.add(type_input_unscheduled);
        type_input_unscheduled.setText("Unscheduled");
        type_input_unscheduled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_input_unscheduledActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Typology *");

        description_input.setColumns(20);
        description_input.setRows(5);
        jScrollPane9.setViewportView(description_input);

        id_input.setColumns(20);
        id_input.setRows(1);
        jScrollPane1.setViewportView(id_input);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Interruptible *");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Branch office *");

        type_input_group.add(type_input_scheduled);
        type_input_scheduled.setSelected(true);
        type_input_scheduled.setText("Scheduled");
        type_input_scheduled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_input_scheduledActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Area *");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Fields with the symbol * are required");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CREATE ACTIVITY");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID *");

        create_btn.setText("Create");
        create_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_btnActionPerformed(evt);
            }
        });

        estimated_time_input.setColumns(20);
        estimated_time_input.setRows(1);
        jScrollPane7.setViewportView(estimated_time_input);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Workspace notes");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Week [1, 52] *");

        area_input.setColumns(20);
        area_input.setRows(1);
        jScrollPane4.setViewportView(area_input);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Type *");

        interruptible_input_group.add(interruptible_input_no);
        interruptible_input_no.setText("No");
        interruptible_input_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interruptible_input_noActionPerformed(evt);
            }
        });

        branch_office_input.setColumns(20);
        branch_office_input.setRows(1);
        jScrollPane2.setViewportView(branch_office_input);

        week_input.setColumns(20);
        week_input.setRows(1);
        jScrollPane8.setViewportView(week_input);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Estimated intervantion time (minutes) *");

        back_btn.setText("back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        notes_input.setColumns(20);
        notes_input.setRows(5);
        jScrollPane10.setViewportView(notes_input);

        interruptible_input_group.add(interruptible_input_yes);
        interruptible_input_yes.setSelected(true);
        interruptible_input_yes.setText("Yes");
        interruptible_input_yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interruptible_input_yesActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Description *");

        typology_input.setColumns(20);
        typology_input.setRows(1);
        jScrollPane5.setViewportView(typology_input);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back_btn)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel14))
                                .addGap(0, 346, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(create_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane8)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel3)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(type_input_scheduled)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(type_input_unscheduled))
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel2)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(interruptible_input_yes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(interruptible_input_no))
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel12)
                                            .addComponent(msg_label))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(42, 42, 42))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type_input_scheduled)
                    .addComponent(type_input_unscheduled))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interruptible_input_yes)
                    .addComponent(interruptible_input_no))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(create_btn)
                .addGap(54, 54, 54))
        );

        jScrollPane6.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void interruptible_input_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interruptible_input_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interruptible_input_noActionPerformed

    private void create_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_btnActionPerformed
        
    }//GEN-LAST:event_create_btnActionPerformed

    private void interruptible_input_yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interruptible_input_yesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interruptible_input_yesActionPerformed

    private void type_input_scheduledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_input_scheduledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_input_scheduledActionPerformed

    private void type_input_unscheduledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_input_unscheduledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_input_unscheduledActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        //super.getNav().pop();
    }//GEN-LAST:event_back_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_input;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextArea branch_office_input;
    private javax.swing.JButton create_btn;
    private javax.swing.JTextArea description_input;
    private javax.swing.JTextArea estimated_time_input;
    private javax.swing.JTextArea id_input;
    private javax.swing.ButtonGroup interruptible_input_group;
    private javax.swing.JRadioButton interruptible_input_no;
    private javax.swing.JRadioButton interruptible_input_yes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel msg_label;
    private javax.swing.JTextArea notes_input;
    private javax.swing.ButtonGroup type_input_group;
    private javax.swing.JRadioButton type_input_scheduled;
    private javax.swing.JRadioButton type_input_unscheduled;
    private javax.swing.JTextArea typology_input;
    private javax.swing.JTextArea week_input;
    // End of variables declaration//GEN-END:variables

    
    // Input Getter
    public String getId(){
        return id_input.getText();
    }
    
    public String getBranchOffice(){
        return branch_office_input.getText();
    }
    
    public String getArea(){
        return area_input.getText();
    }
    
    public String getEstimatedTime(){
        return estimated_time_input.getText();
    }
    
    public String getInterruptible(){
        interruptible_input_no.setActionCommand("false");
        interruptible_input_yes.setActionCommand("true");
        return interruptible_input_group.getSelection().getActionCommand();
    }
    
    public String getTypology(){
        return typology_input.getText();
    }
    
    public String getWeek(){
        return week_input.getText();
    }
    
    public String getNotes(){
        return notes_input.getText();
    }
    
    public String getDescription(){
        return description_input.getText();
    }
    
    public String getType(){
        type_input_scheduled.setActionCommand("scheduled");
        type_input_unscheduled.setActionCommand("unscheduled");
        return type_input_group.getSelection().getActionCommand();
    }
    
    public javax.swing.JLabel getMsgLabel(){
        return msg_label;
    }

    void addCreateButtonListener(ActionListener al) {
        create_btn.addActionListener(al);
    }
    
    void addBackButtonListener(ActionListener al){
        back_btn.addActionListener(al);
    }
}
