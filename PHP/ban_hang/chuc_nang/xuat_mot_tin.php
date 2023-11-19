<?php
    $tv = mysqli_connect("localhost","root","","ban_hang");
    mysqli_query($tv,'SET NAMES "UTF8"');
    $id=$_GET['id'];
    $tv_1=mysqli_query($tv,"select * from menu_ngang where id='$id'");
    $tv_2=mysqli_fetch_array($tv_1);
    echo "<h1>";
        echo $tv_2['ten'];
    echo "</h1>";
    echo $tv_2['noi_dung'];
?>