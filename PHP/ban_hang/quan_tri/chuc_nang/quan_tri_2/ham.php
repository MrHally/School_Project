<?php
    if(!isset($bien_bao_mat)){exit();}
?>
<?php
    function thong_bao_html($c)
    {
        $lien_ket_trang_truoc = $_SERVER['HTTP_REFERER'];
        echo "<script>alert('{$c}');</script>";
        trang_truoc_html();
        exit();
    }
    
    function trang_truoc_html()
    {
        echo "<script>window.history.back();</script>";
    }
?>