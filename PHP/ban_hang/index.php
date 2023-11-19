<?php
session_start();
include("ket_noi.php");
include("chuc_nang/ham/ham.php");

if (isset($_POST['thong_tin_khach_hang'])) {
    include("chuc_nang/gio_hang/thuc_hien_mua_hang.php");
}
if (isset($_POST['cap_nhat_gio_hang'])) {
    include("chuc_nang/gio_hang/cap_nhat_gio_hang.php");
    trang_truoc();
}
?>

<html lang="en">

<body>
    <!-- sale banner -->
    <div class="banner-sale py-1">Theme mùa hè đã đến hãy mua sắm ngay!!!</div>
    <header>
        <!-- navbar -->
        <?php
            include("chuc_nang/menu_ngang/menu_ngang.php");
        ?>
    </header>
    <hr>
    <!-- casrouel -->
    <!-- main -->
    <div class="container mt-3">
        <main class="">
            <?php
            include("chuc_nang/dieu_huong.php");
            ?>
        </main>

    </div>
    <!-- section -->
    <section>

    </section>
    <!-- footer -->
    <footer class="about-us">
        <div class="container mt-3">
            <table class="footer-table">
                <tr class="footer-col">
                    <th class="footer-row" width="9000px" colspan="2">Về May's Clothes</th>
                    <th class="footer-row" width="300px">Hỗ trợ khách hàng</th>
                    <th class="footer-row" width="300px">Liên hệ chúng tôi</th>
                </tr>
                <tr class="footer-col">
                    <td class="footer-row" rowspan="3">
                        Tủ quần áo freestyle & basic cho các cô gái.
                    </td>
                    <td class="footer-row" style="line-height: 2em;" rowspan="3">
                        Địa chỉ: P. Xuân Khánh, Q. Ninh Kiều, Tp. Cần Thơ <br>
                        Điện thoại: (+84)773 188 004 <br>
                        Email: diepmai.ceo@maifashion.com
                    </td>
                    <td class="footer-row" rowspan="3" style="line-height: 2em;">
                        <ul>
                            <li>
                                <a class="footer-link" href="#">Chính sách bảo hành</a>
                            </li>
                            <li>
                                <a class="footer-link" href="#">Chính sách đổi trả</a>
                            </li>
                        </ul>
                    </td>
                    <td class="footer-row" style="line-height: 2em;">
                        Hotline: (+84)773 188 004 <br>
                        Email: hotro@maifashion.com
                    </td>
                </tr>
                <tr class="footer-col">
                    <th class="footer-row">Theo dõi chúng tôi</th>
                </tr>
                <tr class="footer-col">
                    <td class="footer-row">
                        <a class="footer-link" href="https://www.facebook.com/profile.php?id=100086517551290" style="margin-top: 5px; margin-right: 10px;"><img src="anh/icon/facebook.svg" alt="May's Clothes FB" srcset="" width="25px"></a>
                        <a class="footer-link" href="#"><img src="anh/icon/instagram.svg" alt="May's Clothes Insta" srcset="" width="25px"></a>
                    </td>
                </tr>
            </table>
        </div>
        <hr style="margin: 0px">
        <div class="footer-cpy">Copyright © 2023 May's Clothes.</div>
    </footer>
    </div>

</body>

</html>