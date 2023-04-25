<?php
    session_start();
    if(isset($_SESSION['admin'])){
        $adminChecker = $_SESSION['admin'];
        if(!$adminChecker == 1){
            header("location: registration.php");
        }else{
            header("location: admin.php");
        }
    }else{
        header("location: registration.php");
    }
?>