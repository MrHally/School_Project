<br>
<?php
    $tv = mysqli_connect("localhost","root","","ban_hang");
    mysqli_query($tv,'SET NAMES "UTF8"');
    $tv_1 = mysqli_query($tv,"select * from menu_doc_pk order by id");
    echo "<nav class='nav justify-content-center'>";
    while($tv_2 = mysqli_fetch_array($tv_1))
    {
        $link="?thamso=xuat_phu_kien&id=".$tv_2['id'];
        echo "<a class='nav-item nav-link pk-menu' href='$link'>";
            echo $tv_2['ten'];
        echo "</a>";
    }
    echo "</nav>";
?>
<br>