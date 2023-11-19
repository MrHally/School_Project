<?php
$_SESSION['trang_chi_tiet_gio_hang'] = "co";
$tv = mysqli_connect("localhost", "root", "", "ban_hang");
mysqli_query($tv, 'SET NAMES "UTF8"');
$id = $_GET['id'];
$tv_1 = mysqli_query($tv, "select * from san_pham where id='$id'");
$tv_2 = mysqli_fetch_array($tv_1);
$link_anh = "anh/san_pham/" . $tv_2['hinh_anh'];
?>

<body>
    <div class="row">
        <div class="col-sm-6">
            <center>
                <img src="<?php echo $link_anh ?>" width="550px">
            </center>
        </div>
        <div class="col-sm-6">
            <h5><?php echo $tv_2['ten']; ?></h5>
            <p>Mã sp: <?php echo $tv_2['id']; ?></p>
            <h2>
            <?php
            $gia = $tv_2['gia'];
            $gia = number_format($gia, 0, ",", ".");
            echo $gia."đ";
            ?>
            </h2>
            <hr>
            <form class="d-flex">
                <input type="hidden" name="thamso" value="gio_hang">
                <input type="hidden" name="id" value="<?php echo $_GET["id"]; ?>">
                <div class="soluong">
                    <div class="input-group">
                        <button id="tru-btn" class="btn btn-base2" type="button">-</button>
                        <input id="soluong_txt" type="text" name="so_luong" class="input_soluong" value="1">
                        <button id="cong-btn" class="btn btn-base2" type="button">+</button>
                    </div>
                </div>
                
                <input class="btn btn-brand" type='submit' value='Thêm vào giỏ' style='margin-left:15px'>
            </form>
            <hr>
            <h5>Chi tiết sản phẩm</h5> 
            <?php echo $tv_2['noi_dung']; ?>
        </div>
    </div>
    <script>
        // Get the elements
        const input = document.querySelector('#soluong_txt');
        const minusBtn = document.querySelector('#tru-btn');
        const plusBtn = document.querySelector('#cong-btn');

        // Set the initial value and step size
        let value = parseInt(input.value);
        const step = 1;

        // Add event listeners to the buttons
        minusBtn.addEventListener('click', () => {
        value -= step;
        if (value < 1) {
            value = 1;
        }
        input.value = value;
        });

        plusBtn.addEventListener('click', () => {
        value += step;
        input.value = value;
        });
    </script>
</body>