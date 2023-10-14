<%@ page import="java.awt.*" %>
<html>
<head>
    <title>View Account</title>
</head>
<body>
<%@include file="dashboard_user.jsp"%>
<div class="container">
    <h3 style="text-align: center">Product Manager</h3>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">dob</th>
            <th scope="col">address</th>
            <th scope="col">phone</th>
            <th scope="col">email</th>
            <th scope="col">Method</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${candidates}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.dob}</td>
                <td>${c.email}</td>
                <td>${c.fullName}</td>
                <td>${c.phone}</td>
                <td>${c.address}</td>

                <td>
                    <a href=""><i class="fas fa-trash-alt"></i></a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <form action="">
                <td><input style="width: 200px" type="text" name="name" value="Nguyen Thi Det"></td>
                <td><input style="width: 200px" type="text" name="description" value="description here"></td>
                <td><input style="width: 200px" type="text" name="unit" value="kg"></td>
                <td><input style="width: 200px" type="text" name="manufacturer" value="manufacturer here"></td>
                <td>
                    <select name="status">
                        <option value="-1">terminate</option>
                        <option value="0">No Active</option>
                        <option value="1" selected>Active</option>
                    </select>
                </td>
                <input style="width: 200px; display: none" type="text" name="action" value="insert">
                <td>
                    <input class="btn-success" type="submit" value="create"></input>
                </td>
            </form>
        </tr>

        </tbody>

    </table>

<%--    <span id="rs" style="display: none">${result}</span>--%>
<%--    <script>--%>
<%--        rs = document.getElementById("rs").innerText;--%>
<%--        if(rs==="true")--%>
<%--            alert("oke")--%>
<%--        if (rs==="false")--%>
<%--            alert("not oke")--%>
<%--    </script>--%>
</div>



</body>
</html