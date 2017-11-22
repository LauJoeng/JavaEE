<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="myUser" class="com.po.User" scope="page" />
	<h1>使用useBean动作创建javaBean的实例</h1>
	<hr>
	用户名:<%=myUser.getUsername() %><br>
	密码:<%=myUser.getPassword() %><br>
</body>
</html>