<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 13/09/2023
  Time: 12:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>View Account</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
</head>
<body>
    <%@include file="dashboard_admin.jsp"%>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">account_id</th>
                <th scope="col">login_time</th>
                <th scope="col">logout_time</th>
                <th scope="col">notes</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listLogs}" var="log">
                <tr>
                    <td>${log.id}</td>
                    <td>${log.account_id}</td>
                    <td>${log.login_time}</td>
                    <td>${log.logout_time}</td>
                    <td>${log.notes}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <script>
        document.getElementById("log").classList.toggle("active");
        document.getElementById("welcome").style.display="none";
    </script>
</body>
</html>
