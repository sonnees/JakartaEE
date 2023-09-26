<%@ page import="java.awt.*" %>
<html>
<head>
    <title>Buy Product</title>
</head>
<body>
<%@include file="dashboard_user.jsp"%>
<div class="container">
    <h3 style="text-align: center">Buy Product</h3>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Image</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Unit</th>
            <th scope="col">Manufacturer</th>
            <th scope="col">Price</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list_product}" var="p" varStatus="status">
            <tr>
                <td><img style="width: 100px" src=${list_pathImg[status.index]}></td>
                <td>${p.name}</td>
                <td>${p.description}</td>
                <td>${p.unit}</td>
                <td>${p.manufacturer}</td>
                <td>${list_price[status.index]}</td>
                <td>
                    <a href="#"><i class="fas fa-cart-plus"></i></a>
                </td>
            </tr>
        </c:forEach>

        </tbody>

    </table>

    <br><hr><br>

    <h3 style="text-align: center">Cart Here</h3>



    <span id="rs" style="display: none">${result}</span>
    <script>
        rs = document.getElementById("rs").innerText;
        if(rs==="true")
            alert("oke")
        if (rs==="false")
            alert("not oke")
    </script>
</div>



</body>
</html>