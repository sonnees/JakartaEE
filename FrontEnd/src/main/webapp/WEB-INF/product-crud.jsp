<%@ page import="java.awt.*" %>
<html>
<head>
    <title>View Account</title>
</head>
<body>
<%@include file="dashboard_admin.jsp"%>
<div class="container">
    <h3 style="text-align: center">Product Manager</h3>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Phone</th>
            <th scope="col">Status</th>
            <th scope="col">Method</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="p">
            <tr>
                <td>${p.name}</td>
                <td>${p.description}</td>
                <td>${p.unit}</td>
                <td>${p.manufacturer}</td>
                <td>${p.status}</td>
                <td>
                    <a href="/JakartaEE/ProductControl?action=delete&id=${p.id}"><i class="fas fa-trash-alt"></i></a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <form action="/JakartaEE/ProductControl">
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