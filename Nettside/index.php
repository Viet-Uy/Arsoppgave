<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <meta charset="utf-8">
        <title>PHP Innlogging</title>
    </head>
    <body>
        <div id="login">
        <h1>Vennligst logg inn:</h1>
        <form method="post" action="includes/login.inc.php">
            <label for="brukernavn">Brukernavn:</label>
            <input type="text" name="brukernavn" /><br />
            <label for="passord">Passord:</label>
            <input type="password" name="passord" /><br /> 
            <br>
            <input type="submit" name="submit"/>
        </form>
        <p>Klikk <a href="registration.php">her</a> for å registrere ny bruker            
        </div>
    </body>
   
</html>