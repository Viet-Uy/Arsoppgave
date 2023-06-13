import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            //Hente inn fra databasefunksjon
        try{
            story.BedRoom();
            Connection con = getConnection();
            
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
                System.out.println(Position);

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
        }catch(Exception e){System.out.println(e);}
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
            
            PreparedStatement posted = con.prepareStatement("INSERT INTO Arsoppgave (navn, hp, wpn, position) VALUES ('"+navn+"','"+hp+"','"+wpn+"' ,'"+position.trim()+"')");
            
            posted.executeUpdate();//Brukes istedenfor executeQuery fordi manipulere/legger til informasjon

        } catch(Exception e){System.out.println(e);}

    }

    public static void createTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Arsoppgave(id int NOT NULL AUTO_INCREMENT, navn varchar(255), hp int(255), wpn varchar(255), position varchar(255), PRIMARY KEY(id))");
            create.executeUpdate();
        }catch(Exception e){System.out.println(e);}
}


    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://10.2.2.24:3306/Arsoppgave"; //Hvor databasen er
            String username = "arsoppgavelinux";
            String password = "databaseBruker";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url,username,password);

            return conn; //Returnerer om det funker, hvis ikke return null
        }catch(Exception e) {System.out.println(e);};

        return null;
    }


}
