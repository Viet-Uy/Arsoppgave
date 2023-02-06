<?php
echo("hei");
 if(isset($_POST['submit'])){
    echo("submit");
     //Gjøre om POST-data til variabler
     $brukernavn = $_POST['brukernavn'];
     $passord = $_POST['passord'];
     
     echo "</br>";
     echo $brukernavn;
     echo "</br>";
     echo $passord;
     //Koble til databasen
     $dbc = mysqli_connect('10.2.2.23', 'arsoppgavelinux', 'databaseBruker', 'Arsoppgave')
       or die('Error connecting to MySQL server.');
     
 
     //Gjøre klar SQL-strengen
     $query = "SELECT brukernavn, passord from users where brukernavn='$brukernavn'";
     
     //Utføre spørringen
     $result = mysqli_query($dbc, $query)
       or die('Error querying database.');
     
    if($result -> num_rows > 0){
        while ($row = $result -> fetch_assoc()){
            echo "</br>";
            print_r($row);
            $dbPwd = $row['passord'];
            $checkedPwd = password_verify($passord, $dbPwd);
            if($checkedPwd === true){
                //hvis brukernavn finnes og passord er riktig
                header("location: ../success.html");
            } else {
                //hvis brukernavn finnes og passord er ikke riktig

                header("location: ../failure.html");
            }
        }
    } else {
        //Hvis brukernavn ikke finnes
        header("location: ../index.php?FeilBrukernavn");
    }  
     //Koble fra databasen
}