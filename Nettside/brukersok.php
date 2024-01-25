<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Årsoppgave</title>
</head>
<body>
    <?php  
    session_start();
  
    if(isset($_SESSION['admin'])){
        $adminChecker = $_SESSION['admin'];
        if($adminChecker == 1){
            include 'includes/adminmenu.inc.php';

        }else if($adminChecker == 0){
            include 'includes/menu.inc.php';
        }
    }
    ?>

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
        include 'includes/connect.inc.php';


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