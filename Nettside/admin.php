<?php 
    session_start();
    if(isset($_SESSION['admin'])){
        $adminChecker = $_SESSION['admin'];
        if(!$adminChecker == 1){
            header("location: registration.php");
        }
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Årsoppgavee</title>
</head>

<?php  
include 'includes/adminchecker.inc.php';
?>


<body class="adminBody">
  <div class="searchBarDiv">
  
  

  </div>

  <div class="webcontainer">
  <div class="tableDiv">
  <table class="adminTable">
    <tr>
      <th>User ID</th>
      <th>User Name</th>
      <th>Password</th>
      <th>User Admin</th>
    </tr>
    <?php
    
    include 'includes/connect.inc.php';

        $sqlUser = "SELECT * FROM nettside;";
        $resultUser = $dbc-> query($sqlUser);


        while($row = $resultUser -> fetch_assoc()){
            echo "
            <tr>
                <td>".$row['id']."</td>
                <td>".$row['brukernavn']."</td>
                <td>".$row['passord']."</td>
                <td>".$row['admin']."</td>
            </tr>
            ";

            

        }
        ?>
        

</table>
</body>
</html>

<!--  -->
