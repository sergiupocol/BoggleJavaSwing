/*
 * FileName: Menu
 * Programmer: Sergiu Pocol
 * Date: August 18th, 2018
 * Description: to display instructions for using the boggle program
 */
package bogglesergiu;

/**
 *
 * @author kids
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        
        super("BOGGLE!");
        //sets the window title
        
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

        pnlBackground = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        lblTitle4 = new javax.swing.JLabel();
        lblTitle5 = new javax.swing.JLabel();
        lblTitle6 = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        scrInfo = new javax.swing.JScrollPane();
        txtInformation = new javax.swing.JTextArea();
        scrInfo1 = new javax.swing.JScrollPane();
        txtInformation1 = new javax.swing.JTextArea();
        scrInfo2 = new javax.swing.JScrollPane();
        txtInformation2 = new javax.swing.JTextArea();
        lblExample = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(153, 255, 255));

        lblTitle1.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("B");
        lblTitle1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle1.setOpaque(true);

        lblTitle2.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("O");
        lblTitle2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle2.setOpaque(true);

        lblTitle3.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle3.setText("G");
        lblTitle3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle3.setOpaque(true);

        lblTitle4.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle4.setText("G");
        lblTitle4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle4.setOpaque(true);

        lblTitle5.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle5.setText("L");
        lblTitle5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle5.setOpaque(true);

        lblTitle6.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle6.setText("E");
        lblTitle6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle6.setOpaque(true);

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        scrInfo.setBorder(null);

        txtInformation.setEditable(false);
        txtInformation.setColumns(20);
        txtInformation.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtInformation.setLineWrap(true);
        txtInformation.setRows(5);
        txtInformation.setText("Hello and welcome to the world's best word game:  Boggle, programmed by Sergiu Pocol.\n\nYou will have ONE MINUTE to create as many words as possible from a grid of letters. These conditions must be met:\n\n1. Each pair of adjacent letters in the word must also be adjacent on the grid.\n2. The word must be an English word of at least three letters.\n3. The word must not have been enterred before. ");
        txtInformation.setWrapStyleWord(true);
        txtInformation.setBorder(null);
        txtInformation.setMargin(new java.awt.Insets(6, 6, 6, 2));
        scrInfo.setViewportView(txtInformation);

        scrInfo1.setBorder(null);

        txtInformation1.setEditable(false);
        txtInformation1.setColumns(20);
        txtInformation1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtInformation1.setLineWrap(true);
        txtInformation1.setRows(5);
        txtInformation1.setText("For example, FAME is a valid word and would increase your score.\n\nHowever, RIP is not because you jumped tiles from the I to the P.");
        txtInformation1.setWrapStyleWord(true);
        txtInformation1.setBorder(null);
        txtInformation1.setMargin(new java.awt.Insets(6, 6, 6, 2));
        scrInfo1.setViewportView(txtInformation1);

        scrInfo2.setBorder(null);

        txtInformation2.setEditable(false);
        txtInformation2.setColumns(20);
        txtInformation2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtInformation2.setLineWrap(true);
        txtInformation2.setRows(5);
        txtInformation2.setText("If you're stuck, don't worry! Press \"Shuffle\" to rearrange the letters on the grid or \"Clear\" to enter a different word.\nTo begin, press \"Play\"");
        txtInformation2.setWrapStyleWord(true);
        txtInformation2.setBorder(null);
        txtInformation2.setMargin(new java.awt.Insets(6, 6, 6, 2));
        scrInfo2.setViewportView(txtInformation2);

        lblExample.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bogglesergiu/example.png"))); // NOI18N
        lblExample.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lblTimer.setBackground(new java.awt.Color(255, 255, 255));
        lblTimer.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("NOTE: ONCE PLAY IS PRESSED, YOU WILL HAVE ONE MINUTE TO PLAY!");

        btnPlay.setBackground(new java.awt.Color(204, 204, 204));
        btnPlay.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContentLayout.createSequentialGroup()
                        .addComponent(scrInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlContentLayout.createSequentialGroup()
                        .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContentLayout.createSequentialGroup()
                                .addComponent(scrInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addComponent(scrInfo2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblExample)
                        .addGap(80, 80, 80))))
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(btnPlay)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(scrInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblExample)
                    .addGroup(pnlContentLayout.createSequentialGroup()
                        .addComponent(scrInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnPlay)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(lblTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle2)
                    .addComponent(lblTitle3)
                    .addComponent(lblTitle4)
                    .addComponent(lblTitle6)
                    .addComponent(lblTitle1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle5)
                .addGap(21, 21, 21)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        
        Boggle game = new Boggle();
        //creates an instance of the Boggle JFrame class
        
        game.setVisible(true);
        //will display the game when "Play" is pressed
        
        btnPlay.setEnabled(false);
        //prevents the user from playing more than one game at the same time
        
    }//GEN-LAST:event_btnPlayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        
        
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel lblExample;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle5;
    private javax.swing.JLabel lblTitle6;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JScrollPane scrInfo;
    private javax.swing.JScrollPane scrInfo1;
    private javax.swing.JScrollPane scrInfo2;
    private javax.swing.JTextArea txtInformation;
    private javax.swing.JTextArea txtInformation1;
    private javax.swing.JTextArea txtInformation2;
    // End of variables declaration//GEN-END:variables
}
