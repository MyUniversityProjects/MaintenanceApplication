package root.screens.modifyselectedactivity;


import java.awt.EventQueue;
import java.awt.event.ActionListener;
import root.Navigable;
import root.Screen;
import root.entities.Activity;

public class ModifySelectedActivityView extends Screen {

    ModifySelectedActivityModel model;
    /**
     * Creates new form ModifySelectedActivityView according to the activity type and data
     * @param nav navigator used to switch between screens
     * @param model used to show the activity informations
     */
    public ModifySelectedActivityView(Navigable nav, ModifySelectedActivityModel model) {
        super(nav);
        this.model = model == null ? new ModifySelectedActivityModel(new Activity(0, "", "", "", "", 0, false, 0, "", null),null) : model;
        initComponents();
        if (model == null) {
            EventQueue.invokeLater(() -> {
                super.showErrorMsg("Activity not found", "Unable to fetch activity");
                nav.goHome();
            });
        } else {
            idInput.setText(Integer.toString(model.getId()));
            idInput.setEditable(false);
            branchOfficeInput.setText(model.getBranchOffice());
            branchOfficeInput.setEditable(true);
            areaInput.setText(model.getArea());
            areaInput.setEditable(true);
            typologyInput.setText(model.getTypology());
            typologyInput.setEditable(true);
            estimatedTimeInput.setText(Integer.toString(model.getTime()));
            estimatedTimeInput.setEditable(true);
            weekInput.setText(Integer.toString(model.getWeek()));
            weekInput.setEditable(false);
            descriptionInput.setText(model.getDescription());
            descriptionInput.setEditable(true);
            notesInput.setText(model.getNotes());
            notesInput.setEditable(true);
            materialsInput.setEditable(false);
            if(null != model.getType())switch (model.getType()) {
                case PLANNED:
                    typeInput.setText("Scheduled");
                    break;
                case UNPLANNED:
                    typeInput.setText("Unscheduled");
                    break;
                case EXTRA:
                    typeInput.setText("Extra Work");
                    break;
                default:
                    break;
            }
            typeInput.setEditable(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        interruptibleGroupInput = new javax.swing.ButtonGroup();
        typeGroupInput = new javax.swing.ButtonGroup();
        idLabel = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        BranchOfficeLabel = new javax.swing.JLabel();
        branchOfficeInput = new javax.swing.JTextField();
        areaLabel = new javax.swing.JLabel();
        areaInput = new javax.swing.JTextField();
        typologyLabel = new javax.swing.JLabel();
        typologyInput = new javax.swing.JTextField();
        estimatedTimeLabel = new javax.swing.JLabel();
        estimatedTimeInput = new javax.swing.JTextField();
        weekLabel = new javax.swing.JLabel();
        weekInput = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        createActivityTitleLabel = new javax.swing.JLabel();
        homeBtn = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        descriptionScrollInput = new javax.swing.JScrollPane();
        descriptionInput = new javax.swing.JTextArea();
        notesLabel = new javax.swing.JLabel();
        notesScrollInput = new javax.swing.JScrollPane();
        notesInput = new javax.swing.JTextArea();
        materialsLabel = new javax.swing.JLabel();
        notesScrollInput1 = new javax.swing.JScrollPane();
        materialsInput = new javax.swing.JTextArea();
        typeLabel = new javax.swing.JLabel();
        typeInput = new javax.swing.JTextField();
        interruptibleLabel = new javax.swing.JLabel();
        interruptibleYesInput = new javax.swing.JRadioButton();
        interruptibleNoInput = new javax.swing.JRadioButton();
        mandatoryLabel = new javax.swing.JLabel();
        modifyBtn = new javax.swing.JButton();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(1);
        jScrollPane3.setViewportView(jTextArea3);

        setAutoscrolls(true);
        setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idLabel.setText("ID *");

        BranchOfficeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BranchOfficeLabel.setText("Branch office ");

        areaLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        areaLabel.setText("Area ");

        typologyLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typologyLabel.setText("Typology ");

        estimatedTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        estimatedTimeLabel.setText("Estimated intervantion time (minutes) ");

        weekLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        weekLabel.setText("Week [1, 52] *");

        backBtn.setText("back");

        createActivityTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        createActivityTitleLabel.setText("MODIFY ACTIVITY");

        homeBtn.setText("home");

        descriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descriptionLabel.setText("Description ");

        descriptionInput.setColumns(20);
        descriptionInput.setRows(4);
        descriptionScrollInput.setViewportView(descriptionInput);

        notesLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        notesLabel.setText("Workspace notes [Optional]");

        notesInput.setColumns(20);
        notesInput.setRows(4);
        notesScrollInput.setViewportView(notesInput);

        materialsLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        materialsLabel.setText("Materials");

        materialsInput.setColumns(20);
        materialsInput.setRows(4);
        notesScrollInput1.setViewportView(materialsInput);

        typeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typeLabel.setText("Type*");

        interruptibleLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        interruptibleLabel.setText("Interruptible ");

        interruptibleGroupInput.add(interruptibleYesInput);
        interruptibleYesInput.setSelected(true);
        interruptibleYesInput.setText("Yes");

        interruptibleGroupInput.add(interruptibleNoInput);
        interruptibleNoInput.setText("No");

        mandatoryLabel.setText("Fields with the symbol * cannot be edited");

        modifyBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(areaLabel)
                            .addComponent(BranchOfficeLabel)
                            .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(branchOfficeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typologyLabel)
                            .addComponent(estimatedTimeLabel)
                            .addComponent(weekLabel)
                            .addComponent(areaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typologyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estimatedTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weekInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mandatoryLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(interruptibleYesInput)
                                .addGap(18, 18, 18)
                                .addComponent(interruptibleNoInput))
                            .addComponent(interruptibleLabel)
                            .addComponent(typeLabel)
                            .addComponent(typeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLabel)
                    .addComponent(notesScrollInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(notesScrollInput, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionScrollInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(materialsLabel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(notesLabel, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(modifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(createActivityTitleLabel)
                .addGap(244, 244, 244)
                .addComponent(homeBtn)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createActivityTitleLabel)
                    .addComponent(homeBtn)
                    .addComponent(backBtn))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BranchOfficeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(branchOfficeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typologyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typologyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estimatedTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estimatedTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weekLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weekInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(notesScrollInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeLabel)
                .addGap(8, 8, 8)
                .addComponent(typeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(interruptibleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interruptibleYesInput)
                    .addComponent(interruptibleNoInput))
                .addGap(18, 18, 18)
                .addComponent(mandatoryLabel)
                .addGap(57, 57, 57)
                .addComponent(modifyBtn)
                .addContainerGap(66, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel mandatoryLabel;
    private javax.swing.JTextArea materialsInput;
    private javax.swing.JLabel materialsLabel;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JTextArea notesInput;
    private javax.swing.JLabel notesLabel;
    private javax.swing.JScrollPane notesScrollInput;
    private javax.swing.JScrollPane notesScrollInput1;
    private javax.swing.ButtonGroup typeGroupInput;
    private javax.swing.JTextField typeInput;
    private javax.swing.JLabel typeLabel;
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

    public void addModifyButtonListener(ActionListener al) {
        modifyBtn.addActionListener(al);
    }
    
    public void addBackButtonListener(ActionListener al){
        backBtn.addActionListener(al);
    }
    
    public void addHomeButtonListener(ActionListener al){
        homeBtn.addActionListener(al);
    }
}
