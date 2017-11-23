<%@page import="com.po.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JavaBean的四个作用域范围</h1>
	<hr>
	<jsp:useBean id="myUser" class="com.po.User" scope="request"/>
	
	<jsp:setProperty name="myUser" property="*" />
	用户名:<jsp:getProperty property="username" name="myUser"/><br>
	密码:<jsp:getProperty property="password" name="myUser"/><br>
	
	<!-- 使用jsp内置对象获取 -->
	用户名:<%=((User)request.getAttribute("myUser")).getUsername() %><br>
	密码:<%=((User)request.getAttribute("myUser")).getPassword()%><br>
</body>
</html>