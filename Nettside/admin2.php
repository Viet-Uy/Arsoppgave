<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Årsoppgave</title>
    <?php
 include 'includes/adminchecker.inc.php'; 
 ?>
</head>
<body class="adminBody">
  <div class="webcontainer">
  <div class="tableDiv">
  <table class="adminTable">
    <tr >
      <th>Id</th>
      <th>Name</th>
      <th>Hp</th>
      <th>Weapon</th>
      <th>Position</th> 
    </tr>
    <?php

        $dbc = mysqli_connect('10.2.2.24', 'arsoppgavelinux', 'databaseBruker', 'Arsoppgave')
        or die('Error connecting to MySQL server.');

        $sqlOppg = "SELECT * FROM Arsoppgave;";
        $resultOppg = $dbc-> query($sqlOppg);

        $sqlOppg = "SELECT * FROM Arsoppgave;";
        $resultOppg = $dbc-> query($sqlOppg);
        while($row = $resultOppg -> fetch_assoc()){
            echo "
            
            <tr>
                <td>".$row['id']."</td>
                <td>".$row['navn']."</td>
                <td>".$row['hp']."</td>
                <td>".$row['wpn']."</td>
                <td>".$row['position']."</td>
            </tr>
            ";
        }
        ?>

</table>
</body>
</html>