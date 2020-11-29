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
        interruptible_input_group = new javax.swing.ButtonGroup();
        type_input_group = new javax.swing.ButtonGroup();
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
        createBtn = new javax.swing.JButton();
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

        jTextArea3.setColumns(20);
        jTextArea3.setRows(1);
        jScrollPane3.setViewportView(jTextArea3);

        setAutoscrolls(true);
        setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jPanel1.setAutoscrolls(true);

        type_input_group.add(typeUnscheduledInput);
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

        type_input_group.add(typeInputScheduled);
        typeInputScheduled.setSelected(true);
        typeInputScheduled.setText("Scheduled");

        areaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        areaLabel.setText("Area *");

        mandatoryLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mandatoryLabel.setText("Fields with the symbol * are required");

        createActivityTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        createActivityTitleLabel.setText("CREATE ACTIVITY");

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idLabel.setText("ID *");

        createBtn.setText("Create");

        notesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        notesLabel.setText("Workspace notes");

        weekLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        weekLabel.setText("Week [1, 52] *");

        typeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typeLabel.setText("Type *");

        interruptible_input_group.add(interruptibleNoInput);
        interruptibleNoInput.setText("No");

        estimatedTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        estimatedTimeLabel.setText("Estimated intervantion time (minutes) *");

        backBtn.setText("back");

        notesInput.setColumns(20);
        notesInput.setRows(5);
        notesScrollInput.setViewportView(notesInput);

        interruptible_input_group.add(interruptibleYesInput);
        interruptibleYesInput.setSelected(true);
        interruptibleYesInput.setText("Yes");

        descriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descriptionLabel.setText("Description *");

        type_input_group.add(typeExtraWorkInput);
        typeExtraWorkInput.setText("Extra work");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(88, 88, 88)
                        .addComponent(createActivityTitleLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(areaInput)
                            .addComponent(createBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descriptionScrollInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(notesScrollInput, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idInput)
                            .addComponent(branchOfficeInput)
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
                                        .addComponent(typeExtraWorkInput)))
                                .addGap(0, 194, Short.MAX_VALUE))
                            .addComponent(typologyInput)
                            .addComponent(estimatedTimeInput)
                            .addComponent(weekInput))
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(createActivityTitleLabel))
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
                .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(createBtn)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BranchOfficeLabel;
    private javax.swing.JTextField areaInput;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField branchOfficeInput;
    private javax.swing.JLabel createActivityTitleLabel;
    private javax.swing.JButton createBtn;
    private javax.swing.JTextArea descriptionInput;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane descriptionScrollInput;
    private javax.swing.JTextField estimatedTimeInput;
    private javax.swing.JLabel estimatedTimeLabel;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel interruptibleLabel;
    private javax.swing.JRadioButton interruptibleNoInput;
    private javax.swing.JRadioButton interruptibleYesInput;
    private javax.swing.ButtonGroup interruptible_input_group;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel mandatoryLabel;
    private javax.swing.JLabel msg_label;
    private javax.swing.JTextArea notesInput;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JScrollPane notesScrollInput;
    private javax.swing.JRadioButton typeExtraWorkInput;
    private javax.swing.JRadioButton typeInputScheduled;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JRadioButton typeUnscheduledInput;
    private javax.swing.ButtonGroup type_input_group;
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
        return interruptible_input_group.getSelection().getActionCommand();
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
        typeInputScheduled.setActionCommand("scheduled");
        typeUnscheduledInput.setActionCommand("unscheduled");
        return type_input_group.getSelection().getActionCommand();
    }
    
    public javax.swing.JLabel getMsgLabel(){
        return msg_label;
    }

    void addCreateButtonListener(ActionListener al) {
        createBtn.addActionListener(al);
    }
    
    void addBackButtonListener(ActionListener al){
        backBtn.addActionListener(al);
    }
}
