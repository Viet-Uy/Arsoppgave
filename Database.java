import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Database {
    static String Navn, Hp, Wpn, Position;

        public ArrayList<String> getDb(){

        try{
            
            Connection con = getConnection();
            
            PreparedStatement statement = con.prepareStatement("SELECT navn, hp, wpn, position FROM Arsoppgave where navn = '" + UI.navn + "'");
                System.out.println(UI.navn + " pop");
            ResultSet result = statement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
 
            while(result.next()){

                Navn = result.getString("navn");
                Hp = result.getString("hp");
                Wpn = result.getString("wpn");
                Position = result.getString("position");
                System.out.println(Navn + " " + Hp + " " + Wpn + "" + Position );

                UI.navnLabelInnhold.setText(Navn);
                UI.hpNumberLabel.getText();

                UI.hpNumberLabel.setText(Hp);
    
  

            }

            System.out.println("All records have been selected!");
            return array;
        }catch(Exception e){System.out.println(e);}
        return null;

    }

    public void post() throws Exception{



        final String navn = UI.navn;
        final String hp = UI.hpNumberLabel.getText();
        final String wpn = UI.weaponTypeLabel.getText(); 
        final String position = Story.position;

        try{

            Connection con = getConnection();
            
            PreparedStatement posted = con.prepareStatement("INSERT INTO Arsoppgave (navn, hp, wpn, position) VALUES ('"+navn+"','"+hp+"','"+wpn+"' ,'"+position.trim()+"')");
            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Insert complete");

        }


    }

    public static void createTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS Arsoppgave(id int NOT NULL AUTO_INCREMENT, navn varchar(255), hp int(255), wpn varchar(255), position varchar(255), PRIMARY KEY(id))");
            create.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        finally{
            System.out.println("Function complete.");
       
        };
}


    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testuy";
            String username = "arsoppgave";
            String password = "uyerdeilig123";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        }catch(Exception e) {System.out.println(e);};

        return null;
    }


}
