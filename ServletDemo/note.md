
当用超链接(表单里面的action相同)访问页面时，如下

- 使用相对路径
```
<a href="/servlet/HelloServlet"></a>
```
此时第一个/表示服务器根目录

- 使用绝对路径
```
<%
    path = request.getContextPath();
%>

<a href="<%=path%>/servlet/HelloServlet"></a>
```

path变量表示项目的根目录，项目根目录可以用request.getContextPath()获得

../表示回到上一级目录