<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 使用out标签输出 常量-->
	<c:out value="this is frist jstl demo"></c:out>
	<!-- 使用out标签输出变量 ,通过default属性输出默认值，设置输出转义字符需要将escapeXml属性设置为false-->
	<%session.setAttribute("name", "Yang"); %>
	<c:out value="${name}" default="error" escapeXml="false"></c:out><br/>
	
	
	<!-- 存值到scope中 -->
	<c:set value="today" var="day" scope="session"></c:set>
	<c:out value="day"></c:out><br/>
	
	<jsp:useBean id="person" class="com.yang.jstltest.Person"></jsp:useBean>
	<!-- 通过set标签向person中赋值 -->
	<c:set target="${person}" property="name" value="张三"></c:set>
	<c:out value="${person.name}"></c:out><br/>
	
	<!-- remove标签 -->
	<c:set var="firstname" value="Wang"></c:set>
	<c:out value="${firstname}"></c:out>
	<c:remove var="firstname"/>
	<c:out value="${firstname}"></c:out>
	<c:set var="lastname" value="lily"></c:set>
	
	<!-- catch标签 -->
	<c:catch var="error">
		<c:set target="aa" property="bb">asfa</c:set>
	</c:catch>
	<c:out value="${error}"></c:out><br/>
	
	
	<!-- if标签 -->
	<form action="" method="post">
		<input type="text" name="score" value="${param.score}">
		<input type="submit">
	</form>
	<c:if test="${param.score>=90}" var="result">
		<c:out value="优秀"></c:out>
	</c:if>
	<br/>
	
	
	<!-- choose when otherwise 标签 -->
	<c:choose>
		<c:when test="#{param.score>=90&&param.score<=100}"></c:when>
		<c:when test="#{param.score>=75&&param.score<=90}"></c:when>
		<c:when test="#{param.score>=0&&param.score<=75}"></c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	
	<!-- forEach标签  根据循环条件遍历collection中的元素     begin，end能指定开始遍历位置和结束位置，step能指定跳跃个数-->
	<%
		List<Integer>list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		request.setAttribute("list", list);
	%>
	<c:forEach var="num" items="${list}" begin="1" end="3" step="2">
		<c:out value="${num}"></c:out><br/>
	</c:forEach>
	
	
	
	<!-- forTockons标签    用于浏览字符串。将字符串截取 -->
	<c:forTokens items="010-998-434" delims="-" var="num">
		<c:out value="${num}"></c:out><br/>
	</c:forTokens>
</body>
</html>