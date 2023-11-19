<?php
    $tv = mysqli_connect("localhost","root","","ban_hang");
    mysqli_query($tv,'SET NAMES "UTF8"');
    $id=$_GET['id'];

    $so_du_lieu=9;
    $tv_1=mysqli_query($tv,"select count(*) from san_pham where thuoc_menu='$id';");
    $tv_2=mysqli_fetch_array($tv_1);
    $so_trang=ceil($tv_2[0]/$so_du_lieu);
  
    if(!isset($_GET['trang'])){$vtbd=0;}else{$vtbd=($_GET['trang']-1)*$so_du_lieu;}

    $tv_1=mysqli_query($tv,"select id,ten,gia,hinh_anh,thuoc_menu from san_pham where thuoc_menu='$id' order by id desc limit $vtbd,$so_du_lieu");
    
    echo "<center>";
    $tv_3=mysqli_query($tv,"select ten from menu_doc where id ='$id';");
    $tv_4=mysqli_fetch_array($tv_3);
    echo "<h3 class='mt-2 mb-3' style='text-align: left;'>".$tv_4['ten']."</h3>";
    echo "<br>";
    echo "<table>";
    while($tv_2= mysqli_fetch_array($tv_1))
    {
        echo"<tr>";
            for($i = 1;$i <= 4; $i++)
            {
                echo "<td align='center' width='400px' valign='top'>";
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
                        echo $gia;
                        echo "</div>";
                        echo "<br>";
                    }
                    else{
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
                    $link="?thamso=xuat_san_pham&id=".$_GET['id']."&trang=".$i;
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