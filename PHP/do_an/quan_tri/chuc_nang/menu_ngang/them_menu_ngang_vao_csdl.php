﻿<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    $tv = mysqli_connect("localhost","root","","ban_hang");
    mysqli_query($tv,'SET NAMES "UTF8"');
    $ten_menu=trim($_POST['ten']);
    $ten_menu=str_replace("'","&#39;",$ten_menu);
    $loai_menu=$_POST['loai_menu'];
    $noi_dung=$_POST['noi_dung'];
    $noi_dung=str_replace("'","&#39;",$noi_dung);
    if($ten_menu!="")
    {
        mysqli_query($tv,"
        INSERT INTO menu_ngang (
        id ,
        ten ,
        noi_dung ,
        loai_menu
        )
        VALUES (
        NULL ,
        '$ten_menu',
        '$noi_dung',
        '$loai_menu'
        );");
        $_SESSION['loai_menu_wr8']=$loai_menu;
    }
    else
    {
        thong_bao_html("Tên menu chưa được điền vào");
    }
?>