import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.jar.Attributes.Name;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();
    
    UI ui = new UI();
    SkjermVisning sv = new SkjermVisning(this, ui);
    Story story = new Story(this, ui, sv);
    Database database = new Database(story);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4, newName;

    public static void main(String[] args) throws Exception  {
        new Game();

        Database.getConnection();
        Database.createTable();
        
        

    }

    public Game() throws Exception{


        ui.createUI(cHandler);
        story.defaultSetup();
        sv.visStartSkjerm();
        



    }

    public void Save() throws Exception{
        database.post();
        ui.save.setText("Saved");


    }


    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch(yourChoice){
                case "start":sv.SignIn(); break;
                case "enter":sv.visSpillSkjerm();database.getDb(); /*story.BedRoom();*/ break;
                case "v1":story.selectPosition(nextPosition1); break;
                case "v2":story.selectPosition(nextPosition2); break;
                case "v3":story.selectPosition(nextPosition3); break;
                case "v4":story.selectPosition(nextPosition4); break;
                case "save":try {
                        Save();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } break;

                
            }
         
        }
    }


}
