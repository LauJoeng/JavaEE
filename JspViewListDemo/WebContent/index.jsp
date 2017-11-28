<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Items" %>
<%@ page import="dao.ItemsDAO" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h1>商品展示</h1>
<hr>
<%
    ItemsDAO itemsDAO = new ItemsDAO();
    ArrayList<Items>list = itemsDAO.getAllItems();
    for(int i=0;i<list.size();i++)
    {
%>
<center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td>
                <%
                    Items item = list.get(i);
                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp"><img src="images/<%= item.getPicture()%>" width="120" height="100" border="1"/></a>
                        </dt>
                        <dd class="dd_name"><%=item.getName()%></dd>
                        <dd class="dd_city"><%=item.getCity()%>&nbsp;&nbsp;价格:￥<%=item.getPrice()%></dd>
                    </dl>
                </div>
                <%
                    }
                %>
            </td>
        </tr>
    </table>
</center>


</table>
</body>
</html>
