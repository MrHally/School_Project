<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    $id=$_GET['id'];
    $tv_1=mysqli_query($tv,"select count(*) from san_pham where thuoc_menu='$id' ");
    $tv_2=mysqli_fetch_array($tv_1);
    if($tv_2[0]==0)
    {
        mysqli_query($truy_van_xoa,"DELETE FROM menu_doc WHERE id = $id ");
    }
    else
    {
        thong_bao_html("Menu này vẫn còn dữ liệu nên không thể xóa");
    }
?>