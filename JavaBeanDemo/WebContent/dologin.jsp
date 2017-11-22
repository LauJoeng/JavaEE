<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="myUser" class="com.po.User" scope="page"/>
	<h1>setProperty动作元素</h1> 
	<hr>
	<!-- 根据表单自动匹配所有的属性 -->
	<jsp:setProperty name="myUser" property="*" />
	用户名:<%=myUser.getUsername() %><br>
	密码:<%=myUser.getPassword() %><br>
	
	<!-- 根据表单匹配部分属性 -->
	<jsp:setProperty name="myUser" property="username" />
	用户名:<%=myUser.getUsername() %><br>
	密码:<%=myUser.getPassword() %><br>
	
	<!-- 与表单无关。手动给属性赋值 -->
	<%-- <jsp:setProperty name="myUser" property="username"  value="张三丰"/>
	<jsp:setProperty name="myUser" property="password" value="342242"/>
	用户名:<%=myUser.getUsername() %><br>
	密码:<%=myUser.getPassword() %><br> --%>
	
	<!-- 通过URL参数给属性赋值 -->
	<jsp:setProperty name="myUser" property="password" param="myPass"/>
	用户名:<%=myUser.getUsername() %><br>
	密码:<%=myUser.getPassword() %><br>
</body>
</html>