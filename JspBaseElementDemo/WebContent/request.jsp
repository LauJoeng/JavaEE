<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>request内置对象</h1>
	<% 
		request.setCharacterEncoding("utf-8");//解决中文乱码问题  无法解决URL传递中文出现乱码问题
		request.setAttribute("password","123456");
	%>
	用户名:<%=request.getParameter("username") %><br>
	爱好:
	<%
		if(request.getParameterValues("favorite")!=null)
		{
			String[] favorites = request.getParameterValues("favorite");
			for(int i=0;i < favorites.length;i++)
			{
				out.println(favorites[i]+"&nbsp;&nbsp");
			}
		}
	%><br>
	密码:<%=request.getAttribute("password") %><br>
	请求体的MIME类型：<%=request.getContentType() %><br>
	协议类型和版本号:<%=request.getProtocol() %><br>
	服务器的主机名:<%=request.getServerName() %><br>
	端口号:<%=request.getServerPort() %><br>
	请求文件的长度:<%=request.getContentLength() %><br>
	请求客户端的ip地址:<%=request.getRemoteAddr() %><br>
	请求上下文路径:<%=request.getContextPath() %>
</body>
</html>