package GraveLifeTracker;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

    private JFrame frame;
    private JTextField txtPlayerNumber;
    public int playerCount = 1;
    private JTextField[] txtArray;
    private JLabel[] playerLabelsGT;
    private JButton[] btnCreatureMinusGT;
    private JLabel[] lblCreatureCount;
    private JButton[] btnCreaturePlusGT;
    private JLabel[] lblTotalCountGT;
    private JButton[] btnTotalMinusGT;
    private JButton[] btnTotalPlusGT;
    private JCheckBox[] checkBoxes;
    private JLabel[] playerLabelsLT;
    private JButton[] btnLifeMinusLT;
    private JLabel[] lblPlayerLife;
    private JButton[] btnLifePlusLT;
    private JButton[] btnResetLife;
    private JButton btnResetAllLife;
    private JButton btnCommander;
    private JButton btnStandard;
    private JButton[] btnResetTotalGT;
    private JButton[] btnResetCreaturesGT;
    private JButton btnResetAllCreaturesGT;
    private JButton btnResetAllTotalGT;
    private JButton btnResetEverythingGT;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                    window.frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main() {
        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        //Creates the startingLife Label and sets the text to "40"
        JLabel lblStartingLife = new JLabel();
        lblStartingLife.setText("40");


        //Creates the main JFrame and establishes its dimensions.
        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 255, 0));
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Initializes Main Panel
        JPanel panelMain = new JPanel();
        panelMain.setForeground(new Color(0, 255, 0));
        panelMain.setBackground(new Color(0, 0, 0));
        panelMain.setBounds(0, 0, 986, 963);
        frame.getContentPane().add(panelMain);
        panelMain.setLayout(null);
        panelMain.setVisible(true);



        //Initializes PlayerNames Panel
        JPanel panelPlayerNames = new JPanel();
        panelPlayerNames.setLayout(null);
        panelPlayerNames.setForeground(Color.GREEN);
        panelPlayerNames.setBackground(Color.BLACK);
        panelPlayerNames.setBounds(0, 0, 986, 963);
        frame.getContentPane().add(panelPlayerNames);
        panelPlayerNames.setVisible(false);


        //Initializes GraveTacker Panel
        JPanel panelGraveTracker = new JPanel();
        panelGraveTracker.setBackground(new Color(0, 0, 0));
        panelGraveTracker.setBounds(0, 0, 986, 963);
        frame.getContentPane().add(panelGraveTracker);
        panelGraveTracker.setLayout(null);
        panelGraveTracker.setVisible(false);

        //Initializes LifeTracker Panel
        JPanel panelLifeTracker = new JPanel();
        panelLifeTracker.setForeground(new Color(0, 255, 0));
        panelLifeTracker.setBackground(new Color(0, 0, 0));
        panelLifeTracker.setBounds(0, 0, 986, 963);
        frame.getContentPane().add(panelLifeTracker);
        panelLifeTracker.setLayout(null);
        panelLifeTracker.setVisible(false);

        /*
        */

        //panelMain code
        JLabel lblSelectPlayers = new JLabel("Select number of players:");
        lblSelectPlayers.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectPlayers.setForeground(Color.GREEN);
        lblSelectPlayers.setFont(new Font("Engravers MT", Font.BOLD, 30));
        lblSelectPlayers.setBounds(143, 411, 700, 50);
        panelMain.add(lblSelectPlayers);

        JLabel lblMainHeader = new JLabel("Plums's Grave Life Tracker");
        lblMainHeader.setBounds(143, 130, 700, 50);
        panelMain.add(lblMainHeader);
        lblMainHeader.setFont(new Font("Engravers MT", Font.BOLD, 30));
        lblMainHeader.setForeground(new Color(0, 255, 0));
        lblMainHeader.setHorizontalAlignment(SwingConstants.CENTER);
        panelMain.setLayout(null);

        //Text field that displays the current selected number of players
        txtPlayerNumber = new JTextField();
        txtPlayerNumber.setHorizontalAlignment(SwingConstants.CENTER);
        txtPlayerNumber.setText("1");
        txtPlayerNumber.setFont(new Font("Engravers MT", Font.BOLD, 30));
        txtPlayerNumber.setForeground(new Color(0, 255, 0));
        txtPlayerNumber.setBackground(new Color(0, 0, 0));
        txtPlayerNumber.setEditable(false);
        txtPlayerNumber.setBounds(428, 521, 130, 50);
        panelMain.add(txtPlayerNumber);


        //Player count "-" button
        JButton btnMinusButton = new JButton("-");
        btnMinusButton.setForeground(new Color(0, 255, 0));
        btnMinusButton.setBackground(new Color(0, 0, 0));
        btnMinusButton.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnMinusButton.setBounds(312, 521, 100, 50);
        panelMain.add(btnMinusButton);
        btnMinusButton.addActionListener(_ -> {
            if (playerCount > 1) {
                playerCount--;
                txtArray[playerCount].setVisible(false); // Hide last visible text field
                txtPlayerNumber.setText(String.valueOf(playerCount)); // Update count
            }
        });


        //Player count "+" button
        JButton btnPlusButton = new JButton("+");
        btnPlusButton.setForeground(new Color(0, 255, 0));
        btnPlusButton.setBackground(new Color(0, 0, 0));
        btnPlusButton.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnPlusButton.setBounds(573, 521, 100, 50);
        panelMain.add(btnPlusButton);
        btnPlusButton.addActionListener(_ -> {
            if (playerCount < txtArray.length) {
                txtArray[playerCount].setVisible(true); // Show next text field
                playerCount++;
                txtPlayerNumber.setText(String.valueOf(playerCount));// Update count
            }
        });

        //Exit button
        JButton btnExit = new JButton("Exit");
        btnExit.setForeground(Color.GREEN);
        btnExit.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnExit.setBackground(Color.BLACK);
        btnExit.setBounds(137, 688, 275, 50);
        panelMain.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Continues to the PlayerNames panel
        JButton btnContinue = new JButton("Continue");
        btnContinue.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnContinue.setBackground(new Color(0, 0, 0));
        btnContinue.setForeground(new Color(0, 255, 0));
        btnContinue.setBounds(573, 688, 275, 50);
        panelMain.add(btnContinue);
        btnContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelMain.setVisible(false);
                panelPlayerNames.setVisible(true);

            }
        });


        /*
         */


        //panelPlayerNames code
        JButton btnBack = new JButton("Back");
        btnBack.setForeground(Color.GREEN);
        btnBack.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnBack.setBackground(Color.BLACK);
        btnBack.setBounds(573, 853, 251, 50);
        panelPlayerNames.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelPlayerNames.setVisible(false);
                panelMain.setVisible(true);
            }
        });

        //Exit button
        JButton btnExitPN = new JButton("Exit");
        btnExitPN.setForeground(Color.GREEN);
        btnExitPN.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnExitPN.setBackground(Color.BLACK);
        btnExitPN.setBounds(161, 853, 251, 50);
        panelPlayerNames.add(btnExitPN);
        btnExitPN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Sets LifeTracker panel visible and PlayerNames not visible
        JButton btnLife = new JButton("LIFE");
        btnLife.setForeground(Color.GREEN);
        btnLife.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnLife.setBackground(Color.BLACK);
        btnLife.setBounds(161, 791, 251, 50);
        panelPlayerNames.add(btnLife);
        btnLife.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    updateVisibility(playerCount, panelPlayerNames, panelLifeTracker);


            }
        });

        //Sets GraveTracker panel visible and PlayerNames not visible
        JButton btnGrave = new JButton("GRAVE");
        btnGrave.setForeground(Color.GREEN);
        btnGrave.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnGrave.setBackground(Color.BLACK);
        btnGrave.setBounds(573, 791, 251, 50);
        panelPlayerNames.add(btnGrave);
        btnGrave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    updateVisibility(playerCount, panelPlayerNames, panelGraveTracker);

            }
        });


        //Establishes an array of JTextFields for entering player names.
        txtArray = new JTextField[10];
        for (int i = 0; i < txtArray.length; i++) {
            txtArray[i] = new JTextField("Player " + (i + 1));
            txtArray[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            txtArray[i].setForeground(Color.GREEN);
            txtArray[i].setBackground(Color.BLACK);
            txtArray[i].setBounds(100, 90 + i * 58, 780, 46);
            txtArray[i].setVisible(i == 0); // Dynamically controls TextField visibility
            panelPlayerNames.add(txtArray[i]);
        }


        /*
         */


        //panelGraveTracker code
        //Array of checkBoxes used to track the type of cards in graveyards
        checkBoxes = new JCheckBox[9];
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox("CheckBox" + (i + 1));
            checkBoxes[i].setFont(new Font("Engravers MT", Font.BOLD, 20));
            checkBoxes[i].setForeground(Color.GREEN);
            checkBoxes[i].setBackground(Color.BLACK);
            checkBoxes[i].setBounds(400, 560 + i * 30, 260, 25);
            checkBoxes[i].setVisible(true);
            panelGraveTracker.add(checkBoxes[i]);
        }
        String[] checkBoxesText = {"Artifact", "Battle", "Creature", "Enchantment", "Instant", "Kindred", "Planeswalker", "Land", "Sorcery"};
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i].setText(checkBoxesText[i]);
        }

        //Labels that hold player names entered in respective textboxes on PlayerNames panel.
        playerLabelsGT = new JLabel[10];
        for (int i = 0; i < playerLabelsGT.length; i++) {
            playerLabelsGT[i] = new JLabel("Player" + i + 1);
            playerLabelsGT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            playerLabelsGT[i].setForeground(Color.GREEN);
            playerLabelsGT[i].setBackground(Color.BLACK);
            playerLabelsGT[i].setBounds(50, 100 + i * 40, 300, 35);
            playerLabelsGT[i].setVisible(i == 0);
            panelGraveTracker.add(playerLabelsGT[i]);

        }


        JLabel lblCreatureGT = new JLabel("Creatures");
        lblCreatureGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        lblCreatureGT.setForeground(Color.GREEN);
        lblCreatureGT.setBackground(Color.BLACK);
        lblCreatureGT.setBounds(290, 50, 250, 35);
        panelGraveTracker.add(lblCreatureGT);

        JLabel lblTotalGT = new JLabel("Total");
        lblTotalGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        lblTotalGT.setForeground(Color.GREEN);
        lblTotalGT.setBackground(Color.BLACK);
        lblTotalGT.setBounds(690, 50, 250, 35);
        panelGraveTracker.add(lblTotalGT);

        //Labels to display creature count for the corresponding players
        lblCreatureCount = new JLabel[10];
        for (int i = 0; i < lblCreatureCount.length; i++) {
            lblCreatureCount[i] = new JLabel("lblCreatureCount" + (i + 1)); // Correct label text
            lblCreatureCount[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            lblCreatureCount[i].setForeground(Color.GREEN);
            lblCreatureCount[i].setBackground(Color.BLACK);
            lblCreatureCount[i].setBounds(400, 100 + i * 40, 65, 35); // Adjusted X position for labels
            lblCreatureCount[i].setText("0");
            panelGraveTracker.add(lblCreatureCount[i]);
        }

        //Creature minus buttons to adjust creature count
        btnCreatureMinusGT = new JButton[10];
        for (int i = 0; i < btnCreatureMinusGT.length; i++) {
            btnCreatureMinusGT[i] = new JButton("btnCreatureMinus" + (i + 1)); // Correct button label
            btnCreatureMinusGT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            btnCreatureMinusGT[i].setForeground(Color.GREEN);
            btnCreatureMinusGT[i].setBackground(Color.BLACK);
            btnCreatureMinusGT[i].setBounds(300, 100 + i * 40, 65, 35);
            btnCreatureMinusGT[i].setText("-");
            panelGraveTracker.add(btnCreatureMinusGT[i]);


            int index = i;
            btnCreatureMinusGT[i].addActionListener(e -> {
                int creatureCount = Integer.parseInt(lblCreatureCount[index].getText());
                // Prevent negative numbers
                if (creatureCount > 0) {
                    lblCreatureCount[index].setText(String.valueOf(creatureCount - 1));
                }
                if (creatureCount == 0) {
                    JOptionPane.showMessageDialog(null, "You cannot have a negative number of Creatures.", "Centered Message", JOptionPane.INFORMATION_MESSAGE);
                }

            });
        }

        //Creature plus buttons to adjust creature count
        btnCreaturePlusGT = new JButton[10];
        for (int i = 0; i < btnCreaturePlusGT.length; i++) {
            btnCreaturePlusGT[i] = new JButton("btnCreaturePlus" + (i + 1)); // Number the button labels
            btnCreaturePlusGT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            btnCreaturePlusGT[i].setForeground(Color.GREEN);
            btnCreaturePlusGT[i].setBackground(Color.BLACK);
            btnCreaturePlusGT[i].setBounds(465, 100 + i * 40, 65, 35); // Adjusted X position for plus buttons
            btnCreaturePlusGT[i].setText("+");
            panelGraveTracker.add(btnCreaturePlusGT[i]);

            int index = i;
            btnCreaturePlusGT[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int creatureCount = Integer.parseInt(lblCreatureCount[index].getText());
                    //Prevents Creature Count from going over 100 and throws an error message when a user attempts to increase the count beyond 100.
                    if (creatureCount < 100) {
                        lblCreatureCount[index].setText(String.valueOf(creatureCount + 1));
                    }
                    if (creatureCount == 100) {
                        JOptionPane.showMessageDialog(null, "You cannot have more than 100 creatures.", "Centered Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
        }

        //Resets creature count for the respective player to 0
        btnResetCreaturesGT = new JButton[10];
        for (int i = 0; i < btnResetCreaturesGT.length; i++) {
            btnResetCreaturesGT[i] = new JButton("btnResetCountsGT" + (i + 1));
            btnResetCreaturesGT[i].setFont(new Font("Engravers MT", Font.BOLD, 20));
            btnResetCreaturesGT[i].setForeground(Color.GREEN);
            btnResetCreaturesGT[i].setBackground(Color.BLACK);
            btnResetCreaturesGT[i].setBounds(550, 100 + i * 40, 65, 35);
            btnResetCreaturesGT[i].setText("R");
            panelGraveTracker.add(btnResetCreaturesGT[i]);
            int index = i;
            btnResetCreaturesGT[i].addActionListener(e -> {
                lblCreatureCount[index].setText("0");

            });
        }

        //Resets all creature counts to 0.
        btnResetAllCreaturesGT = new JButton("btnResetAllCreaturesGT");
        btnResetAllCreaturesGT.setText("Reset");
        btnResetAllCreaturesGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnResetAllCreaturesGT.setForeground(Color.GREEN);
        btnResetAllCreaturesGT.setBackground(Color.BLACK);
        btnResetAllCreaturesGT.setBounds(323, 500, 170, 35);
        panelGraveTracker.add(btnResetAllCreaturesGT);
        for (int i = 0; i < lblCreatureCount.length; i++) {
            int index = i;
            btnResetAllCreaturesGT.addActionListener(e -> {
                lblCreatureCount[index].setText("0");

            });
    }


        //Total minus buttons
        btnTotalMinusGT = new JButton[10];
        for (int i = 0; i < btnTotalMinusGT.length; i++) {
            btnTotalMinusGT[i] = new JButton("btnTotalMinusGT" + (i + 1));
            btnTotalMinusGT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            btnTotalMinusGT[i].setForeground(Color.GREEN);
            btnTotalMinusGT[i].setBackground(Color.BLACK);
            btnTotalMinusGT[i].setBounds(650, 100 + i * 40, 65, 35);
            btnTotalMinusGT[i].setText("-");
            panelGraveTracker.add(btnTotalMinusGT[i]);

            int index = i;
            btnTotalMinusGT[i].addActionListener(e -> {
                int totalCount = Integer.parseInt(lblTotalCountGT[index].getText());
                //Prevents the Total Count from going below 0 and throws an error message if the user attempts to decrease the Total Count below 0
                if (totalCount > 0) { // Prevent negative numbers
                    lblTotalCountGT[index].setText(String.valueOf(totalCount - 1));
                }
                if (totalCount == 0) {
                    JOptionPane.showMessageDialog(null, "You cannot have a negative number of cards.", "Centered Message", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }

        //Labels that display the Total Count amount
        lblTotalCountGT = new JLabel[10];
        for (int i = 0; i < lblTotalCountGT.length; i++) {
            lblTotalCountGT[i] = new JLabel("lblTotalCountGT" + (i + 1));
            lblTotalCountGT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            lblTotalCountGT[i].setForeground(Color.GREEN);
            lblTotalCountGT[i].setBackground(Color.BLACK);
            lblTotalCountGT[i].setBounds(750, 100 + i * 40, 65, 35);
            lblTotalCountGT[i].setText("0");
            panelGraveTracker.add(lblTotalCountGT[i]);

        }

        //Total plus buttons
        btnTotalPlusGT = new JButton[10];
        for (int i = 0; i < btnTotalPlusGT.length; i++) {
            btnTotalPlusGT[i] = new JButton("btnTotalPlusGT" + (i + 1));
            btnTotalPlusGT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            btnTotalPlusGT[i].setForeground(Color.GREEN);
            btnTotalPlusGT[i].setBackground(Color.BLACK);
            btnTotalPlusGT[i].setBounds(800, 100 + i * 40, 65, 35);
            btnTotalPlusGT[i].setText("+");
            panelGraveTracker.add(btnTotalPlusGT[i]);

            int index = i;
            btnTotalPlusGT[i].addActionListener(e -> {
                int totalCount = Integer.parseInt(lblTotalCountGT[index].getText());
                //Allows the user to increment the Total amount by 1 as long as the Total count is less than 0 and shows a dialog box when a user attempts to raise the count above 100.
                if (totalCount < 100) {
                    lblTotalCountGT[index].setText(String.valueOf(totalCount + 1));
                }
                if (totalCount == 100) {
                    JOptionPane.showMessageDialog(null, "You cannot have more than 100 cards.", "Centered Message", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }

        //Reset buttons for each individual player's Total Count.
        btnResetTotalGT = new JButton[10];
        for (int i = 0; i < btnResetTotalGT.length; i++) {
            btnResetTotalGT[i] = new JButton("btnResetCountsGT" + (i + 1));
            btnResetTotalGT[i].setFont(new Font("Engravers MT", Font.BOLD, 20));
            btnResetTotalGT[i].setForeground(Color.GREEN);
            btnResetTotalGT[i].setBackground(Color.BLACK);
            btnResetTotalGT[i].setBounds(880, 100 + i * 40, 65, 35);
            btnResetTotalGT[i].setText("R");
            panelGraveTracker.add(btnResetTotalGT[i]);
            int index = i;
            btnResetTotalGT[i].addActionListener(e -> {
                lblTotalCountGT[index].setText("0");

            });
        }

        //Reset button for all Total Counts on the page.
        btnResetAllTotalGT = new JButton("btnResetAllCreaturesGT");
        btnResetAllTotalGT.setText("Reset");
        btnResetAllTotalGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnResetAllTotalGT.setForeground(Color.GREEN);
        btnResetAllTotalGT.setBackground(Color.BLACK);
        btnResetAllTotalGT.setBounds(673, 500, 170, 35);
        panelGraveTracker.add(btnResetAllTotalGT);
        for (int i = 0; i < lblTotalCountGT.length; i++) {
            int index = i;
            btnResetAllTotalGT.addActionListener(e -> {
                lblTotalCountGT[index].setText("0");

            });
        }

        //Button that resets the state of all labels and checkboxes to their default state of either 0 for labels or unchecked for the checkboxes.
        btnResetEverythingGT = new JButton("btnResetEverythingGT");
        btnResetEverythingGT.setText("<html>Reset<br/>All</html>");
        btnResetEverythingGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnResetEverythingGT.setForeground(Color.GREEN);
        btnResetEverythingGT.setBackground(Color.BLACK);
        btnResetEverythingGT.setBounds(673, 650, 170, 70);
        btnResetEverythingGT.setHorizontalAlignment(JButton.CENTER);
        panelGraveTracker.add(btnResetEverythingGT);
        for (int i = 0; i < lblTotalCountGT.length; i++) {
            int index = i;
            btnResetEverythingGT.addActionListener(e -> {
                lblTotalCountGT[index].setText("0");
                lblCreatureCount[index].setText("0");
                for (JCheckBox checkBox : checkBoxes) checkBox.setSelected(false);
            });
        }

        //Sets LifeTracker panel to visible status and sets GraveTarcker panel to not visible.
        JButton btnLifeGT = new JButton("LIFE");
        btnLifeGT.setForeground(Color.GREEN);
        btnLifeGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnLifeGT.setBackground(Color.BLACK);
        btnLifeGT.setBounds(367, 853, 251, 50);
        panelGraveTracker.add(btnLifeGT);
        btnLifeGT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelGraveTracker.setVisible(false);
                panelLifeTracker.setVisible(true);
            }
        });

        //Exits the application
        JButton btnExitGT = new JButton("Exit");
        btnExitGT.setForeground(Color.GREEN);
        btnExitGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnExitGT.setBackground(Color.BLACK);
        btnExitGT.setBounds(58, 853, 251, 50);
        panelGraveTracker.add(btnExitGT);
        btnExitGT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Returns to the PlayerNames panel and hides the GraveTracker panel
        JButton btnBackGT = new JButton("Back");
        btnBackGT.setForeground(Color.GREEN);
        btnBackGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnBackGT.setBackground(Color.BLACK);
        btnBackGT.setBounds(676, 853, 251, 50);
        panelGraveTracker.add(btnBackGT);
        panelGraveTracker.setVisible(false);
        btnBackGT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelGraveTracker.setVisible(false);
                panelPlayerNames.setVisible(true);
            }
        });




        //panelLifeTracker Code
        //Sets GraveTracker panel to visible and LifeTracker panel to not visible
        JButton btnGraveLT = new JButton("GRAVE");
        btnGraveLT.setForeground(Color.GREEN);
        btnGraveLT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnGraveLT.setBackground(Color.BLACK);
        btnGraveLT.setBounds(367, 853, 251, 50);
        panelLifeTracker.add(btnGraveLT);
        btnGraveLT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelLifeTracker.setVisible(false);
                panelGraveTracker.setVisible(true);
            }
        });

        //Exits the application
        JButton btnExitLT = new JButton("Exit");
        btnExitLT.setForeground(Color.GREEN);
        btnExitLT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnExitLT.setBackground(Color.BLACK);
        btnExitLT.setBounds(58, 853, 251, 50);
        panelLifeTracker.add(btnExitLT);
        btnExitLT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Sets PlayerNames panel to visible and LifeTracker panel to not visible
        JButton btnBackLT = new JButton("Back");
        btnBackLT.setForeground(Color.GREEN);
        btnBackLT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnBackLT.setBackground(Color.BLACK);
        btnBackLT.setBounds(676, 853, 251, 50);
        panelLifeTracker.add(btnBackLT);
        panelLifeTracker.setVisible(false);
        btnBackLT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelLifeTracker.setVisible(false);
                panelPlayerNames.setVisible(true);
            }
        });

        //Labels to display the names in the respective textboxes on PlayerNames panel.
        playerLabelsLT = new JLabel[10];
        for (int i = 0; i < playerLabelsLT.length; i++) {
            playerLabelsLT[i] = new JLabel("Player" + i + 1);
            playerLabelsLT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            playerLabelsLT[i].setForeground(Color.GREEN);
            playerLabelsLT[i].setBackground(Color.BLACK);
            playerLabelsLT[i].setBounds(100, 100 + i * 40, 300, 35);
            playerLabelsLT[i].setVisible(i == 0);
            panelLifeTracker.add(playerLabelsLT[i]);

        }

        //Life Total minus buttons
        btnLifeMinusLT = new JButton[10];
        for (int i = 0; i < btnLifeMinusLT.length; i++) {
            btnLifeMinusLT[i] = new JButton("btnLifeMinusLT" + i + 1);
            btnLifeMinusLT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            btnLifeMinusLT[i].setForeground(Color.GREEN);
            btnLifeMinusLT[i].setBackground(Color.BLACK);
            btnLifeMinusLT[i].setBounds(400, 100 + i * 40, 65, 35);
            btnLifeMinusLT[i].setVisible(i == 0);
            btnLifeMinusLT[i].setText("-");
            panelLifeTracker.add(btnLifeMinusLT[i]);

            int index = i;
            btnLifeMinusLT[i].addActionListener(e -> {
                int lifeCount = Integer.parseInt(lblPlayerLife[index].getText());
                // Prevent negative numbers from being displayed and show a dialog box stating the respective user has lost the game.
                if (lifeCount > 0) {
                    lblPlayerLife[index].setText(String.valueOf(lifeCount - 1));
                }
                if (lifeCount == 0) {
                    JOptionPane.showMessageDialog(null,  playerLabelsLT[index].getText().toUpperCase() + " has lost the game.", "Centered Message", JOptionPane.INFORMATION_MESSAGE);
                }
            });

        }

        //Labels that display the respective player Life Total
        lblPlayerLife = new JLabel[10];
        for (int i = 0; i < playerLabelsLT.length; i++) {
            lblPlayerLife[i] = new JLabel("lblPlayerLife" + i + 1);
            lblPlayerLife[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            lblPlayerLife[i].setForeground(Color.GREEN);
            lblPlayerLife[i].setBackground(Color.BLACK);
            lblPlayerLife[i].setBounds(500, 100 + i * 40, 300, 35);
            lblPlayerLife[i].setVisible(i == 0);
            lblPlayerLife[i].setText("40");
            panelLifeTracker.add(lblPlayerLife[i]);
        }

        //Button which increase the respective player's Life Total.
        btnLifePlusLT = new JButton[10];
        for (int i = 0; i < btnLifePlusLT.length; i++) {
            btnLifePlusLT[i] = new JButton("btnLifePlusLT" + i + 1);
            btnLifePlusLT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            btnLifePlusLT[i].setForeground(Color.GREEN);
            btnLifePlusLT[i].setBackground(Color.BLACK);
            btnLifePlusLT[i].setBounds(580, 100 + i * 40, 65, 35);
            btnLifePlusLT[i].setVisible(i == 0);
            btnLifePlusLT[i].setText("+");
            panelLifeTracker.add(btnLifePlusLT[i]);

            int index = i;
            btnLifePlusLT[i].addActionListener(e -> {
                int creatureCount = Integer.parseInt(lblPlayerLife[index].getText());
                lblPlayerLife[index].setText(String.valueOf(creatureCount + 1));
            });

        }

        //Resets the respective player's Life Total to either 40 for Commander mode or 20 for Standard mode.
        btnResetLife = new JButton[10];
        for (int i = 0; i < btnLifePlusLT.length; i++) {
            btnResetLife[i] = new JButton("btnLifePlusLT" + i + 1);
            btnResetLife[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            btnResetLife[i].setForeground(Color.GREEN);
            btnResetLife[i].setBackground(Color.BLACK);
            btnResetLife[i].setBounds(650, 100 + i * 40, 200, 35);
            btnResetLife[i].setVisible(i == 0);
            btnResetLife[i].setText("Reset");
            panelLifeTracker.add(btnResetLife[i]);
            int index = i;
            btnResetLife[i].addActionListener(e -> {
                lblPlayerLife[index].setText(lblStartingLife.getText());
            });
        }

        //Resets all life totals on the page to 40 or 20 depending on mode selected.
        btnResetAllLife = new JButton();
        btnResetAllLife.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnResetAllLife.setForeground(Color.GREEN);
        btnResetAllLife.setBackground(Color.BLACK);
        btnResetAllLife.setBounds(650, 500, 200, 70);
        btnResetAllLife.setText("<html>Reset<br />All</html>");
        panelLifeTracker.add(btnResetAllLife);
        btnResetAllLife.addActionListener(e -> {
            for(JLabel s : lblPlayerLife) {
                s.setText(lblStartingLife.getText());
            }
        });


        //Sets all the Life Totals 40 for Commander games.
        btnCommander = new JButton();
        btnCommander.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnCommander.setForeground(Color.GREEN);
        btnCommander.setBackground(Color.BLACK);
        btnCommander.setBounds(335, 50, 310, 35);
        btnCommander.setText("Commander");
        btnCommander.setVisible(true);
        panelLifeTracker.add(btnCommander);

            for (int i = 0; i < btnLifePlusLT.length; i++) {
                btnCommander.addActionListener(e -> {
                    lblStartingLife.setText("40");
                    for(JLabel s : lblPlayerLife){
                        s.setText(lblStartingLife.getText());
                    }
                });
            }

        //Sets all the Life Totals to 20 for Standard games.
        btnStandard = new JButton();
        btnStandard.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnStandard.setForeground(Color.GREEN);
        btnStandard.setBackground(Color.BLACK);
        btnStandard.setBounds(650, 50, 300, 35);
        btnStandard.setText("Standard");
        btnStandard.setVisible(true);
        panelLifeTracker.add(btnStandard);

        for (int i = 0; i < btnLifePlusLT.length; i++) {
            btnStandard.addActionListener(e -> {
                lblStartingLife.setText("20");
                for(JLabel s : lblPlayerLife){
                    s.setText(lblStartingLife.getText());
                }
            });
        }

    }

    // Method to update visibility
    private void updateVisibility(int playerCount, JPanel panelToHide, JPanel panelToShow) {
        for (int i = 0; i < playerCount; i++) {
             playerLabelsGT[i].setText(txtArray[i].getText());
            playerLabelsLT[i].setText(txtArray[i].getText());
            playerLabelsGT[i].setVisible(true);
            playerLabelsLT[i].setVisible(true);
            btnCreatureMinusGT[i].setVisible(true);
            btnCreaturePlusGT[i].setVisible(true);
            lblCreatureCount[i].setVisible(true);
            btnTotalMinusGT[i].setVisible(true);
            lblTotalCountGT[i].setVisible(true);
            btnTotalPlusGT[i].setVisible(true);
            btnLifeMinusLT[i].setVisible(true);
            btnLifePlusLT[i].setVisible(true);
            lblPlayerLife[i].setVisible(true);
            btnResetLife[i].setVisible(true);
            btnResetTotalGT[i].setVisible(true);
            btnResetCreaturesGT[i].setVisible(true);

        }
        for (int i = playerCount; i < playerLabelsGT.length; i++) {
            playerLabelsGT[i].setVisible(false);
            playerLabelsLT[i].setVisible(false);
            btnCreatureMinusGT[i].setVisible(false);
            btnCreaturePlusGT[i].setVisible(false);
            lblCreatureCount[i].setVisible(false);
            btnTotalMinusGT[i].setVisible(false);
            lblTotalCountGT[i].setVisible(false);
            btnTotalPlusGT[i].setVisible(false);
            btnLifeMinusLT[i].setVisible(false);
            btnLifePlusLT[i].setVisible(false);
            lblPlayerLife[i].setVisible(false);
            btnResetLife[i].setVisible(false);
            btnResetTotalGT[i].setVisible(false);
            btnResetCreaturesGT[i].setVisible(false);
        }
        panelToHide.setVisible(false);
        panelToShow.setVisible(true);
    }


}

