<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/1/27
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
    <title>增加命令</title>
    <link href="${pageContext.request.contextPath}/resources/css/all.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div style="text-align: center;">增加命令</div>
<form action="${pageContext.request.contextPath}/InsertOneServlet.action" method="post" id="add_command">
    <table class="tab2" width="100%">
        <tbody>
            <tr>
                <th>command<input type="text" value="" name="command"/></th>
                <th>description<input type="text" value="" name="description"/></th>
                <th>content<input type="text" value="" name="content"/></th>
            </tr>
            <tr>
                <th><input type="submit" value="提交" class="allInput"></th>
            </tr>
        </tbody>
    </table>
</form>
</body>
</html>
