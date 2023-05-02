<!doctype html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        :root {
            --blue-chill-bg: #49A19A;
            --blue-chill-dark: #265656
        }
        header a {
            color: white;
            text-decoration: none;
            cursor: pointer;
        }
        a:hover {
            color: var(--blue-chill-dark);
        }
        header {
            color: white;
            font-weight: bold;
            background-color: var(--blue-chill-bg);
        }
        ul {
            list-style: none;
            display: flex;
            justify-content: space-between;
            margin: 0;
            padding: 0;
        }


        .header_container {
        display: flex;
        align-items: center;
        padding: 15px 0;
        }

        .header_logo {
            display: flex;
            flex-grow: 1;
        }
        .btn-custom {
            color: #fff;
            background-color: var(--blue-chill-bg);
            border-color: var(--blue-chill-bg);
        }
        .btn-custom:hover {
            color: var(--blue-chill-dark);
        }
        footer {
            padding: 15px 0;
            background-color: var(--blue-chill-bg);
            display: flex;

        .footer_container {
            display: flex;
        }

        }
        footer ul {
            display: flex;
            flex-direction: column;
            list-style: none;
        }
        footer h5 {
            color: #fff;
            font-size: 1.1rem;
        }
        footer a {
             text-decoration: none;
             color: #fff;
             font-size: 14px;
        }
        .socials ul {
            flex-direction: row;
        }
        .socials ul svg {
            width: 25px;
            height: 25px;
        }
    </style>
    <title>Document</title>
</head>
<body>
<header>
        <div class="header_container container">
            <div class="col-md-8 header_logo">
                <a class="logo" href="/">LOGO</a>
            </div>
            <nav class="col-md-4 header_nav">
                <ul>
                    <li><a href="#">INICIO</a></li>
                    <li><a href="#">LOGIN</a></li>
                    <li><a href="#">REGISTRO</a></li>
                </ul>
            </nav>
        </div>
</header>
