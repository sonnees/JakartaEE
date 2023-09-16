<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/09/2023
  Time: 5:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="Error.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>

    <h1>hello Son nees</h1>

    <%
        try {
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
        } catch (Exception e){
            throw e;
        }


    %>

    <h1>Heloo <%=application.getInitParameter("name")%></h1> <br>
    <h1>Heloo <%=config.getInitParameter("name")%></h1>

<%@include file="footer.jsp"%>
</body>
</html>
