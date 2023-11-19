<?php
    $tv = mysqli_connect("localhost","root","","ban_hang");
    mysqli_query($tv,'SET NAMES "UTF8"');
    session_start();
    $bien_bao_mat="co";
    include("ket_noi_quan_tri.php");  
    include("chuc_nang/quan_tri_2/xac_dinh_dang_nhap.php");
    include("chuc_nang/quan_tri_2/ham.php");
    if(isset($xac_dinh_dang_nhap))
    {
        if($xac_dinh_dang_nhap=="co")
        {
            include("chuc_nang/quan_tri_2/xu_ly_post_get.php");
        }   
    }
?>
<html>
        
    <body>
        <?php
            if(!isset($xac_dinh_dang_nhap))
            {
                include("chuc_nang/quan_tri_2/khung_dang_nhap.php");
            }
            else
            {
                if($xac_dinh_dang_nhap=="co")
                {
                    include("chuc_nang/quan_tri_2/trang_chu.php");
                }
            }
        ?>
    </body>
</html>