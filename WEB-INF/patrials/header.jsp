<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="es" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style type="text/css">
    <%@include file='../assets/css/styles.css'%>
    </style>
    <title>Document</title>
</head>
<body>
<header>
        <div class="header_container container">
            <div class="col-md-8 header_logo">
                <a class="logo" href="/">LOGO</a>
            </div>
                <c:choose>
                    <c:when test="${param.firstname != null}">
                        <nav class="col-md-1 header_nav">
                            <ul>
                                <li><a href="/panel">Perfil</a></li>
                                <li><a href="/logout">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                                    <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                                    </svg></a></li>

                            </ul>
                        </nav>
                    </c:when>
                    <c:otherwise>
                        <nav class="col-md-4 header_nav">
                            <ul>
                                <li><a href="#">INICIO</a></li>
                                <li><a href="#">LOGIN</a></li>
                                <li><a href="#">REGISTRO</a></li>
                            </ul>
                        </nav>
                    </c:otherwise>
                </c:choose>
        </div>
</header>
