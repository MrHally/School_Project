<?php
    if(trim($_GET['tu_khoa'])!=""){
        $m=explode(" ",$_GET['tu_khoa']);  
        $chuoi_tim_sql="";
        for($i=0;$i<count($m);$i++)
        {
            $tu=trim($m[$i]);
            if($tu!="")
            {
                $chuoi_tim_sql=$chuoi_tim_sql." ten like N'%".$tu."%' and";
            }
        }

        $m_2=explode(" ",$chuoi_tim_sql);  
        $chuoi_tim_sql_2="";
        for($i=0;$i<count($m_2)-1;$i++)
        {
            $chuoi_tim_sql_2=$chuoi_tim_sql_2.$m_2[$i]." ";
        }

        $so_du_lieu=15;
        $tv_1=mysqli_query($tv,"select count(*) from san_pham where $chuoi_tim_sql_2");
        $tv_2=mysqli_fetch_array($tv_1);
        $so_trang=ceil($tv_2[0]/$so_du_lieu);
      
        if(!isset($_GET['trang'])){$vtbd=0;}else{$vtbd=($_GET['trang']-1)*$so_du_lieu;}

        $tv_1=mysqli_query($tv,"select * from san_pham where $chuoi_tim_sql_2 order by id desc limit $vtbd,$so_du_lieu");
        echo "<center>";
        echo "<table>";
        while($tv_2=mysqli_fetch_array($tv_1))
        {
            echo "<tr>";
                for($i=1;$i<=4;$i++)
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
                            echo $gia;
                            echo "đ</div>";
                            echo "<br>";
                        }
                        else
                        {
                            echo "&nbsp;";
                        }
                    echo "</td>";
                    if($i!=4)
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
                        $link="?thamso=tim_kiem&tu_khoa=".$_GET['tu_khoa']."&trang=".$i;
                        echo "<a href='$link' >";
                            echo $i;echo " ";
                        echo "</a>";
                    }
                echo "</div>";
            echo "</td>";
        echo "</tr>";
        echo "</table>";
        echo "</center>";
    }
    else
    {
    echo "Bạn chưa nhập từ khóa";
    }
?>
