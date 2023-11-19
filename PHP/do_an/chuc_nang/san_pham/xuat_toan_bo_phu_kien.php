<?php
    $so_du_lieu=15;
    $tv_1=mysqli_query($tv,"select count(*) from phu_kien");
    $tv_2=mysqli_fetch_array($tv_1);
    $so_trang=ceil($tv_2[0]/$so_du_lieu);
  
    if(!isset($_GET['trang'])){$vtbd=0;}else{$vtbd=($_GET['trang']-1)*$so_du_lieu;}
  
    $tv_1=mysqli_query($tv,"select id,ten,gia,hinh_anh,thuoc_menu from phu_kien order by id desc limit $vtbd,$so_du_lieu");
    echo "<center>";
    echo "<h3 style='text-align: left;'>Đồ uống</h3>";
    echo "<br>";
    echo "<table>";
    while($tv_2=mysqli_fetch_array($tv_1))
    {
        echo "<tr>";
            for($i=1;$i<=4;$i++)
            {
                echo "<td align='center' width='400px;' valign='top' >";
                    if($tv_2!=false)
                    {
                        $link_anh="anh/phu_kien/".$tv_2['hinh_anh'];
                        $link_chi_tiet="?thamso=chi_tiet_phu_kien&id=".$tv_2['id'];
                        $gia=$tv_2['gia'];
                        $gia=number_format($gia,0,",",".");
                        echo "<a href='$link_chi_tiet' >";
                            echo "<img src='$link_anh' width='200px' height='100%' >";
                        echo "</a>";
                        echo "<br>";
                        echo "<br>";
                        echo "<a class='product-name' href='$link_chi_tiet' >";
                            echo $tv_2['ten'];
                        echo "</a>";
                        echo "<div style='margin-top:5px' >";                       
                        echo $gia."đ";
                        echo "</div>";
                        echo "<br>";
                    }
                    else
                    {
                        echo "&nbsp;";
                    }
                echo "</td>";
                if($i!=5)
                {
                    $tv_2=mysqli_fetch_array($tv_1);
                }
            }
        echo "</tr>";
    }
    echo "<tr>";
        echo "<td colspan='3' align='center' >";
            echo "<div class='phan_trang' >";
                for($i=1;$i<=$so_trang;$i++)
                {
                    $link="?thamso=xuat_phu_kien_2&trang=".$i;
                    echo "<a href='$link' >";
                        echo $i;echo " ";
                    echo "</a>";
                }
            echo "</div>";
        echo "</td>";
    echo "</tr>";
    echo "</table>";
    echo "</center>";
?>
