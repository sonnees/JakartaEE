<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 26/09/2023
  Time: 1:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Order Anal</title>
</head>
<%@include file="dashboard_admin.jsp"%>
<body>
    <div class="container" style="width: 50%">
        <h3 style="text-align: center">Order Anals</h3>
        <div>
            <form action="/JakartaEE/ControlServlet">
                <input type="date" name="date" value=${date}>
                <td>
                    <input class="btn-success" type="submit" value="Day" name="for"></input>
                </td>
                <td>
                    <input class="btn-success" type="submit" value="Month" name="for"></input>
                </td>
                <td>
                    <input class="btn-success" type="submit" value="Year" name="for"></input>
                </td>
                <input style="width: 200px; display: none" type="text" name="action" value="orders_Anal-Years-Months">
            </form>
        </div>
        <table class="table">
            <thead>

            <tr>
                <th scope="col">Date</th>
                <th scope="col">Quality</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="p">
                <tr>
                    <td>${p.field_1}</td>
                    <td>${p.field_2}</td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</body>
</html>
