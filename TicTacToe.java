import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
public class TicTacToe implements ActionListener{

    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton button6;
    public JButton button7;
    public JButton button8;
    public JButton button9;
    public JFrame frame;
    public int plays = 0;
    int[][] board = { {2,3,4,5},{6,7,8,9},{10,11,12,13}}; //0's represent o, 1 represents x
    public TicTacToe(){
        JFrame frame = new JFrame("Default Game");
    }

    public TicTacToe(String title){
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
        frame.setBounds(0, 0, 350, 350);

        button1 = new JButton(" ");
        button1.setBounds(0, 0, 100, 100);
        frame.getContentPane().add(button1); // Adds Button to content pane of frame
        button1.addActionListener(this);


        button2 = new JButton(" ");
        button2.setBounds(100, 0, 100, 100);
        frame.getContentPane().add(button2);
        button2.addActionListener(this);

        button3 = new JButton(" ");
        button3.setBounds(200, 0, 100, 100);
        frame.getContentPane().add(button3);
        button3.addActionListener(this);

        button4 = new JButton(" ");
        button4.setBounds(0, 100, 100, 100);
        frame.getContentPane().add(button4);
        button4.addActionListener(this);

        button5 = new JButton(" ");
        button5.setBounds(100, 100, 100, 100);
        frame.getContentPane().add(button5);
        button5.addActionListener(this);

        button6 = new JButton(" ");
        button6.setBounds(200, 100, 100, 100);
        frame.getContentPane().add(button6);
        button6.addActionListener(this);

        button7 = new JButton(" ");
        button7.setBounds(0, 200, 100, 100);
        frame.getContentPane().add(button7);
        button7.addActionListener(this);

        button8 = new JButton(" ");
        button8.setBounds(100, 200, 100, 100);
        frame.getContentPane().add(button8);
        button8.addActionListener(this);

        button9 = new JButton(" ");
        button9.setBounds(200,200,100,100);
        frame.getContentPane().add(button9);
        button9.addActionListener(this);

        JButton buttonR = new JButton("");
        buttonR.setBounds(600,600,600,600);
        frame.getContentPane().add(buttonR);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        String player;
        if(plays%2 == 0)
            player = "x";
        else
            player = "o";
        if (e.getActionCommand().equals(" ")) {
            if(e.getSource() == button1) {
                button1.setText(player);
                board[0][0] = plays%2;
            }else if(e.getSource() == button2) {
                button2.setText(player);
                board[0][1] = plays%2;
            }else if(e.getSource() == button3) {
                button3.setText(player);
                board[0][2] = plays%2;
            }else if(e.getSource() == button4) {
                button4.setText(player);
                board[1][0] = plays%2;
            }else if(e.getSource() == button5) {
                button5.setText(player);
                board[1][1] = plays%2;
            }else if(e.getSource() == button6){
                button6.setText(player);
                board[1][2] = plays%2;
            }else if(e.getSource() == button7) {
                button7.setText(player);
                board[2][0] = plays%2;
            }else if(e.getSource() == button8) {
                button8.setText(player);
                board[2][1] = plays%2;
            }else if(e.getSource() == button9) {
                button9.setText(player);
                board[2][2] = plays%2;
            }
            plays++;
            if(winner()) {
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
                
                JFrame winScreen = new JFrame("winner");
                winScreen.setBounds(0, 0, 200, 200);
                JLabel label  = new JLabel(player + " is the winner");
                label.setBounds(100,50,50,50);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                winScreen.add(label);
                winScreen.getContentPane().setBackground(Color.green);

                winScreen.setVisible(true);

            }


        }

    }

    public boolean winner(){
        if(board[0][0] == board[0][1] && board[0][0] ==board[0][2])
            return true;
        else if(board[1][0] == board[1][1] && board[1][0] ==board[1][2])
            return true;
        else if(board[2][0] == board[2][1] && board[2][0] ==board[2][2])
            return true;
        else if(board[0][0] == board[1][0] && board[0][0] == board[2][0])
            return true;
        else if (board[0][1] == board[1][1] && board[0][1] == board[2][1])
            return true;
        else if (board[0][2] == board[1][2] && board[0][2] ==board[2][2])
            return true;
        else if(board[0][0] == board[1][1] && board[0][0] ==board[2][2])
            return true;
        else if(board[0][2] == board[1][1] && board[0][2] ==board[2][0])
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        TicTacToe frame = new TicTacToe("Tic Tac Toe");

    }
}

