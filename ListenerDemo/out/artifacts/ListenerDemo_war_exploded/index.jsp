<%@ page import="javax.print.attribute.standard.RequestingUserName" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yang.entity.User1" %><%--
  Created by IntelliJ IDEA.
  com.yang.entity.User1: Yang
  Date: 2017/12/23
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  当前在线用户人数:${userNum}
  <br>
  <%
    ArrayList<User1> user1s = (ArrayList<User1>) request.getServletContext().getAttribute("userList");
    if (user1s!=null){
        for (int i=0;i<user1s.size();i++){
           User1 user1 =  user1s.get(i);
  %>
  IP:<%=user1.getIpString()%>,FirstTime:<%=user1.getFirstTime()%>sessionId:<%=user1.getSessionString()%>
  <%      }
    }
  %>
  <hr>
  <button onclick="location.href='<%=request.getContextPath()%>/init.jsp'">Init</button>
  <button onclick="location.href='<%=request.getContextPath()%>/destroy.jsp'">Destroy</button>
  </body>
</html>
