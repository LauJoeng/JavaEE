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
    <style type="text/css">
        div{
            float:left;
            margin: 10px;
        }
        div dd{
            margin:0px;
            font-size:10pt;
        }
        div dd.dd_name
        {
            color:blue;
        }
        div dd.dd_city
        {
            color:#000;
        }
    </style>
</head>
<body>
<h1>商品展示</h1>
<hr>
<center>
    <table width="750"  cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td>
                <%
                    ItemsDAO itemsDAO = new ItemsDAO();
                    ArrayList<Items>list = itemsDAO.getAllItems();
                    if(list!=null&&list.size()>0)
                    {  for(int i=0;i<list.size();i++)
                        {
                        Items items = list.get(i);
                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?id=<%=items.getId()%>"><img src="images/<%= items.getPicture()%>" width="120" height="100" border="1"/></a>
                        </dt>
                        <dd class="dd_name"><%=items.getName()%></dd>
                        <dd class="dd_city"><%=items.getCity()%>&nbsp;&nbsp;价格:￥<%=items.getPrice()%></dd>
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


</table>
</body>
</html>
