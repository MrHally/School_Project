<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    $id=$_GET['id'];
    mysqli_query($tv,"DELETE FROM hoa_don WHERE id = $id ");
?>