
import java.awt.*;//The java.awt package provides classes for AWT API such as TextField, Label, TextArea, RadioButton, CheckBox, Choice, List etc.
import java.awt.event.*; // Java AWT (Abstract Window Toolkit) is an API to develop Graphical User Interface (GUI) or windows-based applications in Java.
import java.util.*;
import javax.swing.*; //swing is a GUI tool kit for java that is used to create GUI applications
public class Main{
    public static void main(String[] args){
        TicTacToe ticTacToe = new TicTacToe();
    }
}

class TicTacToe implements ActionListener {
    boolean flag = false;
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//it tells when we close the frame it should close completely
        frame.setSize(800, 800);// sets the size of the frame
        frame.getContentPane().setBackground(new Color(50, 50, 50));//background color
        frame.setLayout(new BorderLayout());//this will divide the frame into five regionsNorth, Soth, West, East and Center
        frame.setVisible(true);//it tells to show whatever actions are performed

        textfield.setBackground(new Color(25, 25, 25)); // sets the background color of the textfield/header
        textfield.setForeground(new Color(25, 255, 0)); //sets the text color
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));// giving the style to the font
        textfield.setHorizontalAlignment(JLabel.CENTER);// aligning the text in center
        textfield.setText("Tic-Tac-Toe"); //the text to be displayed in
        textfield.setPreferredSize(new Dimension(800, 100));// sets the size of the textfield
        textfield.setOpaque(true); // it displays the background color of the header

        title_panel.setLayout(new BorderLayout()); //  it will set the size of the title_panel to 800x100 pixels (width, height) 
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3)); //dividing space to three rows and 3 columns
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);// focusable is used to make the button not focusable
            buttons[i].addActionListener(this);// this will call the action when the button is clicked
        }

        //without adding all this to frame it is not gonna work
        title_panel.add(textfield); // adding textfield properties to the title_panel
        frame.add(title_panel, BorderLayout.NORTH); // BorderLayout.North can be ignored becoz of line 39
        frame.add(button_panel);// adding button_panel properties to the frame

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) { // to check whether the button is pressed or not
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0)); // color given to x text is red
                        buttons[i].setText("X");// sets the button text to X
                        player1_turn = false;
                        textfield.setText("O turn");// sets the header text to O after player1_turn is over
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255)); // coor given to O text is blue
                        buttons[i].setText("O"); // setting the tetxt as O
                        player1_turn = true;
                        textfield.setText("X turn"); // sets the header text to X after O turn
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        //after two seconds it generaytes the random number and decides who will go first
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }

        // it will generate a random number between 0 and 2
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        // check X win conditions
        if ((buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        // check O win conditions
        if ((buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        // check for draw
        if ((buttons[0].getText() != "") &&
                (buttons[1].getText() != "") &&
                (buttons[2].getText() != "") &&
                (buttons[3].getText() != "") &&
                (buttons[4].getText() != "") &&
                (buttons[5].getText() != "") &&
                (buttons[6].getText() != "") &&
                (buttons[7].getText() != "") &&
                (buttons[8].getText() != "") &&
                (flag == false)) {
            draw();
        }
    }

    public void xWins(int a, int b, int c) {
        flag = true;
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        flag = true;
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
    }

    public void draw() {

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("Draw");
    }
}