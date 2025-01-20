package GraveLifeTracker;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Main {

    private JFrame frame;
    private JTextField txtPlayerNumber;
    public int playerCount = 1;  // Start with 1 player visible
    private JTextField[] txtArray; // Array to hold all player text fields
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

        JLabel lblStartingLife = new JLabel();
        lblStartingLife.setText("40");

        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(0, 255, 0));
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Main Panel
        JPanel panelMain = new JPanel();
        panelMain.setForeground(new Color(0, 255, 0));
        panelMain.setBackground(new Color(0, 0, 0));
        panelMain.setBounds(0, 0, 986, 963);
        frame.getContentPane().add(panelMain);
        panelMain.setLayout(null);
        panelMain.setVisible(true);


        //PlayerNames Panel
        JPanel panelPlayerNames = new JPanel();
        panelPlayerNames.setLayout(null);
        panelPlayerNames.setForeground(Color.GREEN);
        panelPlayerNames.setBackground(Color.BLACK);
        panelPlayerNames.setBounds(0, 0, 986, 963);
        frame.getContentPane().add(panelPlayerNames);
        panelPlayerNames.setVisible(false);


        //GraveTacker Panel
        JPanel panelGraveTracker = new JPanel();
        panelGraveTracker.setBackground(new Color(0, 0, 0));
        panelGraveTracker.setBounds(0, 0, 986, 963);
        frame.getContentPane().add(panelGraveTracker);
        panelGraveTracker.setLayout(null);
        panelGraveTracker.setVisible(false);

        //LifeTracker Panel
        JPanel panelLifeTracker = new JPanel();
        panelLifeTracker.setForeground(new Color(0, 255, 0));
        panelLifeTracker.setBackground(new Color(0, 0, 0));
        panelLifeTracker.setBounds(0, 0, 986, 963);
        frame.getContentPane().add(panelLifeTracker);
        panelLifeTracker.setLayout(null);
        panelLifeTracker.setVisible(false);


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

        JButton btnExit = new JButton("Exit");
        btnExit.setForeground(Color.GREEN);
        btnExit.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnExit.setBackground(Color.BLACK);
        btnExit.setBounds(161, 688, 251, 50);
        panelMain.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        txtPlayerNumber = new JTextField();
        txtPlayerNumber.setHorizontalAlignment(SwingConstants.CENTER);
        txtPlayerNumber.setText("1");
        txtPlayerNumber.setFont(new Font("Engravers MT", Font.BOLD, 30));
        txtPlayerNumber.setForeground(new Color(0, 255, 0));
        txtPlayerNumber.setBackground(new Color(0, 0, 0));
        txtPlayerNumber.setEditable(false);
        txtPlayerNumber.setBounds(428, 521, 130, 50);
        panelMain.add(txtPlayerNumber);
        txtPlayerNumber.setColumns(1);


        // "-" button
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


        // "+" button
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


        JButton btnContinue = new JButton("Continue");
        btnContinue.setFont(new Font("Engravers MT", Font.BOLD, 30));
        btnContinue.setBackground(new Color(0, 0, 0));
        btnContinue.setForeground(new Color(0, 255, 0));
        btnContinue.setBounds(573, 688, 251, 50);
        panelMain.add(btnContinue);
        btnContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelMain.setVisible(false);
                panelPlayerNames.setVisible(true);

            }
        });

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


        //panelGraveTracker code
        //Array to hold all checkBoxes
        checkBoxes = new JCheckBox[8];
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox("CheckBox" + (i + 1));
            checkBoxes[i].setFont(new Font("Engravers MT", Font.BOLD, 20));
            checkBoxes[i].setForeground(Color.GREEN);
            checkBoxes[i].setBackground(Color.BLACK);
            checkBoxes[i].setBounds(400, 550 + i * 30, 300, 25);
            checkBoxes[i].setVisible(true);
            panelGraveTracker.add(checkBoxes[i]);
        }
        String[] checkBoxesText = {"Artifact", "Battle", "Creature", "Enchantment", "Instant", "Planeswalker", "Land", "Sorcery"};
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i].setText(checkBoxesText[i]);
        }

        playerLabelsGT = new JLabel[10];
        for (int i = 0; i < playerLabelsGT.length; i++) {
            playerLabelsGT[i] = new JLabel("Player" + i + 1);
            playerLabelsGT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            playerLabelsGT[i].setForeground(Color.GREEN);
            playerLabelsGT[i].setBackground(Color.BLACK);
            playerLabelsGT[i].setBounds(100, 100 + i * 40, 300, 35);
            playerLabelsGT[i].setVisible(i == 0);
            panelGraveTracker.add(playerLabelsGT[i]);

        }


        JLabel lblCreatureGT = new JLabel("Creatures");
        lblCreatureGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        lblCreatureGT.setForeground(Color.GREEN);
        lblCreatureGT.setBackground(Color.BLACK);
        lblCreatureGT.setBounds(390, 50, 250, 35);
        panelGraveTracker.add(lblCreatureGT);

        JLabel lblTotalGT = new JLabel("Total");
        lblTotalGT.setFont(new Font("Engravers MT", Font.BOLD, 30));
        lblTotalGT.setForeground(Color.GREEN);
        lblTotalGT.setBackground(Color.BLACK);
        lblTotalGT.setBounds(690, 50, 250, 35);
        panelGraveTracker.add(lblTotalGT);

        // Initialize creature count labels
        lblCreatureCount = new JLabel[10];
        for (int i = 0; i < lblCreatureCount.length; i++) {
            lblCreatureCount[i] = new JLabel("lblCreatureCount" + (i + 1)); // Correct label text
            lblCreatureCount[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            lblCreatureCount[i].setForeground(Color.GREEN);
            lblCreatureCount[i].setBackground(Color.BLACK);
            lblCreatureCount[i].setBounds(500, 100 + i * 40, 65, 35); // Adjusted X position for labels
            lblCreatureCount[i].setText("0");
            panelGraveTracker.add(lblCreatureCount[i]);
        }

        // Initialize minus buttons
        btnCreatureMinusGT = new JButton[10];
        for (int i = 0; i < btnCreatureMinusGT.length; i++) {
            btnCreatureMinusGT[i] = new JButton("btnCreatureMinus" + (i + 1)); // Correct button label
            btnCreatureMinusGT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            btnCreatureMinusGT[i].setForeground(Color.GREEN);
            btnCreatureMinusGT[i].setBackground(Color.BLACK);
            btnCreatureMinusGT[i].setBounds(400, 100 + i * 40, 65, 35);
            btnCreatureMinusGT[i].setText("-");
            panelGraveTracker.add(btnCreatureMinusGT[i]);

            // Capture the correct index for the button
            int index = i;
            btnCreatureMinusGT[i].addActionListener(e -> {
                int creatureCount = Integer.parseInt(lblCreatureCount[index].getText());
                if (creatureCount > 0) { // Prevent negative numbers
                    lblCreatureCount[index].setText(String.valueOf(creatureCount - 1));
                }
                if (creatureCount == 0) {
                    JOptionPane.showMessageDialog(null, "You cannot have a negative number of Creatures.", "Centered Message", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }

        // Initialize plus buttons
        btnCreaturePlusGT = new JButton[10];
        for (int i = 0; i < btnCreaturePlusGT.length; i++) {
            btnCreaturePlusGT[i] = new JButton("btnCreaturePlus" + (i + 1)); // Number the button labels
            btnCreaturePlusGT[i].setFont(new Font("Engravers MT", Font.BOLD, 30));
            btnCreaturePlusGT[i].setForeground(Color.GREEN);
            btnCreaturePlusGT[i].setBackground(Color.BLACK);
            btnCreaturePlusGT[i].setBounds(565, 100 + i * 40, 65, 35); // Adjusted X position for plus buttons
            btnCreaturePlusGT[i].setText("+");
            panelGraveTracker.add(btnCreaturePlusGT[i]);

            // Capture the correct index for the button
            int index = i;
            btnCreaturePlusGT[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int creatureCount = Integer.parseInt(lblCreatureCount[index].getText());
                    lblCreatureCount[index].setText(String.valueOf(creatureCount + 1));

                }
            });
        }

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
                int creatureCount = Integer.parseInt(lblCreatureCount[index].getText());
                if (creatureCount > 0) { // Prevent negative numbers
                    lblCreatureCount[index].setText(String.valueOf(creatureCount - 1));
                }
                if (creatureCount == 0) {
                    JOptionPane.showMessageDialog(null, "You cannot have a negative number of cards.", "Centered Message", JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }

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
                int creatureCount = Integer.parseInt(lblTotalCountGT[index].getText());
                lblTotalCountGT[index].setText(String.valueOf(creatureCount + 1));
            });
        }

        //panelLifeTracker Code
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
                int creatureCount = Integer.parseInt(lblPlayerLife[index].getText());
                if (creatureCount > 0) { // Prevent negative numbers
                    lblPlayerLife[index].setText(String.valueOf(creatureCount - 1));
                }
                if (creatureCount == 0) {
                    JOptionPane.showMessageDialog(null, "You cannot have a negative amount of life.", "Centered Message", JOptionPane.INFORMATION_MESSAGE);
                }
            });

        }

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
                int creatureCount = Integer.parseInt(lblPlayerLife[index].getText());
                lblPlayerLife[index].setText(lblStartingLife.getText());
            });
        }

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
        }
        panelToHide.setVisible(false);
        panelToShow.setVisible(true);
    }

}



