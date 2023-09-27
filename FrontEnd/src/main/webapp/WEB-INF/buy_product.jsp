<%@ page import="java.awt.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
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
                <td><p id='price-${p.id}'>${list_price[status.index]}</p></td>
                <td>
                    <button class="btn" onclick="addCart(['${list_pathImg[status.index]}','${p.name}','${p.unit}','${list_price[status.index]}','${p.id}'])">
                        <i class="fas fa-cart-plus" ></i> </button>
                </td>
            </tr>
        </c:forEach>

        </tbody>

    </table>

    <br><hr>

    <h3 style="text-align: center">Cart Here</h3>
    <h5 style="text-align: center">Employee default id = 1 | Customer default id = 1</h5>
    <table class="table" id="tableCart">
        <thead>
        <tr>
            <th scope="col">Image</th>
            <th scope="col">Name</th>
            <th scope="col">Unit</th>
            <th scope="col">Quantity</th>
            <th scope="col">Total Price</th>
        </tr>
        </thead>
        <tbody>
        </tbody>

    </table>

    <div style="float: right">
        <p style="float: right">&nbsp; $</p>
        <b id="total-price-all" style="float: right"> 0</b>
        <p style="float: right">Total price: &nbsp;</p>

    </div>

    <hr style="clear: both">
<%--    <form id="formCart" action="" >--%>
<%--        <input id="fc-1" name="" type="text" style="display: none">--%>
        <input onclick="alert('improving')"  style="float: right" class="btn-success" type="submit" value="create"></input>
<%--    </form>--%>


    <br><br><br> <br><br> <br><br>
    <span id="rs" style="display: none">${result}</span>
    <script>
        rs = document.getElementById("rs").innerText;
        if(rs==="true")
            alert("oke")
        if (rs==="false")
            alert("not oke")

        function addCart(arr){
            let table = document.getElementById("tableCart");
            let IdQuantity = "quantity-"+arr[4];
            let IdPrice = "totalPrice-"+arr[4];
            let IdDeleteRow = arr[4];
            let newRow = table.insertRow();
            newRow.id = "rowCart-"+arr[4];
            newRow.insertCell().innerHTML = "<img style='width: 100px' src="+arr[0]+">";
            newRow.insertCell().innerHTML = arr[1];
            newRow.insertCell().innerHTML = arr[2];
            newRow.insertCell().innerHTML = "<input onchange=changePrice('"+IdQuantity+"') type=number id='"+IdQuantity+"' min=1 max=100 value=1>";
            newRow.insertCell().innerHTML = "<p id='"+IdPrice+"'> "+arr[3]+"</p>"
            newRow.insertCell().innerHTML ="<button class='btn' onclick=deleteCart('"+IdDeleteRow+"')><i class='fas fa-trash-alt'></i></button>"

            let totalPriceAll_old = document.getElementById("total-price-all").innerText;
            let totalPriceAll_new = parseFloat(totalPriceAll_old)+parseFloat(arr[3])
            document.getElementById("total-price-all").innerText=totalPriceAll_new+"";

        }

        function changePrice(IdQuantity){
            let arr = IdQuantity.split("-");
            let value =document.getElementById(IdQuantity).value;

            let totalPrice_old = parseFloat(document.getElementById("totalPrice-"+arr[1]).innerText);
            let totalPrice_new = parseFloat(document.getElementById("price-"+arr[1]).innerText) * value;
            document.getElementById("totalPrice-"+arr[1]).innerText = totalPrice_new+"";

            let totalPriceAll_old = document.getElementById("total-price-all").innerText;
            let totalPriceAll_new = parseFloat(totalPriceAll_old)-totalPrice_old+totalPrice_new;
            document.getElementById("total-price-all").innerText=totalPriceAll_new+"";

        }

        function  deleteCart(id){
            let row = document.getElementById("rowCart-"+id);
            let totalPrice_old = parseFloat(document.getElementById("totalPrice-"+id).innerText);
            let totalPriceAll_old = document.getElementById("total-price-all").innerText;
            let totalPriceAll_new = parseFloat(totalPriceAll_old)- totalPrice_old;
            document.getElementById("total-price-all").innerText=totalPriceAll_new+"";
            row.remove()
        }
    </script>
</div>



</body>
</html>