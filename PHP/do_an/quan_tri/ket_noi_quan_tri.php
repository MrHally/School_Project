<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản trị</title>
    <link href="anh/shopping-bag-icon-sale-package-sign-design-free-png.png" rel="icon">
    <script src='phan_bo_tro/tinymce/js/tinymce/tinymce.min.js'></script>
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Dosis">
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Dancing_Script">
    <link rel="stylesheet" type="text/css" href="giao_dien/giao_dien.css">
    <link rel="stylesheet" type="text/css" href="giao_dien/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="giao_dien/css/animate.min.css">
    <script src="giao_dien/js/bootstrap.min.js"></script>
    <script src="giao_dien/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            background-color: var(--color-body);
        }
    </style>
    <style type="text/css">
        body {
            background-color: var(--color-heading);
            font-family: "Dosis", sans-serif;
            font-weight: 500px;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        section {
            background-color: var(--color-heading);
            height: auto;
        }

        footer {
            background-color: var(--color-body);
            margin-top: auto;
        }

        header {
            background-color: var(--color-body);
        }

        .dropdown-menu-dark {
            background-color: var(--color-base);
            border: none;
            width: 100%;
        }

        a,
        b {
            color: var(--color-base);
        }

        a.lk_1 {
            font-size: 22px;
            text-decoration: none;
            color: blue;
            margin-right: 30px
        }

        a.lk_1:hover {
            color: red
        }

        a.title {
            color: var(--color-brand);
        }

        a.title:hover {
            color: var(--color-brand2);
            transition: 0.25s;
        }

        a.nav-logo{
            color: var(--color-brand);
            font-weight: bold;
            font-size: 50px;
            font-family: "Dancing Script", sans-serif;
        }

        ul {
            list-style-type: none;
        }

        .dropdown:hover .dropdown-menu {
            display: block;
            margin-top: 0;
            /* remove the gap so it doesn't close */
        }
    </style>
</head>

<body>
    <?php
    $a = mysqli_connect("localhost", "root", "", "ban_hang");
    mysqli_query($a, 'SET NAMES "UTF8"');
    ?>
</body>

</html>