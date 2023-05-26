<?php
 if(isset($_POST['submit'])){
     //Gjøre om POST-data til variabler
     $brukernavn = $_POST['brukernavn'];
     $passord = $_POST['passord'];
     
     echo "</br>";
     echo $brukernavn;
     echo "</br>";
     echo $passord;
     //Koble til databasen
     $dbc = mysqli_connect('10.2.2.24', 'arsoppgavelinux', 'databaseBruker', 'Arsoppgave')
       or die('Error connecting to MySQL server.');
     
 
     //Gjøre klar SQL-strengen
     $query = "SELECT * from users where brukernavn='$brukernavn'";
     
     //Utføre spørringen
     $result = mysqli_query($dbc, $query)
       or die('Error querying database.');
     
    if($result -> num_rows > 0){
        while ($row = $result -> fetch_assoc()){
            echo "</br>";
            print_r($row);
            $dbPwd = $row['passord'];
            $adminCheck = $row['admin'];
            $brukernavn = $row['brukernavn'];
            session_start();
            $_SESSION['admin'] = $adminCheck;
            $_SESSION['brukernavn'] = $brukernavn;
            $checkedPwd = password_verify($passord, $dbPwd);
            if($checkedPwd === true){
                $userChecker = $_SESSION['brukernavn'];
                //hvis brukernavn finnes og passord er riktig
                header("location: ../bruker.php");
            } else {
                //hvis brukernavn finnes og passord er ikke riktig
                header("location: ../index.php?feil=feilbruker");

                if(isset($_GET["feil"])) {
                echo "<p>Feil passord</p>";
            }

            if(isset($_GET["feil2"])) {
                echo "<p>Feil brukernavn</p>";
            }
            }
        }
    } else {
        //Hvis brukernavn ikke finnes
        header("location: ../index.php?feil2=feilBrukernavn");

    }  
}