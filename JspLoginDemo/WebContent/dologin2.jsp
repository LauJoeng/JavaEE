<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录成功!</h1>
	<hr>
	<br>
	<br>
	<%
		request.setCharacterEncoding("utf-8");
		String[] isUseCookies = request.getParameterValues("isUseCookie");
		if(isUseCookies!=null&&isUseCookies.length >0)
		{
			//用URLEncoder解决无法在Cookie当中保存中文问题
			String username=URLEncoder.encode(request.getParameter("username"),"utf-8");
			String password=URLEncoder.encode(request.getParameter("password"),"utf-8");
			
			Cookie usernameCookie = new Cookie("username",username);
			Cookie passwordCookie = new Cookie("password",password);
			
			usernameCookie.setMaxAge(864000);
			passwordCookie.setMaxAge(864000);//设置最大生存期限，单位是秒
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
		}
		else
		{
			Cookie[] cookies = request.getCookies();
			if(cookies!=null&&cookies.length>0)
			{
				for(Cookie c:cookies)
				{
					if(c.getName().equals("username")||c.getName().equals("password"))
					{
						c.setMaxAge(0);//设置Cookie失效
						response.addCookie(c);//重新保存
					}
				}
			}
		}
	%>
	<a href="user.jsp">查看用户信息</a>
</body>
</html>