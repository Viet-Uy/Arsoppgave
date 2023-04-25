<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<div id="menu">
    <div><button class="menyKnapp" onclick="location.href='faq.php'">FAQ</button></div>
    <div><button class="menyKnapp" onclick="location.href='failure.html'">Bruker</button></div>
    <div><button class="menyKnapp" onclick="location.href='failure.html'">Hei</button></div>
    <div><a href="includes/logout.inc.php">Logout </a>  </div>
    </div>

<h1>Søk etter en bruker</h1>



  <div class="searchBarDiv">
    <form action="" method="GET">
      <input type="text" name="search" placeholder="Search for a user" class="searchBar" id="searchInput">
      <button type="submit" class="searchButton">Search</button>
    </form>
  </div>
  <div class="webcontainer">
  <div class="tableDiv">
  <table class="adminTable">
    <tr>
      <th>Name</th>
      <th>Hp</th>
      <th>Weapon</th>
      <th>Position</th>

    </tr>
    <?php

        $dbc = mysqli_connect('10.2.2.23', 'arsoppgavelinux', 'databaseBruker', 'Arsoppgave')
        or die('Error connecting to MySQL server.');

        $sqlOppg = "SELECT * FROM Arsoppgave;";
        $resultOppg = $dbc-> query($sqlOppg);

        $sqlOppg = "SELECT * FROM Arsoppgave;";
        $resultOppg = $dbc-> query($sqlOppg);
        while($row = $resultOppg -> fetch_assoc()){
            echo "
            
            <tr>
                <td>".$row['navn']."</td>
                <td>".$row['hp']."</td>
                <td>".$row['wpn']."</td>
                <td>".$row['position']."</td>
            </tr>
            ";
        }
        ?>
    
</body>
</html>