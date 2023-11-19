<?php
if (!isset($bien_bao_mat)) {
    exit();
}
?>
<style type="text/css">
    a.lk_2 {
        text-decoration: none;
        color: #993399;
        font-size: 22px;
        line-height: 30px;
    }

    a.lk_2:hover {
        color: red;
    }
</style>
<h2 class="mt-3">Lối tắt</h2>
<br>
<table width="500px" style="margin-left: 100px;">
    <tr>
        <td valign="top">
            <a href="?thamso=them_phu_kien" class="lk_2">Thêm đồ uống</a><br>
            <a href="?thamso=them_san_pham" class="lk_2">Thêm món ăn</a><br>
        </td>
        <td valign="top">
            <a href="?thamso=quan_ly_phu_kien" class="lk_2">Quản lý đồ uống</a><br>
            <a href="?thamso=quan_ly_san_pham" class="lk_2">Quản lý món ăn</a><br>
            <a href="?thamso=hoa_don" class="lk_2">Quản lý hóa đơn</a><br><br><br>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <a href="?thamso=san_pham_trang_chu" class="lk_2">món ăn trang chủ</a><br>
            <a href="?thamso=san_pham_noi_bat" class="lk_2">món ăn nổi bật</a><br>
        </td>
        <td valign="top">
            <a href="?thamso=quan_ly_banner" class="lk_2">Quản lý banner</a><br>
            <a href="?thamso=quan_ly_slideshow" class="lk_2">Quản lý slideshow</a><br>
            <a href="?thamso=sua_thong_tin_quan_tri" class="lk_2">Thay đổi thông tin quản trị</a><br>
        </td>
    </tr>
</table>