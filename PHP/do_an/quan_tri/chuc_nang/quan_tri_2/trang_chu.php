<?php
if (!isset($bien_bao_mat)) {
    exit();
}
?>
<header id="header" class="header sticky-top align-items-center py-3 px-5">
    <nav class="navbar navbar-expand-lg navbar-light justify-content-between align-items-center">
        <a href="index.php" class="title nav-brand nav-logo" style="text-decoration: none; font-size: 2em; font-weight: bold;">
            <span class="">CĂN TIN A4</span>
        </a>
        <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
            <ul class="navbar-nav mx-auto" style="font-size: 1.5em;">
                <li class="nav-item">
                    <a class="nav-link" href="index.php">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="?thamso=san_pham">Món ăn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="?thamso=phu_kien">Đồ uống</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="?thamso=hoa_don">Đơn hàng</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" type="button" id="dropdownMenuButton" data-mdb-toggle="dropdown" aria-expanded="false">
                        Thiết kế cửa hàng
                    </a>
                    <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="dropdownMenuButton">
                        <li><a class="nav-link dropdown-item" href="?thamso=slideshow">Slideshow</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="nav-link dropdown-item" href="?thamso=banner">Banner</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown pe-3 mt-1">
                <a class="nav-link nav-profile align-items-center pe-0" href="#" data-bs-toggle="dropdown" style="color: var(--color-brand); font-weight: bold;">
                    <span class="d-none d-md-block dropdown-toggle ps-2"><img src="../../anh/icon/person.svg" width="25px" alt="" srcset=""></span>
                </a><!-- End Profile Iamge Icon -->
                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <?php
                    $tv = mysqli_connect("localhost", "root", "", "ban_hang");
                    mysqli_query($tv, 'SET NAMES "UTF8"');
                    $b = mysqli_query($tv, "select id, ky_danh from thong_tin_quan_tri");
                    $a = mysqli_fetch_array($b);
                    ?>
                    <li class="dropdown-header">
                        <h6><?php echo $a["ky_danh"]; ?></h6>
                        <span>ID Shop: <?php echo $a["id"]; ?></span>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="?thamso=sua_thong_tin_quan_tri">
                            <i class="bi bi-person"></i>
                            <span>Trang cá nhân</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="?thamso=ngon_ngu">
                            <i class="bi bi-gear"></i>
                            <span>Ngôn ngữ cài đặt</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="?thamso=thoat">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Đăng xuất</span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
</header>

<section>
    <center>
        <?php
        include("chuc_nang/quan_tri_2/dieu_huong.php");
        ?>
    </center>
</section>

<footer class="py-3">
    <center>
        <table>
            <tr style="text-align: center;">
                <td>
                    Cửa hàng :
                </td>
                <td>
                    CĂN TIN A4
                </td>
            </tr>
            <tr style="text-align: center;">
                <td>
                    Quản trị viên :
                </td>
                <td>
                    NHÓM 4
                </td>
            </tr>
            <tr style="text-align: center;">
                <td>
                    Điện thoại :
                </td>
                <td>
                    (+84) 77 388 004
                </td>
            </tr>
        </table>
    </center>
</footer>