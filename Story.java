import WeaponFil.Fist;
import EnemyFil.Enemy;
import EnemyFil.onsWoman;

public class Story{
    Game game;
    UI ui;
    SkjermVisning sv;
    Player player = new Player();
    Enemy enemy;
    Database database = new Database();
    static String position;
    
    

    public Story(Game g, UI userInterface, SkjermVisning sVisning, Player p){

        game = g;
        ui = userInterface;
        sv = sVisning;
        player = p;

        

    }
    public void BedRoom(){


			database.getDb();
            
/*           if(Database.Position != null){
                selectPosition(Database.Position);
            }else{
                System.out.println("Uy");
            }
 */

 


            ui.mainTextArea.setText("You woke up in a strange house\n what do you want to do?");
            ui.valg1.setText("Go to the locked window");
            ui.valg2.setText("Search the room");
            ui.valg3.setText("Go back to sleep");
            ui.valg4.setText("");
    
    
            game.nextPosition1 = "lockedWindow";
            game.nextPosition2 = "searchRoom";
            game.nextPosition3 = "goSleep";
            game.nextPosition4 = "";
    

    
    
    
    
            position = "backBedRoom";
    
    
        }
        
 
    public void selectPosition(String nextPosition){
        System.out.println(nextPosition);
        switch(nextPosition){
            //hus story
            case "lockedWindow": lockedWindow(); break;
            case "backBedRoom":BedRoom(); break; 

            case "searchRoom": searchRoom(); break;
            case "goBedDoor": BedDoor(); break;
            case "goStair": goHouseStair(); break;            
            case "takeFood": takeFood(); break;
            case "whoYouLady":whoYouLady(); break;
            case "fight":YouPunchLady(); break;
            case "monsterAttack":LadyPunchYou(); break;
            case "lose": lose(); break;
            case "win": win();break;
            
            
            case "goSleep": goSleep(); break;
            case "goSleepAgain":goSleepAgain(); break;
            case "newGame": sv.visStartSkjerm(); break;
        }
    }


    public void defaultSetup(){
        

        player.hp = 15;
        UI.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new Fist();
        UI.weaponTypeLabel.setText(player.currentWeapon.wName);


    }


    


    

    public void lockedWindow(){

        ui.mainTextArea.setText("You watch out the window, and see nothing but an empty grass field");
        ui.valg1.setText("<");
        ui.valg2.setText("");
        ui.valg3.setText("");
        ui.valg4.setText("");

        game.nextPosition1 = "backBedRoom";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        position = "lockedWindow";
    }

    public void searchRoom(){

        ui.mainTextArea.setText("You search the room and find a note\n \n 'Im waiting downstairs, just get up when you are ready :)' " );
        ui.valg1.setText("<");
        ui.valg2.setText("Go to the door");
        ui.valg3.setText("");
        ui.valg4.setText("");

        game.nextPosition1 = "backBedRoom";
        game.nextPosition2 = "goBedDoor";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void goSleep(){

        ui.mainTextArea.setText("You go back to sleep...");
        ui.valg1.setText("Zzz");
        ui.valg2.setText("");
        ui.valg3.setText("");
        ui.valg4.setText("");


        
        game.nextPosition1 = "goSleepAgain";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void BedDoor(){

        ui.mainTextArea.setText("You walk out the door and enter a oneway hall leading to the main stairs\n \n What do you do?");
        ui.valg1.setText("Walk down the stairs");
        ui.valg2.setText(">");
        ui.valg3.setText("");
        ui.valg4.setText("");

        game.nextPosition1 = "goStair";
        game.nextPosition2 = "backBedRoom";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void goSleepAgain(){

        ui.mainTextArea.setText("You get dissected in your sleep and die...");
        ui.valg1.setText("Start again");
        ui.valg2.setText("");
        ui.valg3.setText("");
        ui.valg4.setText("");
        
        game.nextPosition1 = "newGame";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void goHouseStair(){
        player.currentFiend = new onsWoman();
        ui.mainTextArea.setText(" 'You've slept for a long time! I've made some mush, do you want some?' \n \n " + player.currentFiend.EnemyName + ": "+ player.currentFiend.EnemyHealth + " hp");
        ui.valg1.setText("Yes please!");
        ui.valg2.setText("Who are you?");
        ui.valg3.setText("Punch her");
        ui.valg4.setText("");
        
        game.nextPosition1 = "takeFood";
        game.nextPosition2 = "whoYouLady";
        game.nextPosition3 = "fight";
        game.nextPosition4 = "";

    }

    public void takeFood(){
        player.hp = player.hp + 1;
        if(player.hp >= 16){
            player.hp = 16;
            
        }
        ui.mainTextArea.setText(" You take a spoonfull of mush and eat, you heal 1 hp \n \n" + player.currentFiend.EnemyName + ": "+ player.currentFiend.EnemyHealth + " hp");
        
        UI.hpNumberLabel.setText(" " + player.hp);
        


        ui.valg1.setText(">");
        ui.valg2.setText("");
        ui.valg3.setText("");
        ui.valg4.setText("");
        
        game.nextPosition1 = "goStair";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void whoYouLady(){
        int EnemyDamage = 1;
        player.hp = player.hp - EnemyDamage;
        UI.hpNumberLabel.setText("" + player.hp);

        ui.mainTextArea.setText(" She hit you and you took 1 damage, \n'You pervert!' \n \n  " + player.currentFiend.EnemyName + ": "+ player.currentFiend.EnemyHealth + " hp");
        ui.valg1.setText("Run off");
        ui.valg2.setText("Punch her and run off");
        ui.valg3.setText("Apologise and run off");
        ui.valg4.setText("");
        
        game.nextPosition1 = "";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void YouPunchLady(){
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        player.currentFiend.EnemyHealth = player.currentFiend.EnemyHealth - playerDamage;

        if(player.currentFiend.EnemyHealth<0){
            player.currentFiend.EnemyHealth = 0;
        
        }
        ui.mainTextArea.setText("The enemy took " + playerDamage + " damage! \n \n" + player.currentFiend.EnemyName + ": " + player.currentFiend.EnemyHealth + " hp");


        ui.valg1.setText(">");
        ui.valg2.setText("");
        ui.valg3.setText("");
        ui.valg4.setText("");


        
        if(player.currentFiend.EnemyHealth>0){
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    
        }
        else if(player.currentFiend.EnemyHealth<1){
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    
        }

    }

    public void LadyPunchYou(){
        int EnemyDamage = new java.util.Random().nextInt(player.currentFiend.EnemyDamage);
        player.hp = player.hp - EnemyDamage;

        if(player.hp<0){
            player.hp = 0;
        
        }
        UI.hpNumberLabel.setText("" + player.hp);
        ui.mainTextArea.setText("You took " + EnemyDamage + " damage!");

        ui.valg1.setText(">");
        ui.valg2.setText("");
        ui.valg3.setText("");
        ui.valg4.setText("");

        

        
        if(player.hp>0){
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    
        }
        else if(player.hp<1){
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    
        }

    }





        public void win(){

            ui.mainTextArea.setText("You've defeated " + player.currentFiend.EnemyName + "!");

            ui.valg1.setText(">");
            ui.valg2.setText("");
            ui.valg3.setText("");
            ui.valg4.setText("");

            game.nextPosition1 = "";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    

        }

        public void lose(){

            ui.mainTextArea.setText("You lose!");
            
            ui.valg1.setText("Restart game");
            ui.valg2.setText("");
            ui.valg3.setText("");
            ui.valg4.setText("");

            game.nextPosition1 = "";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    
            
        }


}
