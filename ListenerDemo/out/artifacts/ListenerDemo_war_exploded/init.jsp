<%@ page import="com.yang.entity.User" %><%--
  Created by IntelliJ IDEA.
  com.yang.entity.User1: Yang
  Date: 2017/12/23
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("requestName","requestValue");
    request.getSession().setAttribute("sessionName","sessionValue");
    request.getSession().getServletContext().setAttribute("contextName","contextValue");
//    request.getAttribute("");
//    request.getParameter(s);//http://www.yang.com/s=lll;这样才能获取getParameter()
    request.getSession().setAttribute("currentUser",new User());
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    这是初始化jsp<br>
    <hr>
    <button onclick="location.href='<%=request.getContextPath()%>/init.jsp'">Init</button>
    <button onclick="location.href='<%=request.getContextPath()%>/destroy.jsp'">Destroy</button>

</body>
</html>
