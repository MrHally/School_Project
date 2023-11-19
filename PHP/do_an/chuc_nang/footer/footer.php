<?php
    $tv = mysqli_connect("localhost","root","","ban_hang");
    mysqli_query($tv,'SET NAMES "UTF8"');
    $tv_1=mysqli_query($tv,"select * from footer limit 0,1");
    $tv_2=mysqli_fetch_array($tv_1);
    echo $tv_2['html'];
?>