<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/3/31
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <img src="${pageContext.request.contextPath}/images/loading.jpg" style="display: none" id="loading">
    <center>
        <br><br>
        City
        <select id="city">
            <option value="">请选择...</option>
            <c:forEach items="${locations}" var="location">
                <option value="${location.locationId}">${location.city}</option>
            </c:forEach>
        </select>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            City
            <select id="department">
                <option value="">请选择...</option>

            </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            Employee:
        <select id="employee">
            <option value="">请选择...</option>
        </select>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <br><br>
        <table id="empdetails" border="1" cellspacing="5" style="display: none">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Salary</th>
            </tr>
            <tr>
                <td id="id"></td>
                <td id="name"></td>
                <td id="email"></td>
                <td id="salary"></td>
            </tr>
        </table>
    </center>
</body>
</html>
