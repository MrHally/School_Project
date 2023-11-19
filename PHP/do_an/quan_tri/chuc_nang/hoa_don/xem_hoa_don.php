<?php
if (!isset($bien_bao_mat)) {
    exit();
}
?>
<?php
$id = $_GET['id'];
$tv_1 = mysqli_query($tv, "select * from hoa_don where id='$id' ");
$tv_2 = mysqli_fetch_array($tv_1);
$ten_nguoi_mua = $tv_2['ten_nguoi_mua'];
$email = $tv_2['email'];
$dien_thoai = $tv_2['dien_thoai'];
$dia_chi = $tv_2['dia_chi'];
$noi_dung = $tv_2['noi_dung'];
$hang_duoc_mua = $tv_2['hang_duoc_mua'];
$link_dong = "?thamso=hoa_don&&trang=" . $_GET['trang'];
$link_xoa = "?xoa_hoa_don_o_trang_chi_tiet=co&id=" . $id . "&trang=" . $_GET['trang'];
?>

<table width="990px">
    <tr>
        <td width="250px"><b style="color: var(--color-base);font-size:20px">Sản phẩm được đặt hàng </b><br><br> </td>
        <td width="740px" align="right">
            <a href="<?php echo $link_dong; ?>" class="btn lk_a1 fw-bold" style="margin-right:30px"><u>Đóng</u></a>
        </td>
    </tr>
    <tr>
        <td align="left" colspan="2">
            <table class="tb_a1">
                <tr style="background:#CCFFFF;height:40px;text-align: center;">
                    <th width="100px">STT</th>
                    <th width="300px">Tên</th>
                    <th width="180px">Giá bán</th>
                    <th width="100px">Số lượng</th>
                    <th width="200px">Tổng cộng</th>
                </tr>
                <?php
                $m = explode("||", $hang_duoc_mua);
                $tong_lon = 0;
                for ($i = 0; $i < count($m); $i++) {
                    if (isset($m[$i])) {
                        if ($m[$i] != "") {
                            $stt = $i + 1;
                            $m_2 = explode("SL", $m[$i]);
                            $id_sp = $m_2[0];
                            $sl_sp = $m_2[1];
                            $tv_1 = mysqli_query($tv, "select id,ten,gia from san_pham where id='$id_sp' ");
                            $tv_sp_2 = mysqli_fetch_array($tv_1);
                            $ten = $tv_sp_2['ten'];
                            $gia = $tv_sp_2['gia'];
                            $gia_duoc_dinh_dang = number_format($gia, 0, ",", ".");
                            $tong = $gia * $sl_sp;
                            $tong_duoc_dinh_dang = number_format($tong, 0, ",", ".");
                            $tong_lon = $tong_lon + $tong;
                            if ($sl_sp != 0) {
                ?>
                                <tr class="a_1 text-center">
                                    <td><?php echo $stt; ?></td>
                                    <td><?php echo $ten; ?></td>
                                    <td><?php echo $gia_duoc_dinh_dang; ?></td>
                                    <td><?php echo $sl_sp; ?></td>
                                    <td><?php echo $tong_duoc_dinh_dang; ?></td>
                                </tr>
                <?php
                            }
                        }
                    }
                }
                ?>
            </table>
        </td>
    </tr>
</table>
<div class="container mt-3" style="text-align:left; width: 990px;">
    Tổng tiền của đơn hàng là :
    <?php
    $tong_lon_duoc_dinh_dang = number_format($tong_lon, 0, ",", ".");
    echo "<b>" . $tong_lon_duoc_dinh_dang . "đ</b>";
    ?>
</div>

<br><br>
<table width="990px" style="text-align: left; line-height: 1.5em;">
    <tr>
        <td width="180px"><b style="color: var(--color-base);font-size:20px">Thông tin người mua</b><br><br> </td>
        <td width="810px" align="right">
            &nbsp;
        </td>
    </tr>
    <tr height="30px">
        <th>Tên người mua : </th>
        <td>
            <?php echo $ten_nguoi_mua; ?>
        </td>
    </tr>
    <tr height="30px">
        <th>Email : </th>
        <td>
            <?php echo $email; ?>
        </td>
    </tr>
    <tr height="30px">
        <th>Điện thoại : </th>
        <td>
            <?php echo $dien_thoai; ?>
        </td>
    </tr>
    <tr height="30px">
        <th valign="top">Địa chỉ : </th>
        <td>
            <?php echo $dia_chi; ?>
        </td>
    </tr>
    <tr height="30px">
        <th valign="top">Nội dung : </th>
        <td>
            <?php echo $noi_dung; ?>
        </td>
    </tr>
    <tr height="30px">
        <td>&nbsp;</td>
        <td>
            <a href="<?php echo $link_xoa; ?>" class="btn lk_a1 fw-bold"><u>Xóa</u></a>
        </td>
    </tr>

</table>