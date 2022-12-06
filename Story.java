import WeaponFil.Fist;
import EnemyFil.Enemy;
import EnemyFil.Woman;
import WeaponFil.Knife;

public class Story{
    Game game;
    UI ui;
    SkjermVisning sv;
    Player player;
    Enemy enemy;
    static String position;
    
    

    public Story(Game g, UI userInterface, SkjermVisning sVisning, Player p){

        game = g;
        ui = userInterface;
        sv = sVisning;
        player = p;

        //Mesteparten av funksjonene her er repeat kode, BedRoom funksjonen skal brukes som et referanse på hva de ulike linjene gjør. De andre funksjonene har samme funksjonalitet

    }

    public void BedRoom(){


            //Main text, her skriver du inn storyen og hva brukeren burde få vite
            ui.mainTextArea.setText("You woke up in a strange house\n what do you want to do?");

            //Første option
            ui.valg1.setText("Go to the locked window");
            //Andre option
            ui.valg2.setText("Search the room");
            //Tredje option
            ui.valg3.setText("Go back to sleep");
            //Fjerde option
            ui.valg4.setText("");
    
            //Hvor første valget tar oss
            game.nextPosition1 = "lockedWindow";
            //Hvor andre valget tar oss
            game.nextPosition2 = "searchRoom";
            //Hvor tredje valget tar oss
            game.nextPosition3 = "goSleep";
             //Hvor fjerde valget tar oss
            game.nextPosition4 = "";
    
            //Posisjon lagres lik case navnet så det er mulig å importe saved data inn i selectPosition. Dette gjør at du kan komme tilbake til der du opprinnelig var når du savet gamet.
            position = "backBedRoom";

    
    
        }
        
 
    public void selectPosition(String nextPosition){
        switch(nextPosition.trim()){
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
            case "rewardKnife": rewardKnife();break;
            case "goOutDoor": goOutDoor();break;
            
            
            case "goSleep": goSleep(); break;
            case "goSleepAgain":goSleepAgain(); break;
        }
    }


    public void defaultSetup(){
        
        //Default setup for spilleren, hvor mye hp personen har og hva slags våpen de starter med.
        player.hp = 15;
        UI.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new Fist();
        
        UI.weaponTypeLabel.setText(player.currentWeapon.wName);

        //Henter inn en fiende, hp og navn. 
        player.currentFiend = new Woman();


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

        position = "searchRoom";
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

        position = "goSleep";

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

        position = "BedDoor";
    }

    public void goSleepAgain(){

        ui.mainTextArea.setText("You get dissected in your sleep and die...");
        ui.valg1.setText("");
        ui.valg2.setText("");
        ui.valg3.setText("");
        ui.valg4.setText("");
        
        game.nextPosition1 = "";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        position = "goSleepAgain";
    }
    public void goHouseStair(){


        ui.mainTextArea.setText(" 'You've slept for a long time! I've made some mush, do you want some?' \n \n " + player.currentFiend.EnemyName + ": "+ player.currentFiend.EnemyHealth + " hp");
        ui.valg1.setText("Yes please!");
        ui.valg2.setText("Who are you?");
        ui.valg3.setText("Punch her");
        ui.valg4.setText("");
        
        game.nextPosition1 = "takeFood";
        game.nextPosition2 = "whoYouLady";
        game.nextPosition3 = "fight";
        game.nextPosition4 = "";

        position = "goHouseStair";

    }

    public void takeFood(){

        //Gjør det mulig å bare heale 1 gang og ikke flere.
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

        position = "takeFood";

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

        position = "whoYouLady";

    }

    public void YouPunchLady(){
        //Random damage
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        player.currentFiend.EnemyHealth = player.currentFiend.EnemyHealth - playerDamage;

        //Gjør at det ikke går under 0
        if(player.currentFiend.EnemyHealth<0){
            player.currentFiend.EnemyHealth = 0;
        
        }
        ui.mainTextArea.setText("The enemy took " + playerDamage + " damage! \n \n" + player.currentFiend.EnemyName + ": " + player.currentFiend.EnemyHealth + " hp");


        ui.valg1.setText(">");
        ui.valg2.setText("");
        ui.valg3.setText("");
        ui.valg4.setText("");


        //Om de fortsatt er i live, attack
        if(player.currentFiend.EnemyHealth>0){
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    
        }
        //Om de er død, gå til winning screen/neste story
        else if(player.currentFiend.EnemyHealth<1){
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    
        }

        position = "YouPunchLady";
    }

    public void LadyPunchYou(){
        //Enemy random damage
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

        position = "LadyPunchYou";
    }




        public void win(){

            ui.mainTextArea.setText("You've defeated " + player.currentFiend.EnemyName + "!");

            ui.valg1.setText(">");
            ui.valg2.setText("");
            ui.valg3.setText("");
            ui.valg4.setText("");

            game.nextPosition1 = "rewardKnife";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    
        position = "win";

        }

        public void lose(){

            ui.mainTextArea.setText("You lose!");
            
            ui.valg1.setText("");
            ui.valg2.setText("");
            ui.valg3.setText("");
            ui.valg4.setText("");

            game.nextPosition1 = "";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
    
            position = "lose";
        }

        public void rewardKnife(){

            ui.mainTextArea.setText("You obtained a knife!");
            
            ui.valg1.setText(">");
            ui.valg2.setText("");
            ui.valg3.setText("");
            ui.valg4.setText("");

            game.nextPosition1 = "goOutDoor";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

            player.currentWeapon = new Knife();
            UI.weaponTypeLabel.setText(player.currentWeapon.wName);
            System.out.println(player.currentWeapon.damage);

            position = "rewardKnife";
            
        }

        public void goOutDoor(){

            ui.mainTextArea.setText("You open the door and proceed outdoor, you face three ways. Which way do you want to go?");
            
            ui.valg1.setText("Left");
            ui.valg2.setText("Middle");
            ui.valg3.setText("Right");
            ui.valg4.setText("");

            game.nextPosition1 = "leftRoad";
            game.nextPosition2 = "middleRoad";
            game.nextPosition3 = "rightRoad";
            game.nextPosition4 = "";


    
            position = "goOutDoor";


        }

        public void leftRoad(){

            ui.mainTextArea.setText("left road");
            
            ui.valg1.setText("Left");
            ui.valg2.setText("Middle");
            ui.valg3.setText("Right");
            ui.valg4.setText("");

            game.nextPosition1 = "leftRoad";
            game.nextPosition2 = "middleRoad";
            game.nextPosition3 = "rightRoad";
            game.nextPosition4 = "";


    
            position = "goOutDoor";

        }

        public void middleRoad(){
            ui.mainTextArea.setText("middle road");
            
            ui.valg1.setText("Left");
            ui.valg2.setText("Middle");
            ui.valg3.setText("Right");
            ui.valg4.setText("");

            game.nextPosition1 = "leftRoad";
            game.nextPosition2 = "middleRoad";
            game.nextPosition3 = "rightRoad";
            game.nextPosition4 = "";


    
            position = "goOutDoor";
        }

        public void rightRoad(){
            ui.mainTextArea.setText("right road");
            
            ui.valg1.setText("Left");
            ui.valg2.setText("Middle");
            ui.valg3.setText("Right");
            ui.valg4.setText("");

            game.nextPosition1 = "leftRoad";
            game.nextPosition2 = "middleRoad";
            game.nextPosition3 = "rightRoad";
            game.nextPosition4 = "";


    
            position = "goOutDoor";
        }
}
