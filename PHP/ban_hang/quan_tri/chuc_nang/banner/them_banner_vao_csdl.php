<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    $lien_ket=trim($_POST['lien_ket']);
    $ten_file_anh=$_FILES['hinh_anh']['name'];

    if($ten_file_anh!="")
    {
        $tv_1=mysqli_query($tv,"select count(*) from banner where hinh='$ten_file_anh' ");
        $tv_k_2=mysqli_fetch_array($tv_1);
        if($tv_k_2[0]==0)
        {
            mysqli_query($tv,"
            INSERT INTO banner (
            id ,
            hinh,
            lien_ket
            )
            VALUES (
            NULL ,
            '$ten_file_anh',
            '$lien_ket'
            );");

            $duong_dan_anh="../anh/banner/".$ten_file_anh;
            move_uploaded_file($_FILES['hinh_anh']['tmp_name'],$duong_dan_anh);
        }
        else
        {
            thong_bao_html("Hình ảnh bị trùng tên");
        }
    }
    else
    {
        thong_bao_html("Chưa chọn ảnh");
    }
?>