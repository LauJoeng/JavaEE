<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>out</h1>
	<%
		out.println("<h2>静夜思</h2>");
		out.println("床前明月光<br>");
		out.println("疑是地上霜<br>");
		out.flush();
		//调用flush()方法后再调用clear()方法会抛出异常
		//out.clear();
		//在flush()方法后调用clearBuffer()方法不会抛出异常
		out.clearBuffer();
		out.println("举头望明月<br>");
		out.println("低头思故乡<br>");
	%>
	缓冲区大小：<%=out.getBufferSize() %>
	缓冲区剩余大小:<%=out.getRemaining() %>
	是否自动清除缓冲区:<%=out.isAutoFlush() %>
</body>
</html>