<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    $id=$_GET['id'];
 
    $tv_1=mysqli_query($tv,"select * from san_pham where id='$id' ");
    $tv_2=mysqli_fetch_array($tv_1);

    $link_hinh="../anh/san_pham/".$tv_2['hinh_anh'];
    if(is_file($link_hinh)) 
    {
        unlink($link_hinh);
    }
 
    mysqli_query($tv,"DELETE FROM san_pham WHERE id = $id ");
?>