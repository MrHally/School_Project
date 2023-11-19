<div class="container">
    <nav class="navbar navbar-expand-lg justify-content-between align-items-center">
        <a class="navbar-brand nav-logo" href="index.php">
            CĂN TIN A4
        </a>
        <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
            <ul class="navbar-nav mx-auto">
            <?php
                $tv = mysqli_connect("localhost", "root", "", "ban_hang");
                mysqli_query($tv, 'SET NAMES "UTF8"');
                $tv_1 = mysqli_query($tv, "SELECT id, ten, loai_menu FROM menu_ngang ORDER BY id LIMIT 1");
                while ($tv_2 = mysqli_fetch_array($tv_1)) {
                    if ($tv_2['loai_menu'] == "san_pham") {
                        $link_menu = "?thamso=xuat_san_pham_2";
                    }
                    echo "<li class='nav-item dropdown'>";
                    echo "<a class='nav-link dropdown-toggle' href='$link_menu' id='navbarDropdownMenuLink' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>";
                    echo $tv_2['ten'];
                    echo "</a>";
                    echo "<div class='dropdown-menu' aria-labelledby='navbarDropdownMenuLink'>";
                    $tv_5 = mysqli_query($tv, "SELECT id, ten FROM menu_doc ORDER BY id");
                    while ($tv_6 = mysqli_fetch_array($tv_5)){
                        $link="?thamso=xuat_san_pham&id=".$tv_6['id'];
                        echo "<a class='dropdown-item' href='$link'>";
                        echo $tv_6['ten'];
                        echo "</a>";
                        echo "<div class='dropdown-divider'></div>";
                    }
                    echo "</div>";
                    echo "</li>";
                }
                $tv_7 = mysqli_query($tv, "SELECT id, ten, loai_menu FROM menu_ngang ORDER BY id LIMIT 1 OFFSET 1");
                while ($tv_8 = mysqli_fetch_array($tv_7)) {
                    if ($tv_8['loai_menu'] == "phu_kien") {
                        $link_menu = "?thamso=xuat_phu_kien_2";
                    }
                    echo "<li class='nav-item dropdown'>";
                    echo "<a class='nav-link dropdown-toggle' href='$link_menu' id='navbarDropdownMenuLink' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>";
                    echo $tv_8['ten'];
                    echo "</a>";
                    echo "<div class='dropdown-menu' aria-labelledby='navbarDropdownMenuLink'>";
                    $tv_9 = mysqli_query($tv, "SELECT id, ten FROM menu_doc_pk ORDER BY id");
                    while ($tv_10 = mysqli_fetch_array($tv_9)){
                        $link="?thamso=xuat_phu_kien&id=".$tv_10['id'];
                        echo "<a class='dropdown-item' href='$link'>";
                        echo $tv_10['ten'];
                        echo "</a>";
                        echo "<div class='dropdown-divider'></div>";
                    }
                    echo "</div>";
                    echo "</li>";
                }
                mysqli_query($tv, 'SET NAMES "UTF8"');
                $tv_3 = mysqli_query($tv, "SELECT id, ten, loai_menu FROM menu_ngang ORDER BY id LIMIT 3 OFFSET 2");
                echo "<li class='nav-item dropdown'>";
                echo "<a class='nav-link dropdown-toggle' href='#' id='navbarDropdownMenuLink' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>";
                echo "Hỗ trợ";
                echo "</a>";
                echo "<div class='dropdown-menu' aria-labelledby='navbarDropdownMenuLink'>";
                while ($tv_4 = mysqli_fetch_array($tv_3)){
                    if ($tv_4['loai_menu'] == "") {
                        $link_menu = "?thamso=xuat_mot_tin&id=" . $tv_4['id'];
                    }
                    echo "<a class='dropdown-item' href='$link_menu'>";
                    echo $tv_4['ten'];
                    echo "</a>";
                    echo "<div class='dropdown-divider'></div>";
                }
                echo "</div>";
                echo "</li>";
            ?>
            </ul>
            <ul class="navbar-nav ml-auto">
                <?php include("chuc_nang/tim_kiem/vung_tim_kiem.php"); ?>
                <li class="nav-item d-block">  
                    <?php include("chuc_nang/gio_hang/vung_gio_hang.php"); ?>
                </li>
            </ul>
        </div>
    </nav>
</div>