<?php
function trang_truoc(){
    ?>
        <html><head>
          <meta charset="UTF-8">
          <title>Đang chuyển về trang trước</title></head>
        <body>
            <script type="text/javascript">
                window.history.back();
            </script>  
        </body>
        </html>
    <?php
}
function thong_bao_html($chuoi_thong_bao)
{
    $lien_ket_trang_truoc=$_SERVER['HTTP_REFERER'];
    ?>
        <html><head>
          <meta charset="UTF-8">
          <title>Thông báo</title></head>
        <body>
            <style type="text/css">
            a.trang_truoc_c8w{text-decoration:none;color:blue;font-size:36px;margin-left:50px}
            a.trang_truoc_c8w:hover{color:red;}
            </style>
            <br><br><br><br>
            <a href="<?php echo $lien_ket_trang_truoc; ?>" class="trang_truoc_c8w" >Bấm vào đây để trở về trang trước</a>
            <script type="text/javascript">
                alert("<?php echo $chuoi_thong_bao; ?>");
            </script>
        </body>
        </html>
    <?php
    exit();
}
function thong_bao_html_roi_chuyen_trang($chuoi_thong_bao,$link_chuyen_trang)
{
    $lien_ket_trang_truoc=$_SERVER['HTTP_REFERER'];
    ?>
        <html><head>
          <meta charset="UTF-8">
          <title>Thông báo</title></head>
        <body>
            <script type="text/javascript">
                alert("<?php echo $chuoi_thong_bao; ?>");
                window.location="<?php echo $link_chuyen_trang; ?>";
            </script>
        </body>
        </html>
    <?php
    exit();
}
?>