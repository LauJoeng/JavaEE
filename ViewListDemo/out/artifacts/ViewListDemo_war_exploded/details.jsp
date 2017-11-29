<%@ page import="dao.ItemsDAO" %>
<%@ page import="entity.Items" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2017/11/29
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>商品详情</h1>
<hr>
<center>
    <table width="750" cellpadding="0" cellspacing="0" border="0">
        <tr>
            <%
                ItemsDAO itemsDAO = new ItemsDAO();
                Items item = itemsDAO.getItemById(Integer.parseInt(request.getParameter("id")));
                if (item != null) {
            %>
            <td width="%70" valign="top">
                <table>
                    <tr>
                        <td rowspan="4"><img src="images/<%=item.getPicture()%>" width="200"></td>
                    </tr>
                    <tr>
                        <td><b><%=item.getName()%>
                        </b></td>
                    </tr>
                    <tr>
                        <td>产地:<%=item.getCity()%>
                        </td>
                    </tr>
                    <tr>价格:<%=item.getPrice()%>
                    </tr>
                </table>
            </td>
            <%
                }
            %>
            <%
                String list = "";
                Cookie[] cookies = request.getCookies();
                if (cookies != null && cookies.length > 0) {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("ListViewCookie")) {
                            list = c.getValue();
                        }
                    }
                }
                list += request.getParameter("id") + ",";
                //如果浏览记录超过1000条，就清零
                String[] arr = list.split(",");
                if (arr != null && arr.length > 0) {
                    if (arr.length >= 1000) {
                        list = "";
                    }
                }
                Cookie cookie = new Cookie("ListViewCookie", list);
                response.addCookie(cookie);
            %>
            <td width="320" bgcolor="#eee" align="center">
                <br>
                <b>您浏览过的商品</b>
                <%--循环开始--%>
                <%
                    ArrayList<Items> itemList = itemsDAO.getViewList(list);
                    if (itemList != null && itemList.size() > 0) {
                        for (Items i : itemList) {
                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?=<%=i.getId()%>"><img src="images/<%=i.getPicture()%>"
                                                                       width="200"/></a>
                        </dt>
                        <dd class="dd_nam"><%=i.getName()%>
                        </dd>
                        <dd class="city">产地:<%=i.getCity()%>&nbsp;&nbsp;价格:<%=i.getPrice()%>
                        </dd>
                    </dl>
                </div>
                <%
                        }
                    }
                %>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
