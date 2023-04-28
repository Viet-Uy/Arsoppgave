<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" >
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
            include 'includes/adminmenutekst.inc.php';

        }else if($adminChecker == 0){
            include 'includes/menu.inc.php';
            include 'includes/menutekst.inc.php';
        }
    }
    ?>


<script src="script.js"></script>
</body>
</html>