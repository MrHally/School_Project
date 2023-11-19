<?php
    if(isset($_GET['id']) and $_SESSION['trang_chi_tiet_gio_hang']=="co")
    {
        $_SESSION['trang_chi_tiet_gio_hang']="huy_bo";
        if(isset($_SESSION['id_them_vao_gio']))
        {
            $so=count($_SESSION['id_them_vao_gio']);
            $trung_lap="khong";
            for($i=0;$i<count($_SESSION['id_them_vao_gio']);$i++)
            {
                if($_SESSION['id_them_vao_gio'][$i]==$_GET['id'])
                {
                    $trung_lap="co";
                    $vi_tri_trung_lap=$i;
                    break;
                }
            }
            if($trung_lap=="khong")
            {
                $_SESSION['id_them_vao_gio'][$so]=$_GET['id'];
                $_SESSION['sl_them_vao_gio'][$so]=$_GET['so_luong'];
            }
            if($trung_lap=="co")
            {
                $_SESSION['sl_them_vao_gio'][$vi_tri_trung_lap]=$_SESSION['sl_them_vao_gio'][$vi_tri_trung_lap]+$_GET['so_luong'];
            }
        }
        else
        {
            $_SESSION['id_them_vao_gio'][0]=$_GET['id'];
            $_SESSION['sl_them_vao_gio'][0]=$_GET['so_luong'];
        }
    }
    $gio_hang="khong";
    if(isset($_SESSION['id_them_vao_gio']))
    {
        $so_luong=0;
        for($i=0;$i<count($_SESSION['id_them_vao_gio']);$i++)
        {
            $so_luong=$so_luong+$_SESSION['sl_them_vao_gio'][$i];
        }
        if($so_luong!=0)
        {
            $gio_hang="co";
        }
    }

    echo "<h5>Giỏ hàng</h5>";
    if($gio_hang=="khong")
    {
        echo "Không có sản phẩm trong giỏ hàng";
    }
    else
    {
    echo "<form action='' method='post' >";
    echo "<input type='hidden' name='cap_nhat_gio_hang' value='co' > ";
    echo "<table width='1200px' class='tbl-gh'>";
        echo "<tr>";
            echo "<th width='200px' class='tbl-gh' >Tên</th>";
            echo "<th width='150px' class='tbl-gh' >Số lượng</th>";
            echo "<th width='150px' class='tbl-gh' >Đơn giá</th>";
            echo "<th width='170px' class='tbl-gh' >Thành tiền</th>";
        echo "</tr>";
        $tong_cong=0;
        for($i=0;$i<count($_SESSION['id_them_vao_gio']);$i++)
        {
            $tv_1=mysqli_query($tv,"select id,ten,gia from san_pham where id='".$_SESSION['id_them_vao_gio'][$i]."'");
            $tv_2=mysqli_fetch_array($tv_1);
            $tien=$tv_2['gia']*$_SESSION['sl_them_vao_gio'][$i];
            $tong_cong=$tong_cong+$tien;
            $tong_cong = number_format($tong_cong, 0, ",", ".");
            if($_SESSION['sl_them_vao_gio'][$i]!=0)
            {
                $name_id="id_".$i;
                $name_sl="sl_".$i;
                echo "<tr>";
                    echo "<td class='tbl-gh'>".$tv_2['ten']."</td>";
                    echo "<td class='tbl-gh'>";
                    echo "<input type='hidden' name='".$name_id."' value='".$_SESSION['id_them_vao_gio'][$i]."' >";
                    echo "<input type='text' style='width:50px' name='".$name_sl."' value='". $_SESSION['sl_them_vao_gio'][$i]."' > ";
                    echo "</td>";
                    $gia = $tv_2['gia'];
                    $gia = number_format($gia, 0, ",", ".");
                    echo "<td class='tbl-gh'>".$gia."đ</td>";
                    $tien = number_format($tien, 0, ",", ".");
                    echo "<td class='tbl-gh'>".$tien."đ</td>";
                echo "</tr>";
             }
        }
    echo "<tr style='text-align: center;'>";
    echo "<td colspan='4'><input class='btn btn-brand mt-3' type='submit' value='Cập nhật' > </td>";
    echo "</tr>";    
    echo "</table>";
    echo "</form>";
    echo "<br>";
    echo "Tổng giá trị đơn hàng là : ".$tong_cong." VNĐ";
    include("chuc_nang/gio_hang/bieu_mau_mua_hang.php");
}
?>