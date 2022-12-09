import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    //Choicehandler, det som håndterer valgene
    ChoiceHandler cHandler = new ChoiceHandler();
    
    UI ui = new UI();
    SkjermVisning sv = new SkjermVisning(this, ui);
    Player player = new Player();
    Story story = new Story(this, ui, sv, player);
    Database database = new Database(player, story);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4, newName;
    Boolean button_clicked = false;

    public static void main(String[] args) throws Exception  {
        new Game();

        //Kobling og lage tabell om det ikke finnes
        Database.getConnection();
        Database.createTable();
        
        

    }

    public Game() throws Exception{

        //Sender med choic handler og lager startskjerm, default setup og UI
        ui.createUI(cHandler);
        story.defaultSetup();
        sv.visStartSkjerm();
        



    }

    public void Save() throws Exception{

            if(button_clicked){
                return;
            }else{

                database.post();
                ui.save.setText("Saved");
                button_clicked = true;
            }





    }


    //Choice handler implementerer ActionListener, gjør det mulig å høre etter hva slags valg de tar
    public class ChoiceHandler implements ActionListener{

        //ActionEvent er en klasse der event er en forekomst. På innsiden av actionperfomed kan du call hva som helst, blant annet event.getActionCommand()
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            
            //yourChoice byttes ut med valg1-4 og dermed sendes den videre til Story. Story bestemmer så hva slags funksjoner skal bli kalt
            switch(yourChoice){
                case "start":sv.SignIn(); break;
                case "enter":sv.visSpillSkjerm();database.getDb(); break;
                case "v1":story.selectPosition(nextPosition1); break;
                case "v2":story.selectPosition(nextPosition2); break;
                case "v3":story.selectPosition(nextPosition3); break;
                case "v4":story.selectPosition(nextPosition4); break;
                //Enten kjører save funksjonen ellers printes en feilmelding.
                case "save":try {Save();} 
                catch (Exception e) {
                    e.printStackTrace();
                } break;

                
            }
         
        }
    }


}
