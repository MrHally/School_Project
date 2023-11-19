<?php

$tv = mysqli_connect("localhost", "root", "", "ban_hang");
mysqli_query($tv, 'SET NAMES "UTF8"');

function thong_bao_abc($c)
{
    $lien_ket_trang_truoc = $_SERVER['HTTP_REFERER'];
    echo "<script>alert('{$c}');</script>";
    trang_truoc_abc();
    exit();
}

function trang_truoc_abc()
{
    echo "<script>window.history.back();</script>";
}

if (isset($_POST['dang_nhap_quan_tri'])) {
    $ky_danh = mysqli_real_escape_string($tv, $_POST['ky_danh']);
    $mat_khau = md5(md5(mysqli_real_escape_string($tv, $_POST['mat_khau'])));

    $tv_1 = mysqli_query($tv, "SELECT COUNT(*) FROM thong_tin_quan_tri WHERE ky_danh='{$ky_danh}' AND mat_khau='{$mat_khau}'");
    $tv_2 = mysqli_fetch_array($tv_1);
    if ($tv_2[0] == 1) {
        $_SESSION['ky_danh'] = $ky_danh;
        $_SESSION['mat_khau'] = $mat_khau;
    } else {
        thong_bao_abc("Thông tin nhập vào không đúng");
    }
    trang_truoc_abc();
}

if (isset($_SESSION['ky_danh'])) {
    $ky_danh = $_SESSION['ky_danh'];
    $mat_khau = $_SESSION['mat_khau'];

    $tv_1 = mysqli_query($tv, "SELECT COUNT(*) FROM thong_tin_quan_tri WHERE ky_danh='{$ky_danh}' AND mat_khau='{$mat_khau}'");
    $tv_2 = mysqli_fetch_array($tv_1);
    if ($tv_2[0] == 1) {
        $xac_dinh_dang_nhap = "co";
    }
}