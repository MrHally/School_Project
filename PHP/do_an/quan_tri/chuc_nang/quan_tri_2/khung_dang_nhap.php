<?php
if (!isset($bien_bao_mat)) {
    exit();
}
?>
<br><br>
<style>
    body {
        font-family: "Dosis", sans-serif;
        font-size: 500px;
    }

    .row {
        margin: 0;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    .title {
        color: var(--color-brand);
        font-weight: bold;
        font-size: 50px;
    }

    .col-sm-6 {
        padding-top: 50px;
    }

    .line-left {
        border-left: 1px solid var(--color-base);
        height: 200px
    }
</style>
<center>
    <form method="post">
        <div class="row">
            <div class="col-sm-6">
                <h1 class="title">CĂN TIN A4</h1>
            </div>
            <div class="col-sm-6 line-left">
                <table>
                    <tr>
                        <td>Ký danh :</td>
                        <td><input style="width:150px" name="ky_danh"></td>
                    </tr>
                    <tr>
                        <td>Mật khẩu :</td>
                        <td><input type="password" style="width:150px" name="mat_khau"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="hidden" name="dang_nhap_quan_tri" value="dang_nhap_quan_tri">
                            <input type="submit" value="Đăng nhập">
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
</center>