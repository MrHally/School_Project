﻿<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    $ten=trim($_POST['ten']);
    $ten=str_replace("'","&#39;",$ten);
    $gia=trim($_POST['gia']);
    $trang_chu=$_POST['trang_chu'];
    $noi_bat=$_POST['noi_bat'];
    $noi_dung=$_POST['noi_dung'];
    $noi_dung=str_replace("'","&#39;",$noi_dung);
    $ten_file_anh_tai_len=$_FILES['hinh_anh']['name'];
    if($ten_file_anh_tai_len!="")
    {
        $ten_file_anh=$ten_file_anh_tai_len;
    }
    else
    {
        $ten_file_anh=$_POST['ten_anh'];
    }
    $id=$_GET['id'];
    if($ten!="")
    {
        $tv_1=mysqli_query($tv,"select count(*) from phu_kien where hinh_anh='$ten_file_anh' ");
        $tv_k_2=mysqli_fetch_array($tv_1);
        if($tv_k_2[0]==0 or $ten_file_anh_tai_len=="")
        {
            mysqli_query($tv,"
            UPDATE phu_kien SET
            ten = '$ten',
            gia = '$gia',
            hinh_anh = '$ten_file_anh',
            noi_dung = '$noi_dung',
            trang_chu = '$trang_chu',
            noi_bat = '$noi_bat'
            WHERE id =$id;
            ");
         
            if($ten_file_anh_tai_len!="")
            {             
                $duong_dan_anh="../hinh_anh/phu_kien/".$ten_file_anh_tai_len;
                move_uploaded_file($_FILES['hinh_anh']['tmp_name'],$duong_dan_anh);
                $duong_dan_anh_cu="../hinh_anh/phu_kien/".$_POST['ten_anh'];
                unlink($duong_dan_anh_cu);
            }
             
        }
        else
        {
            thong_bao_html("Hình ảnh bị trùng tên");
        }
    }
    else
    {
        thong_bao_html("Tên sản phẩm chưa được điền vào");
    }
?>