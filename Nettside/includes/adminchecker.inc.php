<?php  
    // Sjekker om session er på eller ikke
    if(session_status() == PHP_SESSION_ACTIVE){
        if(isset($_SESSION['admin'])){
            $adminChecker = $_SESSION['admin'];
            if($adminChecker == 1){
                include 'includes/adminmenu.inc.php';
    
            }else if($adminChecker == 0){
                include 'includes/menu.inc.php';
            }
        }
    }else{
        session_start();
        if(isset($_SESSION['admin'])){
            $adminChecker = $_SESSION['admin'];
            if($adminChecker == 1){
                include 'includes/adminmenu.inc.php';
    
            }else if($adminChecker == 0){
                include 'includes/menu.inc.php';
            }
        }
    }

    ?>