<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CĂN TIN A4</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="giao_dien/giao_dien.css">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Comfortaa">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Dancing_Script">
        <link rel="stylesheet" href="giao_dien/css/bootstrap-icons.css">
        <link href="anh/logo/shopping-bag-icon-sale-package-sign-design-free-png.png" rel="icon">
        <script src="giao_dien/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="giao_dien/js/script.js"></script>
        <style>
        body{
            background-color: var(--color-heading);
            font-family: "Comfortaa", sans-serif;
            font-weight: 500px;
            position: relative;
            min-height: 100vh;
        }

        h1,h2,h3,h4,h5,h6{
            font-weight: bold;
            color: var(--color-brand)
        }

        .banner-sale{
            background-color: var(--color-brand);
            color: var(--color-heading);
            width: 100%;
            font-weight: bold;
            text-align: center;
        }  
        .bg-body{
            background-color: var(--color-body);
        }

        .bg-brand{
            background-color: var(--color-brand);
        }
        
        a{
            color: var(--color-base);
        }
        a:hover{
            color: var(--color-brand);
        }
        a:hover::after{
            color: var(--color-brand);
        }

        .text-base{
            color: var(--color-base);
        }

        .color-base{
            color: var(--color-base);
        }

        .btn-base2{
            background-color: var(--color-base2);
            color: var(--color-base);
            border: 1px solid var(--color-base2);
        }

        .btn-brand{
            background-color: var(--color-brand);
            color: var(--color-heading);
        }

        .btn-infor{
            border: 3px solid var(--color-brand);
            color: var(--color-brand);
            font-weight: bolder;
        }
        .btn-infor:hover, .btn-infor::after{
            background-color: var(--color-brand);
            color: var(--color-heading);
        }

        /* Navbar */
        .dropdown .dropdown-menu{
            transition: transform 0.25s ease-out;
        }

        .dropdown-menu{
            background-color: var(--color-body);
            opacity: 90%;
            border: none;
            border-radius: 15px;
            box-shadow: 10px;
        }

        .dropdown-item:hover, .dropdown-divider{
            background-color: var(--color-base2);
        }

        .dropdown:hover .dropdown-menu {
            display: block;
            transform: translateY(-10px);
        }

        a.nav-link{
            color: var(--color-base);
            font-size: 16px;
            font-weight: bold;
        }

        a.nav-link:hover{
            color: var(--color-brand2)
            
        }

        a.nav-link:hover::after{
            color: var(--color-brand);
        }

        .text-brand{
            color: var(--color-brand);
            font-weight: bold;
        }

        a.nav-logo{
            color: var(--color-brand);
            font-weight: bold;
            font-size: 50px;
            font-family: "Dancing Script", sans-serif;
        }

        li.nav-item{
            position: relative;
            border-bottom: 2px solid transparent;
        }

        li.nav-item::after{
            content: '';
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 2px;
            background-color: var(--color-brand);
            transform: scaleX(0);
            transform-origin: bottom right;
            transition: transform 0.3s ease-in-out;
        }

        li.nav-item:hover::after {
            border-bottom: 2px solid var(--color-brand);
            transform: scaleX(1);
            transform-origin: bottom left;
        }

        /* end navbar */

        main{
            flex-grow: 1;
            padding-bottom: 300px;
        }
        /* Footer */
        footer{
            position: absolute;
            bottom: 0;
            width: 100%;
        }

        th.footer-row{
            color: var(--color-brand);
        }

        td.footer-row{
            padding: 20px;
            color: var(--color-base);
            font-size: small;
            font-weight: lighter;
        }

        .footer-cpy{
            padding: 10px;
            color: var(--color-base);
            font-size: small;
            font-weight: smaller;
            text-align: center;
        }

        .footer-link{
            color: var(--color-base);
        }

        .footer-link:hover{
            color: var(--color-brand);
            font-weight: bold;
        }

        .about-us{
            background-color: rgba( 98.8%, 85.1%, 85.1%, 0.5 );
            font-weight: 100px;
        }

        /* banner */

        /* san pham */

        .input_soluong{
            width: 40px;
            text-align: center;
            border: 1px solid var(--color-base2);
        }

        a.product-name{
            color: var(--color-base);
        }

        /* menu dọc sản phẩm */
        a.sp-menu{
            width: 150px;
            height: 150px;
            margin: 5px;
            border: 4px solid var(--color-brand);
            border-radius: 20%;
            text-align: center;
            padding-top: 60px;
            font-weight: bold;
            font-size: 20px;
            color: var(--color-brand);
        }

        a.sp-menu:hover{
            background-color: var(--color-brand);
            color: var(--color-heading);
        }

        a.sp-menu::after{
            background-color: var(--color-brand);
        }
        /* menu dọc phụ kiện */
        a.pk-menu{
            width: 150px;
            height: 150px;
            margin: 5px;
            border: 4px solid var(--color-brand);
            border-radius: 20%;
            text-align: center;
            padding-top: 40px;
            font-weight: bold;
            font-size: 20px;
            color: var(--color-brand);
        }

        a.pk-menu:hover{
            background-color: var(--color-brand);
            color: var(--color-heading);
        }

        a.pk-menu::after{
            background-color: var(--color-brand);
        }

        /* giỏ hàng */
        td.tbl-gh{
            padding: 5px;
            background-color: white;
            color: var(--color-base);
        }

        th.tbl-gh{
            padding: 5px;
            background-color: var(--color-brand);
            color: var(--color-heading);
        }

        </style>
    </head>
    <body>  
<?php
    $a = mysqli_connect("localhost","root","","ban_hang");
    mysqli_query($a,'SET NAMES "UTF8"');
?>
</body>
</html>