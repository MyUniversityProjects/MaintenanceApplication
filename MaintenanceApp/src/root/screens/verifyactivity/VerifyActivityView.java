package root.screens.verifyactivity;

import java.awt.event.ActionListener;
import root.Navigator;
import root.Screen;


public class VerifyActivityView extends Screen {
    final VerifyActivityModel model;
    
    /**
     * Creates new form VerifyActivityView
     * @param nav
     * @param model
     */
    public VerifyActivityView(Navigator nav, VerifyActivityModel model) {
        super(nav);
        this.model = model;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idValueLabel = new javax.swing.JLabel();
        noteLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteTextArea = new javax.swing.JTextArea();
        areaLabel = new javax.swing.JLabel();
        areaValueLabel = new javax.swing.JLabel();
        typologyLabel = new javax.swing.JLabel();
        typologyValueLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timeValueLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        skillList = new javax.swing.JList<>();
        weekLabel = new javax.swing.JLabel();
        weekValueLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        forwardBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        descTextArea = new javax.swing.JTextArea();
        smpBtn = new javax.swing.JButton();
        smpLabel1 = new javax.swing.JLabel();
        smpLabel2 = new javax.swing.JLabel();

        backBtn.setText("back");

        homeBtn.setText("home");

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setText("Verify Activity");

        idLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        idLabel.setForeground(new java.awt.Color(102, 102, 102));
        idLabel.setText("ID");

        idValueLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idValueLabel.setText("AAAABBBBCCCCDDDD");

        noteLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        noteLabel.setForeground(new java.awt.Color(102, 102, 102));
        noteLabel.setText("Workspace note");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        noteTextArea.setColumns(20);
        noteTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        noteTextArea.setLineWrap(true);
        noteTextArea.setRows(5);
        noteTextArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam varius metus sit amet nisi volutpat mattis. Nulla gravida purus in velit feugiat eleifend. Donec finibus at lorem accumsan cursus. Vestibulum posuere, tellus id posuere iaculis, justo massa ullamcorper sem, in semper elit nunc et dolor.");
        noteTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(noteTextArea);

        areaLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        areaLabel.setForeground(new java.awt.Color(102, 102, 102));
        areaLabel.setText("Area");

        areaValueLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        areaValueLabel.setText("Ufficio");

        typologyLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        typologyLabel.setForeground(new java.awt.Color(102, 102, 102));
        typologyLabel.setText("Typology");

        typologyValueLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typologyValueLabel.setText("Hydraulic");

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(102, 102, 102));
        timeLabel.setText("Estimated intevetion time");

        timeValueLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        timeValueLabel.setText("2h30m");

        jScrollPane2.setBorder(null);
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Skills needed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        skillList.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        skillList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        skillList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "    • Skill 1", "    • Skill 2", "    • Skill 3", "    • Skill 4", "    • Skill 5", "    • Skill 6", "    • Skill 7", "    • Skill 8", "    • Skill 9", "    • Skill 10" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(skillList);

        weekLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        weekLabel.setForeground(new java.awt.Color(102, 102, 102));
        weekLabel.setText("Week number");

        weekValueLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        weekValueLabel.setText("23");

        descLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        descLabel.setForeground(new java.awt.Color(102, 102, 102));
        descLabel.setText("Intervention description");

        forwardBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        forwardBtn.setText("FORWARD");

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descTextArea.setEditable(false);
        descTextArea.setColumns(20);
        descTextArea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descTextArea.setLineWrap(true);
        descTextArea.setRows(5);
        descTextArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam varius metus sit amet nisi volutpat mattis. Nulla gravida purus in velit feugiat eleifend. Donec finibus at lorem accumsan cursus. Vestibulum posuere, tellus id posuere iaculis, justo massa ullamcorper sem, in semper elit nunc et dolor.");
        descTextArea.setWrapStyleWord(true);
        jScrollPane4.setViewportView(descTextArea);

        smpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/download-solid.png"))); // NOI18N

        smpLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        smpLabel1.setForeground(new java.awt.Color(51, 51, 51));
        smpLabel1.setText("Standard Maintenance");

        smpLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        smpLabel2.setForeground(new java.awt.Color(51, 51, 51));
        smpLabel2.setText("Procedure File");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleLabel)
                        .addGap(112, 112, 112)
                        .addComponent(homeBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noteLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descLabel)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idValueLabel)
                                    .addComponent(idLabel)
                                    .addComponent(areaLabel)
                                    .addComponent(areaValueLabel)
                                    .addComponent(typologyLabel)
                                    .addComponent(weekLabel)
                                    .addComponent(weekValueLabel))
                                .addGap(136, 136, 136))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typologyValueLabel)
                                    .addComponent(timeLabel))
                                .addGap(109, 109, 109))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(timeValueLabel)
                                .addGap(218, 218, 218)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(smpLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(smpLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(smpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(forwardBtn)
                .addGap(203, 203, 203))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(backBtn)
                    .addComponent(homeBtn))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idValueLabel)
                        .addGap(13, 13, 13)
                        .addComponent(weekLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weekValueLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(areaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaValueLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(typologyLabel))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(typologyValueLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeValueLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(smpLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(smpLabel2))
                            .addComponent(smpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(noteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(descLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(forwardBtn)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void addBackBtnListener(ActionListener al) {
        backBtn.addActionListener(al);
    }
    
    public void addHomeBtnListener(ActionListener al) {
        homeBtn.addActionListener(al);
    }
    
    public void addForwardBtnListener(ActionListener al) {
        forwardBtn.addActionListener(al);
    }
    
    public void addSmpBtnListener(ActionListener al) {
        smpBtn.addActionListener(al);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaLabel;
    private javax.swing.JLabel areaValueLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JButton forwardBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idValueLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JTextArea noteTextArea;
    private javax.swing.JList<String> skillList;
    private javax.swing.JButton smpBtn;
    private javax.swing.JLabel smpLabel1;
    private javax.swing.JLabel smpLabel2;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeValueLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel typologyLabel;
    private javax.swing.JLabel typologyValueLabel;
    private javax.swing.JLabel weekLabel;
    private javax.swing.JLabel weekValueLabel;
    // End of variables declaration//GEN-END:variables
}
