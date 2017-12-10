<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2017/12/10
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>First Servlet Demo</h1>
  <hr>
  <a href="servlet/HelloServlet">GET方式请求HelloServlet</a><br>
  <form action="servlet/HelloServlet" method="post">
    <input type="submit"  value="post方式请求Servlet">
  </form>
  </body>
</html>
