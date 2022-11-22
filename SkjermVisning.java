import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SkjermVisning {

    Game game;
    UI ui;
    SkjermVisning sv;
    Player player;
    

    public SkjermVisning(Game game, UI userInterface){

    ui = userInterface;

    

    }

    public void visStartSkjerm(){

        //Start skjerm
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);
        

        //Hide
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        ui.enterKnappPanel.setVisible(false);

    }

    public void SignIn(){

        //Hide
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        //Hide
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        //Sign in
        ui.mainTextPanelSI.setVisible(true);
        ui.skrivNavnPanel.setVisible(true);
        ui.enterKnappPanel.setVisible(true);

    }

    public void visSpillSkjerm(){


        //Hide
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        ui.mainTextPanelSI.setVisible(false);
        ui.skrivNavnPanel.setVisible(false);
        ui.enterKnappPanel.setVisible(false);

        //Spill SKjerm
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);




    }


}