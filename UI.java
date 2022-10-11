import java.awt.Color;
import java.awt.Font;
import java.net.ContentHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//import TestArsoppgave.Game.ChoiceHandler;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class UI {


    
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, mainTextLabel, hpLabel, hpNumberLabel, weaponLabel, weaponTypeLabel;
    JButton startButton, valg1, valg2, valg3, valg4;
    JTextArea mainTextArea;
    Font titlefont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalfont = new Font("Times New Roman", Font.PLAIN, 25);


    public void createUI(ChoiceHandler cHandler){

        

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
        titleNameLabel = new JLabel("SEX DUNGEON");
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
        //startButton.addActionListener();

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);


        window.add(startButtonPanel);
        window.add(titleNamePanel);

        //Spillskjerm
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalfont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonPanel);

        valg1 = new JButton();
        valg1.setBackground(Color.black);
        valg1.setForeground(Color.white);
        valg1.setFont(normalfont);
        valg1.setFocusPainted(false);
        choiceButtonPanel.add(valg1);

        valg2 = new JButton();
        valg2.setBackground(Color.black);
        valg2.setForeground(Color.white);
        valg2.setFont(normalfont);
        valg2.setFocusPainted(false);
        choiceButtonPanel.add(valg2);

        valg3 = new JButton();
        valg3.setBackground(Color.black);
        valg3.setForeground(Color.white);
        valg3.setFont(normalfont);
        valg3.setFocusPainted(false);
        choiceButtonPanel.add(valg3);

        valg4 = new JButton();
        valg4.setBackground(Color.black);
        valg4.setForeground(Color.white);
        valg4.setFont(normalfont);
        valg4.setFocusPainted(false);
        choiceButtonPanel.add(valg4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setForeground(Color.white);
        playerPanel.setLayout(new GridLayout(1, 4));
        window.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalfont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpNumberLabel = new JLabel();
        hpNumberLabel.setFont(normalfont);
        hpNumberLabel.setForeground(Color.white);
        playerPanel.add(hpNumberLabel);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalfont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponTypeLabel = new JLabel();
        weaponTypeLabel.setFont(normalfont);
        weaponTypeLabel.setBackground(Color.white);
        playerPanel.add(weaponTypeLabel);


        window.setVisible(true);

    }




}
