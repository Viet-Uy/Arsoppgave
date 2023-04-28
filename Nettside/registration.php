
<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <meta charset="utf-8">
        <title>PHP Innlogging</title> 
    </head>
    <body>
        <div id="login">
        <h1>Opprett ny bruker:</h1>
        <form method="post">
            <label for="brukernavn">Brukernavn:</label>
            <input type="text" name="brukernavn" /><br />
            <label for="passord">Passord:</label>
            <input type="password" name="passord" /><br />
        <br>
            <input type="submit" value="Register" name="submit" />
            <input type="submit" value="Back" name="back" />
            </div>
        </form>    
    </body>
    <?php
        if(isset($_POST['submit'])){
            //Gjøre om POST-data til variabler
            $brukernavn = $_POST['brukernavn'];
            $passord = $_POST['passord'];
            
            //Koble til databasen
            $dbc = mysqli_connect('10.2.2.23', 'arsoppgavelinux', 'databaseBruker', 'Arsoppgave')
              or die('Error connecting to MySQL server.');

              $hashedPwd = password_hash($passord, PASSWORD_DEFAULT);
            
            //Gjøre klar SQL-strengen
            $query = "INSERT INTO users (brukernavn, passord) VALUES ('$brukernavn','$hashedPwd')";
            
            //Utføre spørringen
            $result = mysqli_query($dbc, $query)
              or die('Error querying database.');

            //Koble fra databasen
            mysqli_close($dbc);

            //Sjekke om spørringen gir resultater
            if($result){
                //Gyldig login
                echo "Takk for at du lagde bruker! Trykk <a href='index.php'>her</a> for å logge inn";
            }else{
                //Ugyldig login
                echo "Noe gikk galt, prøv igjen!";
            }
        }

        if(isset($_POST['back'])){

            header("Location: index.php");

        }
    ?>
</html>