package root.screens.modifyselectedactivity;


import java.awt.event.ActionListener;
import root.Navigable;
import root.Screen;

public class ModifySelectedActivityView extends Screen {

    public ModifySelectedActivityView(Navigable nav, ModifySelectedActivityModel model) {
        super(nav);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        interruptibleGroupInput = new javax.swing.ButtonGroup();
        typeGroupInput = new javax.swing.ButtonGroup();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        typeUnscheduledInput = new javax.swing.JRadioButton();
        typologyLabel = new javax.swing.JLabel();
        descriptionScrollInput = new javax.swing.JScrollPane();
        descriptionInput = new javax.swing.JTextArea();
        interruptibleLabel = new javax.swing.JLabel();
        BranchOfficeLabel = new javax.swing.JLabel();
        typeInputScheduled = new javax.swing.JRadioButton();
        areaLabel = new javax.swing.JLabel();
        mandatoryLabel = new javax.swing.JLabel();
        createActivityTitleLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JButton();
        notesLabel = new javax.swing.JLabel();
        weekLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        interruptibleNoInput = new javax.swing.JRadioButton();
        estimatedTimeLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        notesScrollInput = new javax.swing.JScrollPane();
        notesInput = new javax.swing.JTextArea();
        interruptibleYesInput = new javax.swing.JRadioButton();
        descriptionLabel = new javax.swing.JLabel();
        msg_label = new javax.swing.JLabel();
        typeExtraWorkInput = new javax.swing.JRadioButton();
        idInput = new javax.swing.JTextField();
        branchOfficeInput = new javax.swing.JTextField();
        areaInput = new javax.swing.JTextField();
        typologyInput = new javax.swing.JTextField();
        estimatedTimeInput = new javax.swing.JTextField();
        weekInput = new javax.swing.JTextField();
        materialsLabel = new javax.swing.JLabel();
        notesScrollInput1 = new javax.swing.JScrollPane();
        materialsInput = new javax.swing.JTextArea();
        homeBtn = new javax.swing.JButton();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(1);
        jScrollPane3.setViewportView(jTextArea3);

        setAutoscrolls(true);
        setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jPanel1.setAutoscrolls(true);

        typeGroupInput.add(typeUnscheduledInput);
        typeUnscheduledInput.setText("Unscheduled");

        typologyLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typologyLabel.setText("Typology *");

        descriptionInput.setColumns(20);
        descriptionInput.setRows(5);
        descriptionScrollInput.setViewportView(descriptionInput);

        interruptibleLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        interruptibleLabel.setText("Interruptible *");

        BranchOfficeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BranchOfficeLabel.setText("Branch office *");

        typeGroupInput.add(typeInputScheduled);
        typeInputScheduled.setSelected(true);
        typeInputScheduled.setText("Scheduled");

        areaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        areaLabel.setText("Area *");

        mandatoryLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mandatoryLabel.setText("Fields with the symbol * are required");

        createActivityTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        createActivityTitleLabel.setText("MODIFY ACTIVITY");

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idLabel.setText("ID *");

        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        notesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        notesLabel.setText("Workspace notes");

        weekLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        weekLabel.setText("Week [1, 52] *");

        typeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typeLabel.setText("Type *");

        interruptibleGroupInput.add(interruptibleNoInput);
        interruptibleNoInput.setText("No");

        estimatedTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        estimatedTimeLabel.setText("Estimated intervantion time (minutes) *");

        backBtn.setText("back");

        notesInput.setColumns(20);
        notesInput.setRows(5);
        notesScrollInput.setViewportView(notesInput);

        interruptibleGroupInput.add(interruptibleYesInput);
        interruptibleYesInput.setSelected(true);
        interruptibleYesInput.setText("Yes");

        descriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descriptionLabel.setText("Description *");

        typeGroupInput.add(typeExtraWorkInput);
        typeExtraWorkInput.setText("Extra work");

        materialsLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        materialsLabel.setText("Materials");

        materialsInput.setColumns(20);
        materialsInput.setRows(5);
        notesScrollInput1.setViewportView(materialsInput);

        homeBtn.setText("home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(areaInput)
                    .addComponent(modifyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(descriptionScrollInput, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(notesScrollInput, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idInput)
                    .addComponent(branchOfficeInput)
                    .addComponent(typologyInput)
                    .addComponent(estimatedTimeInput)
                    .addComponent(weekInput)
                    .addComponent(notesScrollInput1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel)
                            .addComponent(notesLabel)
                            .addComponent(areaLabel)
                            .addComponent(typologyLabel)
                            .addComponent(estimatedTimeLabel)
                            .addComponent(weekLabel)
                            .addComponent(BranchOfficeLabel)
                            .addComponent(typeLabel)
                            .addComponent(idLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(interruptibleYesInput)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(interruptibleNoInput))
                            .addComponent(interruptibleLabel)
                            .addComponent(mandatoryLabel)
                            .addComponent(msg_label)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(typeInputScheduled)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(typeUnscheduledInput)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(typeExtraWorkInput))
                            .addComponent(materialsLabel))
                        .addGap(0, 200, Short.MAX_VALUE)))
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(backBtn)
                .addGap(106, 106, 106)
                .addComponent(createActivityTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeBtn)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(createActivityTitleLabel)
                    .addComponent(homeBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BranchOfficeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(branchOfficeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typologyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typologyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estimatedTimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estimatedTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionScrollInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notesScrollInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notesScrollInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(msg_label)
                .addGap(31, 31, 31)
                .addComponent(typeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeInputScheduled)
                    .addComponent(typeUnscheduledInput)
                    .addComponent(typeExtraWorkInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(interruptibleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interruptibleYesInput)
                    .addComponent(interruptibleNoInput))
                .addGap(18, 18, 18)
                .addComponent(mandatoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(modifyBtn)
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

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BranchOfficeLabel;
    private javax.swing.JTextField areaInput;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField branchOfficeInput;
    private javax.swing.JLabel createActivityTitleLabel;
    private javax.swing.JTextArea descriptionInput;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScrollInput;
    private javax.swing.JTextField estimatedTimeInput;
    private javax.swing.JLabel estimatedTimeLabel;
    private javax.swing.JButton homeBtn;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idLabel;
    private javax.swing.ButtonGroup interruptibleGroupInput;
    private javax.swing.JLabel interruptibleLabel;
    private javax.swing.JRadioButton interruptibleNoInput;
    private javax.swing.JRadioButton interruptibleYesInput;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel mandatoryLabel;
    private javax.swing.JTextArea materialsInput;
    private javax.swing.JLabel materialsLabel;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JLabel msg_label;
    private javax.swing.JTextArea notesInput;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JScrollPane notesScrollInput;
    private javax.swing.JScrollPane notesScrollInput1;
    private javax.swing.JRadioButton typeExtraWorkInput;
    private javax.swing.ButtonGroup typeGroupInput;
    private javax.swing.JRadioButton typeInputScheduled;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JRadioButton typeUnscheduledInput;
    private javax.swing.JTextField typologyInput;
    private javax.swing.JLabel typologyLabel;
    private javax.swing.JTextField weekInput;
    private javax.swing.JLabel weekLabel;
    // End of variables declaration//GEN-END:variables

    
    // Input Getter
    public String getId(){
        return idInput.getText();
    }
    
    public String getBranchOffice(){
        return branchOfficeInput.getText();
    }
    
    public String getArea(){
        return areaInput.getText();
    }
    
    public String getEstimatedTime(){
        return estimatedTimeInput.getText();
    }
    
    public String getInterruptible(){
        interruptibleNoInput.setActionCommand("false");
        interruptibleYesInput.setActionCommand("true");
        return interruptibleGroupInput.getSelection().getActionCommand();
    }
    
    public String getTypology(){
        return typologyInput.getText();
    }
    
    public String getWeek(){
        return weekInput.getText();
    }
    
    public String getNotes(){
        return notesInput.getText();
    }
    
    public String getDescription(){
        return descriptionInput.getText();
    }
    
    public String getType(){
        typeInputScheduled.setActionCommand("PLANNED");
        typeUnscheduledInput.setActionCommand("UNPLANNED");
        typeExtraWorkInput.setActionCommand("EXTRA");
        return typeGroupInput.getSelection().getActionCommand();
    }
    
    public javax.swing.JLabel getMsgLabel(){
        return msg_label;
    }

    void addModifyButtonListener(ActionListener al) {
        modifyBtn.addActionListener(al);
    }
    
    void addBackButtonListener(ActionListener al){
        backBtn.addActionListener(al);
    }
    
    void addHomeButtonListener(ActionListener al){
        backBtn.addActionListener(al);
    }
}