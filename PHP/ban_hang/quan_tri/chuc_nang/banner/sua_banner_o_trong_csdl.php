<?php
    if(!isset($bien_bao_mat)){exit();}
    $id=$_GET['id'];
    $lien_ket=trim($_POST['lien_ket']);
    $ten_file_anh_tai_len=$_FILES['hinh_anh']['name'];
    if($ten_file_anh_tai_len!="")
    {
        $ten_file_anh=$ten_file_anh_tai_len;
    }
    else
    {
        $ten_file_anh=$_POST['ten_anh'];
    }
    $kiem_tra_anh="hop_le";   
    if($ten_file_anh_tai_len!="")
    {
        $tv_1=mysqli_query($tv,"select count(*) from banner where hinh='$ten_file_anh' ");
        $tv_k_2=mysqli_fetch_array($tv_1);
        if($tv_k_2[0]!=0)
        {
            $kiem_tra_anh="khong_hop_le";   
        }
    }
    if($kiem_tra_anh=="hop_le")
    {

        if($ten_file_anh_tai_len!="")
        {               
            $duong_dan_anh="../anh/banner/".$ten_file_anh_tai_len;
            move_uploaded_file($_FILES['hinh_anh']['tmp_name'],$duong_dan_anh);
            $duong_dan_anh_cu="../anh/banner/".$_POST['ten_anh'];
            unlink($duong_dan_anh_cu);
        }       

        mysqli_query($tv,"
        UPDATE banner SET
        hinh = '$ten_file_anh',
        lien_ket = '$lien_ket'
        WHERE id =$id;
        ");   
               

    }
    else
    {
        thong_bao_html("Hình ảnh bị trùng tên");
    }
?>