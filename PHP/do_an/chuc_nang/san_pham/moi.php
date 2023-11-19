<br>
<img src='/anh/banner/banner2.jpg' alt='Sản phẩm mới' width="1300px">
<br><br>
<h3>Mới ra lò</h3>
<br>
<center>
    <?php
        $tv = mysqli_connect("localhost","root","","ban_hang");
        mysqli_query($tv,'SET NAMES "UTF8"');
        $tv_1=mysqli_query($tv,"select id,ten,gia,hinh_anh,thuoc_menu from san_pham order by id desc limit 5");
        echo "<table>";
    while($tv_2=mysqli_fetch_array($tv_1))
    {
        echo "<tr>";
            for($i=1;$i<=5;$i++)
            {
                echo "<td align='center' width='400px' valign='top' >";
                    if($tv_2!=false)
                    {
                        
                        $link_anh="anh/san_pham/".$tv_2['hinh_anh'];
                        $link_chi_tiet="?thamso=chi_tiet_san_pham&id=".$tv_2['id'];
                        $gia=$tv_2['gia'];
                        $gia=number_format($gia,0,",",".");
                        echo "<a href='$link_chi_tiet' >";
                            echo "<img src='$link_anh' width='200px' height='100%' >";
                        echo "</a>";
                        echo "<br>";
                        echo "<br>";
                        echo "<a href='$link_chi_tiet' >";
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
    $link_trang_moi="?thamso=trang_moi";
    echo "<tr><td colspan='5'><a href='$link_trang_moi' class='btn btn-infor rounded-pill text-center w-100 mt-2 mb-3'><< Xem thêm >></a></td></tr>";
    echo "</table>";
    ?>
</center>