<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    $id=$_GET['id'];
 
    $tv_1=mysqli_query($tv,"select * from phu_kien where id='$id' ");
    $tv_2=mysqli_fetch_array($tv_1);

    $link_hinh="../anh/phu_kien/".$tv_2['hinh_anh'];
    if(is_file($link_hinh)) 
    {
        unlink($link_hinh);
    }
 
    mysqli_query($tv,"DELETE FROM phu_kien WHERE id = $id ");
?>