<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" >
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<?php
include 'includes/menu.inc.php';
?>




    <?php
    session_start();
  
    if(isset($_SESSION['admin'])){
        $adminChecker = $_SESSION['admin'];
        if($adminChecker == 1){
            echo "<a href='admin.php'>Admin Page</a>";
        }else if($adminChecker == 0){
            echo "<a href='brukersok.php'>Bruker</a>";
        }
    }
    ?>


<script src="script.js"></script>
</body>
</html>