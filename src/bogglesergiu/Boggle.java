/*
 * File Name: Boggle
 * Programmer: Sergiu Pocol
 * Date: August 18th, 2018
 * Description: allows the user to play a timed game of boggle with features like shuffle and score display
 */
package bogglesergiu;


import java.io.*;
//required for reading and writing to text files

import java.util.*;
//required to create a timer object and arraylists

/**
 *
 * @author kids
 */
public class Boggle extends javax.swing.JFrame {

    /**
     * Creates new form Boggle
     */
    
    
    static ArrayList<String> strBoggleWords = new ArrayList<String>();
    
    
    
    //THE FOLLOWING WILL SELECT THE LETTERS FOR USE IN AN INSTANCE OF THE BOGGLE CLASS
    String [] strLetters = new String[16];
    //an array to hold the 16 characters that will be displayed
    //String was chosen over char because Q and U are grouped
        
    int intRanNum;
    String strLetter;
    //allocates a memory location for a random number and random letter
    String strAlphabetBiased = "ABCDEFGHIJKLMNOPQRSTUVWXYZAEIOU";
    //string stores letters with lots of vowels to make game easier
        
    String strAttempt = "";
    //this will store the user's attempted entry
    
    ArrayList<String> strEntered = new ArrayList<String>();
    //this ArrayList will store words that were already entered and valid
    ArrayList<int []> coordinatesPressed = new ArrayList<int[]>();
    //will store the sequence of coordinates pressed (for example, btn00 is at coordinate (0,0))
    
    int intScore = 0;
    //stores the score of the player
    
    
    
    public Boggle() {
        super("BOGGLE!");
        //sets the window title
        
        
        initComponents();
        
        
        
        /*
         * The following code will store acceptable english words
         * in a string called strBoggleWords
         */
        
        
        BufferedReader br = null;
        //creates a buffered reader object that will be initialized 
        
        
        try {
            br = new BufferedReader(new FileReader("WORDSSS.txt"));
            //locates the file boggleWords.txt and opens it for reading
            
            
            //will serve as an accumlator and store every word space seperated
            
            String strContent;
            //will store each line's content
            
            while ((strContent = br.readLine()) != null ){//reads each line until "null" character is seen
                
                strBoggleWords.add(strContent.toUpperCase());
                //add each word to the ArrayList
                
                
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
        
        
        //ACCEPTABLE WORDS IS SORTED ALPHABETICALLY
        Collections.sort(strBoggleWords);

        
        //SET TEXT OF BUTTONS
        for (int i = 0; i < 16; i++) {//for each element in strLetters
            
            intRanNum = (int)Math.floor(Math.random()*strAlphabetBiased.length());
            //will generate a random number between 65 and 90 (ASCII for capital A to capital Z)
            
            strLetter = strAlphabetBiased.charAt(intRanNum) + "";
            //converts the random number to a random letter
            
            if (strLetter.equals("Q")) strLetter = "Qu";
            //in Boggle Q does not exist alone as a tile
            
            strLetters[i] = strLetter;
            //sets each element to a random letter
        }
        
        
        //WIL SET THE TEXT OF THE BUTTONS
        javax.swing.JButton [] btnLetters = {btn00, btn01, btn02, btn03, btn10, btn11, btn12, btn13, btn20, btn21, btn22, btn23, btn30, btn31, btn32, btn33};
        //buttons is an array that will store all the buttons in the grid
        
        for (int i = 0; i < 16; i++) {//for each button/letter...

            (btnLetters[i]).setText(strLetters[i]);
            //set the text of the button to the letter
                
 
        }
        
        lblScore.setText("Score: " + intScore);
        //score display
        
        
        
        
        
        
        
        
        /*
         * The following code will display the final Score JFrame after two minutes have passed
         */
        
        Timer gameTimer = new Timer();
        //creates a timer object for use in delaying the execution of code
        
        gameTimer.schedule(new TimerTask() {
            //this method contains the code that is to be executed in two minutes
            //of the instantiation of the Boggle class
            
            @Override
            public void run() {
                
                Score gameOver = new Score(intScore);
                //creates an instance of the game over screen
                
                gameOver.setVisible(true);
                //will display the instance
                
                
                //THE FOLLOWING DISABLES ALL BUTTONS
                javax.swing.JButton [] btnLetters = {btnClear, btnShuffle, btnSubmitWord, btn00, btn01, btn02, btn03, btn10, btn11, btn12, btn13, btn20, btn21, btn22, btn23, btn30, btn31, btn32, btn33};
                //buttons is an array that will store all the buttons in the grid
        
                for (javax.swing.JButton button: btnLetters) {
                    button.setEnabled(false);
                }
                
                
            }
            
        }, 60000);//the second parameter of the schedule() method is the time of delay
        
        
        
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
        btn00 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn30 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        btn02 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn03 = new javax.swing.JButton();
        btnShuffle = new javax.swing.JButton();
        lblAttempt = new javax.swing.JLabel();
        btnSubmitWord = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();
        scrWords = new javax.swing.JScrollPane();
        txtWords = new javax.swing.JTextArea();
        lblTableTitle = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle5 = new javax.swing.JLabel();
        lblTitle4 = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle6 = new javax.swing.JLabel();
        lblReminder = new javax.swing.JLabel();
        lblReminder1 = new javax.swing.JLabel();
        lblReminder2 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 800));

        btn00.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn00.setText("A");
        btn00.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn00.setPreferredSize(new java.awt.Dimension(70, 70));
        btn00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn00ActionPerformed(evt);
            }
        });

        btn10.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn10.setText("A");
        btn10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn10.setPreferredSize(new java.awt.Dimension(70, 70));
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn20.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn20.setText("A");
        btn20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn20.setPreferredSize(new java.awt.Dimension(70, 70));
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });

        btn30.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn30.setText("A");
        btn30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn30.setPreferredSize(new java.awt.Dimension(70, 70));
        btn30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn30ActionPerformed(evt);
            }
        });

        btn11.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn11.setText("A");
        btn11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn11.setPreferredSize(new java.awt.Dimension(70, 70));
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        btn31.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn31.setText("A");
        btn31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn31.setPreferredSize(new java.awt.Dimension(70, 70));
        btn31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn31ActionPerformed(evt);
            }
        });

        btn21.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn21.setText("A");
        btn21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn21.setPreferredSize(new java.awt.Dimension(70, 70));
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });

        btn01.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn01.setText("A");
        btn01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn01.setPreferredSize(new java.awt.Dimension(70, 70));
        btn01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn01ActionPerformed(evt);
            }
        });

        btn02.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn02.setText("A");
        btn02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn02.setPreferredSize(new java.awt.Dimension(70, 70));
        btn02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn02ActionPerformed(evt);
            }
        });

        btn12.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn12.setText("A");
        btn12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn12.setPreferredSize(new java.awt.Dimension(70, 70));
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });

        btn22.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn22.setText("A");
        btn22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn22.setPreferredSize(new java.awt.Dimension(70, 70));
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });

        btn32.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn32.setText("A");
        btn32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn32.setPreferredSize(new java.awt.Dimension(70, 70));
        btn32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn32ActionPerformed(evt);
            }
        });

        btn13.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn13.setText("A");
        btn13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn13.setPreferredSize(new java.awt.Dimension(70, 70));
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });

        btn33.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn33.setText("A");
        btn33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn33.setPreferredSize(new java.awt.Dimension(70, 70));
        btn33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn33ActionPerformed(evt);
            }
        });

        btn23.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn23.setText("A");
        btn23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn23.setPreferredSize(new java.awt.Dimension(70, 70));
        btn23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn23ActionPerformed(evt);
            }
        });

        btn03.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btn03.setText("A");
        btn03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btn03.setPreferredSize(new java.awt.Dimension(70, 70));
        btn03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn03ActionPerformed(evt);
            }
        });

        btnShuffle.setBackground(new java.awt.Color(255, 255, 255));
        btnShuffle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        btnShuffle.setText("Shuffle");
        btnShuffle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShuffleActionPerformed(evt);
            }
        });

        lblAttempt.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblAttempt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnSubmitWord.setBackground(new java.awt.Color(255, 255, 255));
        btnSubmitWord.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        btnSubmitWord.setText("Submit Word");
        btnSubmitWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitWordActionPerformed(evt);
            }
        });

        lblScore.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("score goes here");

        txtWords.setEditable(false);
        txtWords.setColumns(20);
        txtWords.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        txtWords.setRows(5);
        scrWords.setViewportView(txtWords);

        lblTableTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblTableTitle.setText("Word - Point(s) Earned");

        lblTitle1.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("B");
        lblTitle1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle1.setOpaque(true);

        lblTitle5.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle5.setText("L");
        lblTitle5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle5.setOpaque(true);

        lblTitle4.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle4.setText("G");
        lblTitle4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle4.setOpaque(true);

        lblTitle3.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle3.setText("G");
        lblTitle3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle3.setOpaque(true);

        lblTitle2.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("O");
        lblTitle2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle2.setOpaque(true);

        lblTitle6.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitle6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle6.setText("E");
        lblTitle6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        lblTitle6.setOpaque(true);

        lblReminder.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblReminder.setText("REMEMBER, the word must be an english word of at least three letters,");

        lblReminder1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblReminder1.setText("each pair of adjacent letters in the word must be adjacent on the grid,");

        lblReminder2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblReminder2.setText("and the word must not have been enterred before!");

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        btnClear.setText("Clear Word");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAttempt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSubmitWord)
                        .addGap(38, 38, 38)
                        .addComponent(btnShuffle)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblReminder)
                        .addGap(80, 80, 80))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReminder1)
                            .addComponent(lblReminder2))
                        .addGap(80, 80, 80))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTableTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(scrWords, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(52, Short.MAX_VALUE))))
            .addComponent(lblScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle2)
                    .addComponent(lblTitle3)
                    .addComponent(lblTitle4)
                    .addComponent(lblTitle6)
                    .addComponent(lblTitle1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle5)
                .addGap(18, 18, 18)
                .addComponent(lblReminder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReminder1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReminder2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTableTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrWords, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAttempt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShuffle)
                    .addComponent(btnSubmitWord)
                    .addComponent(btnClear))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnShuffleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShuffleActionPerformed
        //THIS BUTTON SHUFFLES THE LETTERS ON THE GRID
        
        
        javax.swing.JButton [] btnLetters = {btn00, btn01, btn02, btn03, btn10, btn11, btn12, btn13, btn20, btn21, btn22, btn23, btn30, btn31, btn32, btn33};
        //buttons is an array that will store all the buttons in the grid
        
        ArrayList <Integer> intIndices = new ArrayList<Integer>();
        //array list to store indices
        
        for (int i = 0; i < 16; i++) {
            
            intIndices.add(i);
            //will add all numbers 0 to 15 inclusive
        }
        
        for (javax.swing.JButton button : btnLetters) {//for every letter on the grid...
            
            int intRanIndex = (int) Math.floor(Math.random()* intIndices.size());
            //generate a random index
            
            button.setText(strLetters[intIndices.get(intRanIndex)]);
            //set the button's text to the character at the random index
            
            intIndices.remove(intRanIndex);
            //remove the character's index
        }
        
    }//GEN-LAST:event_btnShuffleActionPerformed

    private void btn00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn00ActionPerformed
        
        clicked(btn00, 0, 0);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
        
        
    }//GEN-LAST:event_btn00ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        clicked(btn10, 1, 0);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        clicked(btn20, 2, 0);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn30ActionPerformed
        clicked(btn30, 3, 0);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn30ActionPerformed

    private void btn01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn01ActionPerformed
        clicked(btn01, 0, 1);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn01ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        clicked(btn11, 1, 1);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        clicked(btn21, 2, 1);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn31ActionPerformed
        clicked(btn31, 3, 1);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn31ActionPerformed

    private void btn02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn02ActionPerformed
        clicked(btn02, 0, 2);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn02ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        clicked(btn12, 1, 2);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        clicked(btn22, 2, 2);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn22ActionPerformed

    private void btn32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn32ActionPerformed
        clicked(btn32, 3, 2);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn32ActionPerformed

    private void btn03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn03ActionPerformed
        clicked(btn03, 0, 3);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn03ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        clicked(btn13, 1, 3);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn23ActionPerformed
        clicked(btn23, 2, 3);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn23ActionPerformed

    private void btn33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn33ActionPerformed
        clicked(btn33, 3, 3);
        
        btnShuffle.setEnabled(false);
        //user cannot shuffle as they is enterring a word
    }//GEN-LAST:event_btn33ActionPerformed

    private void btnSubmitWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitWordActionPerformed
        
        //after a word is submitted, the user can shuffle
        btnShuffle.setEnabled(true);
        
        
        
        //if the word is valid then the success method is called, if not, failure is called
        if (isEnglish(strBoggleWords, strAttempt.toUpperCase(), 0, strBoggleWords.size()-1) && strAttempt.length() > 2 && !strEntered.contains(strAttempt) && isValid(coordinatesPressed)) {
            
            success();
            
        } else {
            
            failure();
            
        }
        
    }//GEN-LAST:event_btnSubmitWordActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        //THIS BUTTON WILL RESET THE ATTEMPT
        
        
        //after a word is cleared, the user can shuffle
        btnShuffle.setEnabled(true);
        
        coordinatesPressed.clear();
        //will clear the history of buttons pressed
        
        
        
        strAttempt = "";
        //reset attempt and it's display
        lblAttempt.setText("");
        
        //THE FOLLOWING ENABLES ALL BUTTONS AGAIN
        javax.swing.JButton [] btnLetters = {btn00, btn01, btn02, btn03, btn10, btn11, btn12, btn13, btn20, btn21, btn22, btn23, btn30, btn31, btn32, btn33};
        //buttons is an array that will store all the buttons in the grid
        
        for (javax.swing.JButton button: btnLetters) {
            button.setEnabled(true);
        }
        
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param intX as the x coordinate of the button on the grid, an integer
     * @param intY as the y coordinate of the button on the grid, an integer
     * @param button as a javax.swing.JButton
     * will store the text on the button and disable it
     */
    public void clicked(javax.swing.JButton button, int intX, int intY) {
        
        strAttempt += button.getText();
        //will store the letter that the button is displaying and append it to the
        //user's attempted entry
        button.setEnabled(false);
        //prevents user from reenterring the same character twice
        
        String strPrevious = lblAttempt.getText();
        lblAttempt.setText(strPrevious + " " + button.getText());
        //will allow the user to see the letter he just pressed
        
        int [] coordinate = new int[2];
        //will store button's position on grid
        coordinate[0] = intX;
        coordinate[1] = intY;
        
        coordinatesPressed.add(coordinate);
        //Now, coordinatesPressed is updated with the coordinate of the button
        //that was just pressed
    }
    

    
    
    //SEARCHING ALGORITHM (sorting is used in Score class)
    /**
     * 
     * @param strList an ArrayList of strings
     * @param strWord a string
     * @param intL an index of strList
     * @param intR an index of strList
     * @return true if strWord is in strList, false otherwise.
     */
    public boolean isEnglish(ArrayList<String> strList, String strWord, int intL, int intR) {
        
        //SEARCHING ALGORITHM IS BINARY SEARCH SINCE THE txt FILE CONTAINING
        
        
        if (intL > intR) return false;//will prevent infinite recursion
        
        int intMid = (intL + intR) / 2; //will store the midpoint for each recursion
        
        int intCompare = strWord.compareTo(strList.get(intMid));//compares ASCII of word at midpoint and 
        //word to search for
        
        if (intCompare == 0) return true;//if the two are identical
        if (intCompare < 0) {
            //if the word at the midpoint comes later in the dictionary...
            return isEnglish(strList, strWord, intL, intMid - 1);
        } else {
            return isEnglish(strList, strWord, intMid + 1, intR);
        }
    }
    /**
     * 
     * @param coordinates as an ArrayList of arrays of integers
     * @return true if every pair of adjacent coordinates are adjacent, false otherwise
     */
    public boolean isValid(ArrayList<int []> coordinates) {
        
        for (int i = 0; i < coordinates.size() - 1; i++) {//for every element except the last...
            //the change in row and column respectively, between an element and the one that follows it
            int intXDiff = Math.abs(coordinates.get(i)[1] - coordinates.get(i+1)[1]);
            int intYDiff = Math.abs(coordinates.get(i)[0] - coordinates.get(i+1)[0]);
            
            if (intXDiff > 1 || intYDiff > 1) return false;
            //if a letter follows another that is more than 1 row or column away,
            //the word is not valid
        }
        //if false hasn't been returned yet...
        return true;
    }
    
    /**
     * called if the user correctly entered a word
     */
    public void success() {
        
        strEntered.add(strAttempt);
        //the word that was entered must be recorded
        
        int intGain = 0;
        //will store the word's value
        
        //THE FOLLOWING SWITCH CASE STRUCTURE INCREMENTS THE SCORE ACCORDING TO WORD LENGTH
        int intNumLetters = strAttempt.length();
        //will store the number of characters in the word enterred
        
        switch (intNumLetters) {
            
            case 3:
            case 4:
                intScore++;
                intGain = 1;
                break;
            case 5:
                intScore += 2;
                intGain = 2;
                break;
            case 6:
                intScore += 3;
                intGain = 3;
                break;
            case 7:
                intScore += 4;
                intGain = 4;
                break;
            case 8:
            case 9:
            case 10:
            case 11:    
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                intScore += 11;
                intGain = 11;
                break;
            default:
                break;       
        }
        
        
        
        lblScore.setText("Score: " + intScore);
        //will update score display
        
        //Will update table of words already entered
        String strPast = txtWords.getText() + "";
        txtWords.setText(strPast + "\n" + strAttempt + " - " + intGain + "\n");
        
        coordinatesPressed.clear();
        //will clear the history of buttons pressed
        
        strAttempt = "";
        //reset attempt and it's display
        lblAttempt.setText("");
        
        //THE FOLLOWING ENABLES ALL BUTTONS AGAIN
        javax.swing.JButton [] btnLetters = {btn00, btn01, btn02, btn03, btn10, btn11, btn12, btn13, btn20, btn21, btn22, btn23, btn30, btn31, btn32, btn33};
        //buttons is an array that will store all the buttons in the grid
        
        for (javax.swing.JButton button: btnLetters) {
            button.setEnabled(true);
        }
        
        
        
    }
    
    /**
     * is called if the user presses submit and the word entered is not valid
     */
    public void failure() {
        
        coordinatesPressed.clear();
        //will clear the history of buttons pressed
        
        //Will update table of words already entered
        String strPast = txtWords.getText() + "";
        if (strAttempt.length() != 0) txtWords.setText(strPast + "\nWord entered was not valid: " + strAttempt + "\n");
        //output the message
        
        
        strAttempt = "";
        //reset attempt and it's display
        lblAttempt.setText("");
        
        //THE FOLLOWING ENABLES ALL BUTTONS AGAIN
        javax.swing.JButton [] btnLetters = {btn00, btn01, btn02, btn03, btn10, btn11, btn12, btn13, btn20, btn21, btn22, btn23, btn30, btn31, btn32, btn33};
        //buttons is an array that will store all the buttons in the grid
        
        for (javax.swing.JButton button: btnLetters) {
            button.setEnabled(true);
        }
        
        
        
    }
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
            java.util.logging.Logger.getLogger(Boggle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Boggle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Boggle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Boggle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Boggle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn00;
    private javax.swing.JButton btn01;
    private javax.swing.JButton btn02;
    private javax.swing.JButton btn03;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn30;
    private javax.swing.JButton btn31;
    private javax.swing.JButton btn32;
    private javax.swing.JButton btn33;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnShuffle;
    private javax.swing.JButton btnSubmitWord;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAttempt;
    private javax.swing.JLabel lblReminder;
    private javax.swing.JLabel lblReminder1;
    private javax.swing.JLabel lblReminder2;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblTableTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle5;
    private javax.swing.JLabel lblTitle6;
    private javax.swing.JScrollPane scrWords;
    private javax.swing.JTextArea txtWords;
    // End of variables declaration//GEN-END:variables
}
