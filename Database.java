import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import WeaponFil.Fist;
import WeaponFil.Knife;
public class Database {
        Story story;
        UI ui;
        Player player;

    //Sender med Story
    public Database(Player p, Story s){
        player = p;
        story = s;
    }

    static String Navn, Hp, Wpn, Position;
        //Lager en resizable array som kan fjerne og legge til elementer
        public ArrayList<String> getDb(){
            

        final String navn = UI.navn;
        final String hp = UI.hpNumberLabel.getText();
        final String wpn = UI.weaponTypeLabel.getText(); 
        final String position = Story.position;


        try{

            Connection con = getConnection();
            
            PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM Arsoppgave WHERE navn = ?" );
            checkStatement.setString(1, navn);

            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0){

                int option = JOptionPane.showOptionDialog(
                null,
                "Dette navnet er allerede tatt og har lagd progresjon allerede, vil du velge et annet navn eller fortsette?",
                "Ops ops",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null,
                new String[]{"Fortsette", "Annet navn"},
                "Hello"

                );

                if (option == JOptionPane.YES_OPTION){
                story.BedRoom();
            
             //Hente navn, hp, våpen, posisjon der navn er det som ble skrevet inn
             PreparedStatement statement = con.prepareStatement("SELECT navn, hp, wpn, position FROM Arsoppgave where navn = '" + UI.navn + "'");
             //Henter inn det vi "selected", vi tar imot informasjon
             ResultSet result = statement.executeQuery();

             //Lager en ny array for å lagre informasjonen. Denne arrayen er det vi skal returnere når vi caller denne funksjonen
             ArrayList<String> array = new ArrayList<String>();
 
            //Så leng det er flere "results" fortsett denne while løkken
             while(result.next()){

                 Navn = result.getString("navn");
                 Hp = result.getString("hp");
                 Wpn = result.getString("wpn");
                 Position = result.getString("position");

            //Setter posisjonen som ble hentet inn som nåværende posisjon
            story.selectPosition(Position);
            UI.navnLabelInnhold.setText(Navn);
            UI.hpNumberLabel.setText(Hp);
            UI.weaponTypeLabel.setText(Wpn);

                                
              switch(Wpn){
                  case "Fist": player.currentWeapon = new Fist();break;
                  case "Knife": player.currentWeapon = new Knife();break;
              }



             }
             return array;
             //Så leng det er flere "results" fortsett denne while løkken
                } else if (option == JOptionPane.NO_OPTION){
                    System.exit(0);
                }


            } else{
                PreparedStatement posted = con.prepareStatement("INSERT INTO Arsoppgave (navn,hp,wpn,position) VALUES (?, ?, ? ,?)");
                posted.setString(1, navn);
                posted.setString(2, hp);
                posted.setString(3, wpn);
                posted.setString(4, position.trim());

                int rowsAffected = posted.executeUpdate();

                if(rowsAffected > 0){
                    System.out.println("Insertion successful!");
                    System.out.println(count);
                } else{
                    System.out.println("Insertion failed");
                }
            }

        } catch(Exception e){System.out.println(e);}

        return null;

    }


    


    //Thows exception fordi det kan skje exceptions, om det skjer så kaster det den løsningen
    public void post() throws Exception{
        final String navn = UI.navn;
        final String hp = UI.hpNumberLabel.getText();
        final String wpn = UI.weaponTypeLabel.getText(); 
        final String position = Story.position;


        try{

            Connection con = getConnection();

            PreparedStatement deleteStatement = con.prepareStatement(
                "DELETE FROM Arsoppgave WHERE navn = ?"
            );
            deleteStatement.setString(1, navn);
            deleteStatement.executeUpdate(); // Execute the delete
            



            PreparedStatement posted = con.prepareStatement("INSERT INTO Arsoppgave (navn, hp, wpn, position) VALUES (?, ?, ?, ?)");
            
            
        // // Set parameters for deletion
        // posted.setString(1, navn);
        // posted.setString(2, hp);
        // posted.setString(3, wpn);
        // posted.setString(4, position.trim());

        // posted.executeUpdate(); // Execute the delete part

        // Now, insert the new record
        posted.setString(1, navn);
        posted.setString(2, hp);
        posted.setString(3, wpn);
        posted.setString(4, position.trim());

        int rowsAffected = posted.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Insertion or update successful!");
        } else {
            System.out.println("No changes were made.");
        }

        // Close resources
        posted.close();

    } catch (Exception e) {
        System.out.println(e);
    }
}
    //         posted.setString(1, navn);
    //         posted.setString(2, hp);
    //         posted.setString(3, wpn);
    //         posted.setString(4, position);
    //         posted.setString(5, position);

    //         posted.executeUpdate();//Brukes istedenfor executeQuery fordi manipulere/legger til informasjon

    //     } catch(Exception e){System.out.println(e);}
    // }

    public static void createTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Arsoppgave(id int NOT NULL AUTO_INCREMENT, navn varchar(255), hp int(255), wpn varchar(255), position varchar(255), PRIMARY KEY(id))");
            create.executeUpdate();
        }catch(Exception e){System.out.println(e);}
}


    public static Connection getConnection() throws Exception{
        try{        
            String url = "jdbc:mysql://localhost:3306/arsoppgave"; //Hvor databasen er
            String username = "arsoppgavebruker";
            String password = "databaseBruker";

            
            Connection conn = DriverManager.getConnection(url,username,password);

            return conn; //Returnerer om det funker, hvis ikke return null
        }catch(Exception e) {System.out.println(e);};

        return null;
    }


}
