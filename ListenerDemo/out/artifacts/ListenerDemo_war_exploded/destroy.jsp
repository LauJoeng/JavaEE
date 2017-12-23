<%--
  Created by IntelliJ IDEA.
  com.yang.entity.User1: Yang
  Date: 2017/12/23
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.removeAttribute("requestName");
    request.getSession().removeAttribute("sessionName");
    request.getSession().getServletContext().removeAttribute("contextName");
    request.getSession().removeAttribute("currentUser");
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    这是销毁jsp<br>
    <hr>
    <button onclick="location.href='<%=request.getContextPath()%>/init.jsp'">Init</button>
    <button onclick="location.href='<%=request.getContextPath()%>/destroy.jsp'">Destroy</button>
</body>
</html>
