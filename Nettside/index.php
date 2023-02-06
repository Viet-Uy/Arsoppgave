<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <meta charset="utf-8">
        <title>PHP Innlogging</title>
    </head>
    <body>
        <p>Vennligst logg inn:</p>
        <form method="post" action="includes/login.inc.php">
            <label for="brukernavn">Brukernavn:</label>
            <input type="text" name="brukernavn" /><br />
            <label for="passord">Passord:</label>
            <input type="password" name="passord" /><br /> 
            <input type="submit" name="submit" />
        </form>
        <p>Eller klikk <a href="registration.php">her</a> for å registrere ny bruker            
    </body>
   
</html>