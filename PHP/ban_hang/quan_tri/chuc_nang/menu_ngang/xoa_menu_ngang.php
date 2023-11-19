<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    $id=$_GET['id'];
    mysqli_query($tv,"DELETE FROM menu_ngang WHERE id = $id ");
?>