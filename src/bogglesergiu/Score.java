/*
 * File Name: Score
 * Programmer: Sergiu Pocol
 * Date: August 18th, 2018
 * Description: Display and record the final score, highscore, and past scores
 */
package bogglesergiu;

import java.util.*;
//required for creating ArrayLists
import java.io.*;
//will allow the program to read and write to files 

/**
 *
 * @author kids
 */
public class Score extends javax.swing.JFrame {

    static int intScore;
    //the Scoer class's Score variable
    
    ArrayList<Integer> intScoreList = new ArrayList <Integer>();
    //variable to score the score achieved in the previous JFrame
    /**
     * Creates new form Score
     * @param intScore as an integer >= 0
     */
    public Score(int intScore) {//CONSTRUCTOR IS MODIFIED TO TAKE THE SCORE
        //EARNED IN THE GAME AS A PARAMETER
        
        super("BOGGLE!");
        //sets the window title
        
        initComponents();
        
        this.intScore = intScore;
        //sets the score achieved in the game to the class Score's intScore
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //THE FOLLOWING CODE WILL KEEP TRACK OF THE USER'S PAST SCORES
        
        
        
        
        
        
        //READ ALL SCORES
        BufferedReader br = null;
        //declares an instance of BufferedReader
        //required for catch block
        String strPastScores = "";
        //accumulator
        
        String strContent;
        //will store each line's content
        
        try {
            br = new BufferedReader(new FileReader("SCORES.txt"));
            //locates the file SCORES.txt and opens it for reading

            while ((strContent = br.readLine()) != null ){//reads each line until "null" character is seen
                
                strPastScores += strContent;
                //stores each past score
                
            }
            
            
        } catch (IOException e) {//ensures anything past the end of the file isn't read
            e.printStackTrace();
        } finally {
            try {
                br.close(); //closes the file
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //WRITES CURRENT SCORE ON THE SCORES.txt FILE
        try {
            OutputStream scoreFile = new FileOutputStream("SCORES.txt");
            OutputStream writer = new BufferedOutputStream(scoreFile);
            OutputStreamWriter out = new OutputStreamWriter(writer);
            //These objects are required to write into the text file

            out.write(strPastScores + this.intScore + ",");
            
            out.flush();  // FLUSH IS REQUIRED
            out.close();
            
        }//THE FOLLOWING HANDLES ERROR CHECKING
        catch (UnsupportedEncodingException e) {
          System.out.println("This VM does not support the Latin-1 character set.");
        }
        catch (IOException e) {
          System.out.println(e.getMessage());
        }
        
        String strCurrentScores = "";
        try {
            br = new BufferedReader(new FileReader("SCORES.txt"));
            //locates the file SCORES.txt and opens it for reading

            while ((strContent = br.readLine()) != null ){//reads each line until "null" character is seen
                
                strCurrentScores += strContent;
                //stores each past score
                
            }
            
            
        } catch (IOException e) {//ensures anything past the end of the file isn't read
            e.printStackTrace();
        } finally {
            try {
                br.close(); //closes the file
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        //strCurrentScores NOW HOLDS ALL THE PAST SCORES OF THIS USER!!!
        //comma-separated scores
        
        
        //THE FOLLOWING CODE WILL CREATE AN ARRAY OF INTEGERS THAT WILL STORE THE SCORES
        String [] strScoresArray = strCurrentScores.split(",");
        String strScoresOutput = "";
        int [] intScoresArray = new int [strScoresArray.length];
        for (int i = 0; i < intScoresArray.length; i++) {
            intScoresArray[i] = Integer.parseInt(strScoresArray[i]);
            if (i != (intScoresArray.length-1) && i != (intScoresArray.length-2)) strScoresOutput += strScoresArray[i] + ", ";
            if (i == (intScoresArray.length-2) && intScoresArray.length != 2) strScoresOutput += "and " + strScoresArray[i] + "\n";
            if (i == (intScoresArray.length-2) && intScoresArray.length == 2) strScoresOutput += " " + strScoresArray[i] + "\n";
        }
        
        
        
        //SORT THE ARRAY USING RECURSION
        QuickSort(intScoresArray, 0, intScoresArray.length - 1);
        
        //SINCE THERE ARE NO PAST SCORES IN THE FIRST GAME
        String strOptional = "\nYour past score(s): " + strScoresOutput;
        
        if (intScoresArray.length == 1) strOptional = "";
        
        this.txtScore.setText("Game over!\n\nYour score is: " + this.intScore + "\n" + strOptional + "\nHighscore: " + intScoresArray[intScoresArray.length-1]);
        //displays the score information
        
        
        
        
        
        
    }

    /**
     * 
     * @param intArr an array of integers
     * @param intP an index of intArr
     * @param intR an index of intArr
     * will sort the array
     */
    public void QuickSort(int [] intArr, int intP, int intR) {
        
        if (intP < intR) { // the lack of an else block prevents infinite recursion
            
            int intJ = partition(intArr, intP, intR);
            //will store the index of the previous pivot
            
            //Recursive calls on the two new divisions
            QuickSort(intArr, intJ + 1, intR);
            QuickSort(intArr, intP, intJ - 1);
        }
        
    }
    
    /**
     * 
     * @param intArr an array of integers
     * @param intP an index of intArr
     * @param intR an index of intArr
     * @return the index of the pivot
     */
    public int partition(int [] intArr, int intP, int intR) {
        
        int i = intP;
        int j = intR+1;
        //i is the pivot coordinate and j is out of bounds but BOTH will be decremented/incrememnted immediately
        
        int pivot = intArr[intP];
        //will store the value of the pivot
        
        //locates the position of where the pivot is in the sorted array
        //swaps unequal pairs in the wrong partition
        
        do {
            
            do {
                i++;
            } while (intArr[i] < pivot && i != intArr.length - 1);
            
            do {
                j--;
            } while (intArr[j] > pivot);
            
            if (i <= j) {
                swap(intArr, i, j);
            }
        } while (i < j);
        
        swap(intArr, intP, j);
        //the pivot is now at its FINAL position in the array
        
        return j;
        //index of pivot
    }
    
    /**
     * 
     * @param intArr an array of integers
     * @param i an index of intArr
     * @param j an index of intArr
     */
    public void swap(int [] intArr, int i, int j) {
        //SWAPS THE ELEMENTS
        int temp = intArr[j];
        intArr[j] = intArr[i];
        intArr[i] = temp;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtScore = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        btnPlayAgain = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        txtScore.setEditable(false);
        txtScore.setColumns(20);
        txtScore.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtScore.setLineWrap(true);
        txtScore.setRows(5);
        txtScore.setWrapStyleWord(true);
        txtScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtScore);

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 48)); // NOI18N
        lblTitle.setText("Time's up!!");

        btnPlayAgain.setBackground(new java.awt.Color(255, 255, 255));
        btnPlayAgain.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        btnPlayAgain.setText("Play Again");
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPlayAgain)
                .addGap(176, 176, 176))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPlayAgain)
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        
        Boggle newGame = new Boggle();
        //creates an instance of the game JFrame, skips the menu
        
        newGame.setVisible(true);
        //display the new game
        
    }//GEN-LAST:event_btnPlayAgainActionPerformed

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
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Score(intScore).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtScore;
    // End of variables declaration//GEN-END:variables
}
