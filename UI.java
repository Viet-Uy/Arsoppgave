import java.awt.Color;
import java.awt.Font;
import java.net.ContentHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Container;


public class UI {
    
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel;
    JLabel titleNameLabel;
    JButton startButton;
    Font titlefont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalfont = new Font("Times New Roman", Font.PLAIN, 25);
    

    public void createUI(){

        

        //Window
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.black);
        window.setLayout(null);

        con = window.getContentPane();
        con.setBackground(Color.black);

        //Tittel skjerm
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 500);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("HEI");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titlefont);


        //Startknapp
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalfont);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);


        window.add(startButtonPanel);
        window.add(titleNamePanel);

        
        window.setVisible(true);

    }

}
