<?php
    $tv = mysqli_connect("localhost","root","","ban_hang");
    mysqli_query($tv,'SET NAMES "UTF8"');
    $tv_1=mysqli_query($tv,"select * from banner limit 0,1");
    $tv_2=mysqli_fetch_array($tv_1);
    $link_hinh="anh/banner/".$tv_2['hinh'];  
    echo "<img src='".$link_hinh."' width='".$tv_2['rong']."' height='".$tv_2['cao']."' >";
?>