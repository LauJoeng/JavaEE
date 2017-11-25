<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="loginUser" class="com.yang.User" scope="page"></jsp:useBean>
    <jsp:useBean id="userDao" class="com.yang.UserDao" scope="page"></jsp:useBean>
    <jsp:setProperty property="*" name="loginUser"></jsp:setProperty>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("utf-8");
	
	if(userDao.userLogin(loginUser))
	{
		session.setAttribute("loginUser", loginUser.getUsername());
		request.getRequestDispatcher("login_success.jsp").forward(request,response);
	}
	else
	{
		response.sendRedirect("login_failure.jsp");
	}
%>