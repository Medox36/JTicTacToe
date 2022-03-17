import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GUI implements ActionListener {

    private final Random random;
    private final JLabel textFeld;
    private final JButton[] buttons;
    private final JButton button;
    private boolean turnOfP1;
    private int clicks = 0;

    public GUI() {
        random = new Random();
        textFeld = new JLabel();
        buttons = new JButton[9];
        button = new JButton();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setTitle("Tic Tac Toe - Game");

        textFeld.setBackground(new Color(50, 50, 50));
        textFeld.setForeground(new Color(78, 216, 172));
        textFeld.setFont(new Font("Ink Free", Font.BOLD, 75));
        textFeld.setHorizontalAlignment(JLabel.CENTER);
        textFeld.setText("Tic Tac Toe");
        textFeld.setOpaque(true);

        JPanel titelPanel = new JPanel();
        titelPanel.setLayout(new BorderLayout());
        titelPanel.setBounds(0, 0, 800, 100);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        button.setText("reset");
        button.setFont(new Font("Ink Free",Font.BOLD, 23));
        button.setBounds(650, 25, 90,45);
        button.setBackground(new Color( 123, 125, 125 ));
        button.setFocusable(false);
        button.addActionListener(this);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            buttons[i].setBackground(new Color(248, 249, 249));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        textFeld.add(button);
        titelPanel.add(textFeld);
        frame.add(titelPanel, BorderLayout.NORTH);
        frame.add(buttonPanel);
        frame.setVisible(true);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (turnOfP1) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(231, 76, 60));
                        buttons[i].setText("X");
                        turnOfP1 = false;
                        textFeld.setText("O am Zug");
                        check();
                        clicks++;
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(33, 97, 140));
                        buttons[i].setText("O");
                        turnOfP1 = true;
                        textFeld.setText("X am Zug");
                        check();
                        clicks++;
                    }
                }
            }
        }
        if (clicks > 8) {
            textFeld.setText("Unentschieden");
        }
        if (e.getSource() == button) {
            reset();
            firstTurn();
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void firstTurn() {
        if (random.nextInt(2) == 0) {
            turnOfP1 = true;
            textFeld.setText("X am Zug");
        } else {
            turnOfP1 = false;
            textFeld.setText("O am Zug");
        }
    }

    public void check() {
        if ((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
            xWinns(0, 1, 2);
        }
        if ((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
            xWinns(3, 4, 5);
        }
        if ((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWinns(6, 7, 8);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWinns(0, 3, 6);
        }
        if ((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
            xWinns(1, 4, 7);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWinns(2, 5, 8);
        }
        if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWinns(0, 4, 8);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWinns(2, 4, 6);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
            oWinns(0, 1, 2);
        }
        if ((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
            oWinns(3, 4, 5);
        }
        if ((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWinns(6, 7, 8);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWinns(0, 3, 6);
        }
        if ((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
            oWinns(1, 4, 7);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWinns(2, 5, 8);
        }
        if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWinns(0, 4, 8);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWinns(2, 4, 6);
        }
    }

    public void xWinns(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textFeld.setText("X gewinnt!");
    }

    public void oWinns(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textFeld.setText("O gewinnt!");
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(new Color(248, 249, 249));
            buttons[i].setEnabled(true);
        }
    }
}