import java.awt.Color;
import java.awt.Font;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UI {
    Game game;
    SkjermVisning sv = new SkjermVisning(game, this);
    Player player = new Player();
    Story story = new Story(game, this, sv, player);
    Database database = new Database();
    

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, mainTextPanelSI, skrivNavnPanel, enterKnappPanel;
    static JLabel titleNameLabel, mainTextLabel, hpLabel, weaponLabel, weaponTypeLabel, navnLabel, navnLabelInnhold, currentPosition, hpNumberLabel;
    JButton startButton, valg1, valg2, valg3, valg4, enterKnapp, save;
    JTextField skrivNavn;
    JTextArea mainTextArea, mainTextAreaSI;
    Font titlefont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalfont = new Font("Times New Roman", Font.PLAIN, 25);
    static String navn;

    



    public void createUI(Game.ChoiceHandler cHandler){

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
        titleNameLabel = new JLabel("lol");
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
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);


        window.add(startButtonPanel);
        window.add(titleNamePanel);

        //Sign In
        mainTextPanelSI = new JPanel();
        mainTextPanelSI.setBounds(100, 100, 600, 250);
        mainTextPanelSI.setBackground(Color.black);
        window.add(mainTextPanelSI);

        mainTextAreaSI = new JTextArea("Please write your name in the field bellow");
        mainTextAreaSI.setBounds(175, 100, 450, 250);
        mainTextAreaSI.setBackground(Color.black);
        mainTextAreaSI.setForeground(Color.white);
        mainTextAreaSI.setFont(normalfont);
        mainTextAreaSI.setLineWrap(true);
        mainTextAreaSI.setWrapStyleWord(true);
        mainTextAreaSI.setEditable(false);
        
        mainTextPanelSI.add(mainTextAreaSI);
        



        skrivNavnPanel = new JPanel();
        skrivNavnPanel.setBounds(250, 350, 300, 50);
        skrivNavnPanel.setBackground(Color.black);
        skrivNavnPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        window.add(skrivNavnPanel);





        skrivNavn = new JTextField("Navn");
        skrivNavn.selectAll();
        skrivNavn.setLayout(null);
        skrivNavn.setBounds(250, 350, 600, 50);
        skrivNavn.setBackground(Color.blue);
        skrivNavn.setBorder(BorderFactory.createLineBorder(Color.black));
        skrivNavn.setForeground(Color.white);
        skrivNavn.setFont(normalfont);
        skrivNavnPanel.add(skrivNavn);



        enterKnappPanel = new JPanel();
        enterKnappPanel.setBounds(500, 350, 300, 150);
        enterKnappPanel.setBackground(Color.black);
        window.add(enterKnappPanel);

        enterKnapp = new JButton("Enter");

        enterKnapp.setBackground(Color.black);
        enterKnapp.setForeground(Color.white);
        enterKnapp.setFont(normalfont);
        enterKnapp.setFocusPainted(false);
        enterKnapp.addActionListener(cHandler);
        enterKnapp.setActionCommand("enter");
        enterKnappPanel.add(enterKnapp);


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



        valg1 = new JButton("Valg1");
        valg1.setBackground(Color.black);
        valg1.setForeground(Color.white);
        valg1.setFont(normalfont);
        valg1.setFocusPainted(false);
        valg1.addActionListener(cHandler);
        valg1.setActionCommand("v1");
        choiceButtonPanel.add(valg1);

        valg2 = new JButton("Valg2");
        valg2.setBackground(Color.black);
        valg2.setForeground(Color.white);
        valg2.setFont(normalfont);
        valg2.setFocusPainted(false);
        valg2.addActionListener(cHandler);
        valg2.setActionCommand("v2");
        choiceButtonPanel.add(valg2);

        valg3 = new JButton("Valg3");
        valg3.setBackground(Color.black);
        valg3.setForeground(Color.white);
        valg3.setFont(normalfont);
        valg3.setFocusPainted(false);
        valg3.addActionListener(cHandler);
        valg3.setActionCommand("v3");
        choiceButtonPanel.add(valg3);

        valg4 = new JButton("Valg4");
        valg4.setBackground(Color.black);
        valg4.setForeground(Color.white);
        valg4.setFont(normalfont);
        valg4.setFocusPainted(false);
        valg4.addActionListener(cHandler);
        valg4.setActionCommand("v4");
        choiceButtonPanel.add(valg4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setForeground(Color.white);
        playerPanel.setLayout(new GridLayout(1, 7));
        window.add(playerPanel);




        navnLabel = new JLabel("Navn:");
        navnLabel.setFont(normalfont);
        navnLabel.setForeground(Color.white); 
        playerPanel.add(navnLabel);

        navnLabelInnhold = new JLabel();
        navnLabelInnhold.setFont(normalfont);
        navnLabelInnhold.setForeground(Color.white);
        playerPanel.add(navnLabelInnhold);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalfont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpNumberLabel = new JLabel();
        hpNumberLabel.setFont(normalfont);
        hpNumberLabel.setForeground(Color.white);
        playerPanel.add(hpNumberLabel);

        weaponLabel = new JLabel("Wpn:");
        weaponLabel.setFont(normalfont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponTypeLabel = new JLabel();
        weaponTypeLabel.setFont(normalfont);
        weaponTypeLabel.setBackground(Color.black);
        weaponTypeLabel.setForeground(Color.white);
        playerPanel.add(weaponTypeLabel);

        save = new JButton("Save");
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.setFont(normalfont);
        save.setFocusPainted(false);
        save.addActionListener(cHandler);
        save.setActionCommand("save");
        playerPanel.add(save);

        currentPosition = new JLabel();
        currentPosition.setFont(normalfont);
        currentPosition.setBackground(Color.black);
        currentPosition.setForeground(Color.white);


        




        window.setVisible(true);
        
              //Setter det navnet du skrev inn som navn 
             
              enterKnapp.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent e) 
                {


                        

                    navn = skrivNavn.getText();
                    navnLabelInnhold.setText(navn);
                
                    
                    String savedName = UI.navnLabelInnhold.getText();
                    String savedHp = UI.hpNumberLabel.getText();

                    savedName = Database.Navn;
                    savedHp = Database.Hp;
                    System.out.println(savedName + "Det her er tesrt");
                    
                
            }
            });


           
    }




}
