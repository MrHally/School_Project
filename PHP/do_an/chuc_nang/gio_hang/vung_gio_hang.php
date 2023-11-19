<?php
    $so_luong=0;
    if(isset($_SESSION['id_them_vao_gio']))
    {
        for($i=0;$i<count($_SESSION['id_them_vao_gio']);$i++)
        {
            $so_luong=$so_luong+$_SESSION['sl_them_vao_gio'][$i];
        }
    }
?>
<a class="nav-link mt-3" href="?thamso=gio_hang"><img src="../../anh/icon/basket.svg" alt="" width="20px" srcset="" style="margin-right: 5px;"><span class="mt-4 position-absolute top-0 start-100 translate-middle badge rounded-pill bg-brand"><?php echo $so_luong; ?></span></a>