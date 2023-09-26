<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Dashboard Admin</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<body>
    <div>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">Son Nees</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="...">Quản lý<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="ControlServlet?action=product_crud">Product</a></li>
                            <li><a href="#">ProductPrice (null)</a></li>
                            <li><a href="#">ProductImage (null)</a></li>
                            <li><a href="#">Customer (null)</a></li>
                            <li><a href="#">Employee (null)</a></li>
                            <li><a href="#">Orders (null)</a></li>
                            <li><a href="#">OrderDetail (null)</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Thống kê<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="ControlServlet?action=orders_Anal-Year-Month-Day">Tổng số lượng hóa đơn theo Ngày-Tháng-Năm</a></li>
                            <li><a href="ControlServlet?action=orders_Anal-Years-Months">Số hóa đơn theo Ngày-Tháng-Năm</a></li>
                            <li><a href="#">...</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </nav>
    </div>
</body>
</html>
