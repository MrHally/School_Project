<?php
    if(isset($_GET['thamso']))
    {$tham_so=$_GET['thamso'];}
    else
    {$tham_so="";}
    switch($tham_so)
    {
        case "trang_moi":
            include("chuc_nang/san_pham/trang_moi.php");
        break;
        case "trang_noi_bat":
            include("chuc_nang/san_pham/trang_noi_bat.php");
        break;
        case "xuat_san_pham":
            echo "<center><img style='width: 75%; margin-bottom: 10px;' src='../../anh/slideshow/a-4.png' alt='' srcset=''></center>";
            include("chuc_nang/menu_doc/menu_doc.php");
            include("chuc_nang/san_pham/xuat.php");
        break;
        case "xuat_phu_kien":
            echo "<center><img style='width: 75%; margin-bottom: 10px;' src='../../anh/slideshow/a-5.png' alt='' srcset=''></center>";
            include("chuc_nang/menu_doc/menu_doc_pk.php");
            include("chuc_nang/san_pham/xuat_pk.php");
        break;
        case "chi_tiet_san_pham":
            include("chuc_nang/san_pham/chi_tiet_san_pham.php");
        break;
        case "chi_tiet_phu_kien":
            include("chuc_nang/san_pham/chi_tiet_phu_kien.php");
        break;
        case "xuat_san_pham_2":
            echo "<center><img style='width: 75%; margin-bottom: 10px;' src='../../anh/slideshow/a-6.png' alt='' srcset=''></center>";
            include("chuc_nang/menu_doc/menu_doc.php");
            include("chuc_nang/san_pham/xuat_toan_bo_san_pham.php");
        break;
        case "xuat_phu_kien_2":
            echo "<center><img style='width: 75%; margin-bottom: 10px;' src='../../anh/slideshow/a-7.png' alt='' srcset=''></center>";
            include("chuc_nang/menu_doc/menu_doc_pk.php");
            include("chuc_nang/san_pham/xuat_toan_bo_phu_kien.php");
        break;
        case "xuat_mot_tin":
            include("chuc_nang/xuat_mot_tin.php");
        break;
        case "tim_kiem":
            include("chuc_nang/tim_kiem/xuat_san_pham_tim_kiem.php");
        break;
        case "gio_hang":
            include("chuc_nang/gio_hang/gio_hang.php");
        break;
        
        default:
        echo "<center>";
            include("chuc_nang/slideshow/slideshow.php");
            include("chuc_nang/san_pham/noi_bat.php");
            include("chuc_nang/san_pham/moi.php");
            include("chuc_nang/san_pham/san_pham_trang_chu.php");
            echo "</center>";
    }
?>