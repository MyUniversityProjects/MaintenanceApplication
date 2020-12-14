package root.screens.createactivity;


import java.awt.event.ActionListener;
import root.Navigable;
import root.Screen;

public class ActivityView extends Screen {
    
    private final ActivityModel model;

    public ActivityView(Navigable nav, ActivityModel model) {
        super(nav);
        initComponents();
        this.model = model;
        typologyInput.setModel(model.getTypologyInputModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        interruptibleGroupInput = new javax.swing.ButtonGroup();
        typeGroupInput = new javax.swing.ButtonGroup();
        backBtn = new javax.swing.JButton();
        createActivityTitleLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        descriptionScrollInput = new javax.swing.JScrollPane();
        descriptionInput = new javax.swing.JTextArea();
        branchOfficeInput = new javax.swing.JTextField();
        BranchOfficeLabel = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        areaInput = new javax.swing.JTextField();
        typologyLabel = new javax.swing.JLabel();
        estimatedTimeLabel = new javax.swing.JLabel();
        estimatedTimeInput = new javax.swing.JTextField();
        weekLabel = new javax.swing.JLabel();
        weekInput = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        typeInputScheduled = new javax.swing.JRadioButton();
        typeUnscheduledInput = new javax.swing.JRadioButton();
        typeExtraWorkInput = new javax.swing.JRadioButton();
        interruptibleYesInput = new javax.swing.JRadioButton();
        interruptibleLabel = new javax.swing.JLabel();
        interruptibleNoInput = new javax.swing.JRadioButton();
        mandatoryLabel = new javax.swing.JLabel();
        notesScrollInput1 = new javax.swing.JScrollPane();
        materialsInput = new javax.swing.JTextArea();
        materialsLabel = new javax.swing.JLabel();
        notesScrollInput = new javax.swing.JScrollPane();
        notesInput = new javax.swing.JTextArea();
        notesLabel = new javax.swing.JLabel();
        createBtn = new javax.swing.JButton();
        typologyInput = new javax.swing.JComboBox<>();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(1);
        jScrollPane3.setViewportView(jTextArea3);

        setAutoscrolls(true);
        setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        backBtn.setText("back");

        createActivityTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        createActivityTitleLabel.setText("CREATE ACTIVITY");

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idLabel.setText("ID *");

        descriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descriptionLabel.setText("Description *");

        descriptionInput.setColumns(20);
        descriptionInput.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        descriptionInput.setLineWrap(true);
        descriptionInput.setRows(4);
        descriptionInput.setWrapStyleWord(true);
        descriptionScrollInput.setViewportView(descriptionInput);

        BranchOfficeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BranchOfficeLabel.setText("Branch office *");

        areaLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        areaLabel.setText("Area *");

        typologyLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typologyLabel.setText("Typology *");

        estimatedTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        estimatedTimeLabel.setText("Estimated intervantion time (minutes) *");

        weekLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        weekLabel.setText("Week [1, 52] *");

        typeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typeLabel.setText("Type *");

        typeGroupInput.add(typeInputScheduled);
        typeInputScheduled.setSelected(true);
        typeInputScheduled.setText("Scheduled");

        typeGroupInput.add(typeUnscheduledInput);
        typeUnscheduledInput.setText("Unscheduled");

        typeGroupInput.add(typeExtraWorkInput);
        typeExtraWorkInput.setText("Extra work");

        interruptibleGroupInput.add(interruptibleYesInput);
        interruptibleYesInput.setSelected(true);
        interruptibleYesInput.setText("Yes");

        interruptibleLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        interruptibleLabel.setText("Interruptible *");

        interruptibleGroupInput.add(interruptibleNoInput);
        interruptibleNoInput.setText("No");

        mandatoryLabel.setText("Fields with the symbol * are required");

        materialsInput.setColumns(20);
        materialsInput.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        materialsInput.setRows(4);
        notesScrollInput1.setViewportView(materialsInput);

        materialsLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        materialsLabel.setText("Materials");

        notesInput.setColumns(20);
        notesInput.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        notesInput.setLineWrap(true);
        notesInput.setRows(4);
        notesInput.setWrapStyleWord(true);
        notesScrollInput.setViewportView(notesInput);

        notesLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        notesLabel.setText("Workspace notes");

        createBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        createBtn.setText("Create");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weekLabel)
                            .addComponent(weekInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mandatoryLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(interruptibleYesInput)
                                .addGap(18, 18, 18)
                                .addComponent(interruptibleNoInput))
                            .addComponent(interruptibleLabel)
                            .addComponent(typeLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(typeInputScheduled)
                                .addGap(18, 18, 18)
                                .addComponent(typeUnscheduledInput)
                                .addGap(18, 18, 18)
                                .addComponent(typeExtraWorkInput))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(typologyInput, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idInput, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(areaLabel)
                                        .addComponent(typologyLabel)
                                        .addComponent(estimatedTimeLabel)
                                        .addComponent(BranchOfficeLabel)
                                        .addComponent(idLabel))
                                    .addGap(81, 81, 81))
                                .addComponent(estimatedTimeInput, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(areaInput, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(branchOfficeInput, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(materialsLabel)
                            .addComponent(notesLabel)
                            .addComponent(descriptionLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(notesScrollInput1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(notesScrollInput, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(descriptionScrollInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(221, 221, 221)
                        .addComponent(createActivityTitleLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(createActivityTitleLabel))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addGap(4, 4, 4)
                        .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BranchOfficeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(branchOfficeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(areaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(typologyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typologyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(estimatedTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estimatedTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(descriptionLabel)
                        .addGap(4, 4, 4)
                        .addComponent(descriptionScrollInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(notesLabel)
                        .addGap(8, 8, 8)
                        .addComponent(notesScrollInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(materialsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notesScrollInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(typeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeInputScheduled)
                    .addComponent(typeUnscheduledInput)
                    .addComponent(typeExtraWorkInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(interruptibleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interruptibleYesInput)
                    .addComponent(interruptibleNoInput))
                .addGap(18, 18, 18)
                .addComponent(mandatoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(createBtn)
                .addGap(47, 47, 47))
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
    private javax.swing.ButtonGroup interruptibleGroupInput;
    private javax.swing.JLabel interruptibleLabel;
    private javax.swing.JRadioButton interruptibleNoInput;
    private javax.swing.JRadioButton interruptibleYesInput;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel mandatoryLabel;
    private javax.swing.JTextArea materialsInput;
    private javax.swing.JLabel materialsLabel;
    private javax.swing.JTextArea notesInput;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JScrollPane notesScrollInput;
    private javax.swing.JScrollPane notesScrollInput1;
    private javax.swing.JRadioButton typeExtraWorkInput;
    private javax.swing.ButtonGroup typeGroupInput;
    private javax.swing.JRadioButton typeInputScheduled;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JRadioButton typeUnscheduledInput;
    private javax.swing.JComboBox<String> typologyInput;
    private javax.swing.JLabel typologyLabel;
    private javax.swing.JTextField weekInput;
    private javax.swing.JLabel weekLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * The input of materials is added only as a mock because the 
     * implementation of System Administrator part that manage the materials
     * in the system has not yet implemented.
    */
    
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
        return null;
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

    public void addCreateButtonListener(ActionListener al) {
        createBtn.addActionListener(al);
    }
    
    public void addBackButtonListener(ActionListener al){
        backBtn.addActionListener(al);
    }
    
    public void addTypeButtonListener(ActionListener al){
        typeExtraWorkInput.addActionListener(al);
        typeInputScheduled.addActionListener(al);
        typeUnscheduledInput.addActionListener(al);
    }
    
    public void setEnableWeek(boolean enabled){
        weekInput.setEnabled(enabled);
    }
    
    public void addTypologyInputListener(ActionListener al){
        typologyInput.addActionListener(al);
    }
}
