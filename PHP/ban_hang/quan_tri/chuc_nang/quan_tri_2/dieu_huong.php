<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    if(!isset($_GET['thamso'])){$thamso="";}else{$thamso=$_GET['thamso'];}
   
    switch($thamso)
    {
        case "menu_ngang":
            include("chuc_nang/menu_ngang/lien_ket_menu_ngang.php");
        break;
        case "them_menu_ngang":
            include("chuc_nang/menu_ngang/them_menu_ngang.php");
        break;
        case "quan_ly_menu_ngang":
            include("chuc_nang/menu_ngang/quan_ly_menu_ngang.php");
        break;
        case "sua_menu_ngang":
            include("chuc_nang/menu_ngang/sua_menu_ngang.php");
        break;
        case "menu_doc":
            include("chuc_nang/menu_doc/lien_ket_menu_doc.php");
        break;
        case "them_menu_doc":
            include("chuc_nang/menu_doc/them_menu_doc.php");
        break;
        case "quan_ly_menu_doc":
            include("chuc_nang/menu_doc/quan_ly_menu_doc.php");
        break;
        case "sua_menu_doc":
            include("chuc_nang/menu_doc/sua_menu_doc.php");
        break;
        case "san_pham":
            include("chuc_nang/san_pham/lien_ket_san_pham.php");
        break;
        case "them_san_pham":
            include("chuc_nang/san_pham/them_san_pham.php");
        break;
        case "quan_ly_san_pham":
            include("chuc_nang/san_pham/quan_ly_san_pham.php");
        break;
        case "sua_san_pham":
            include("chuc_nang/san_pham/sua_san_pham.php");
        break;
        case "phu_kien":
            include("chuc_nang/phu_kien/lien_ket_phu_kien.php");
        break;
        case "them_phu_kien":
            include("chuc_nang/phu_kien/them_phu_kien.php");
        break;
        case "quan_ly_phu_kien":
            include("chuc_nang/phu_kien/quan_ly_phu_kien.php");
        break;
        case "sua_phu_kien":
            include("chuc_nang/phu_kien/sua_phu_kien.php");
        break;
        case "hoa_don":
            include("chuc_nang/hoa_don/quan_ly_hoa_don.php");
        break;
        case "xem_hoa_don":
            include("chuc_nang/hoa_don/xem_hoa_don.php");
        break;
        case "san_pham_trang_chu":
            include("chuc_nang/san_pham_trang_chu/san_pham_trang_chu.php");
        break;
        case "san_pham_noi_bat":
            include("chuc_nang/san_pham_noi_bat/san_pham_noi_bat.php");
        break;
        case "phu_kien_trang_chu":
            include("chuc_nang/phu_kien_trang_chu/phu_kien_trang_chu.php");
        break;
        case "phu_kien_noi_bat":
            include("chuc_nang/phu_kien_noi_bat/phu_kien_noi_bat.php");
        break;
        case "slideshow":
            include("chuc_nang/slideshow/lien_ket_slideshow.php");
        break;
        case "them_slideshow":
            include("chuc_nang/slideshow/them_slideshow.php");
        break;
        case "quan_ly_slideshow":
            include("chuc_nang/slideshow/quan_ly_slideshow.php");
        break;
        case "sua_slideshow":
            include("chuc_nang/slideshow/sua_slideshow.php");
        break;
        case "banner":
            include("chuc_nang/banner/lien_ket_banner.php");
        break;
        case "them_banner":
            include("chuc_nang/banner/them_banner.php");
        break;
        case "quan_ly_banner":
            include("chuc_nang/banner/quan_ly_banner.php");
        break;
        case "sua_banner":
            include("chuc_nang/banner/sua_banner.php");
        break;
        case "sua_thong_tin_quan_tri":
            include("chuc_nang/quan_tri_2/sua_thong_tin_quan_tri.php");
        break;
        default:
            include("chuc_nang/quan_tri_2/trang_chu_2.php");
    }
?>