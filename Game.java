import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;

//import TestArsoppgave.Game.ChoiceHandler;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();
    
    UI ui = new UI();
    public static void main(String[] args) {

        new Game();


    }

    public Game(){

        ui.createUI(cHandler);

    }

    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            //createGameScreen();
        }
    }


}
