<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/3/28
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <%--
    1.导入jQuery
    2.获取name="username"的节点：username
    3.为username添加change响应函数
    3.1获取username的value属性值，去除前后空格且不为空,准备发送Ajax请求
    3.2:发送Ajax且请求检验username是否可用
    3.3:在服务器端直接返回一个html片段
    3.4在客户端浏览器把其直接添加待#message的html中
    --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.10.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $(":input[name='username']").change(function () {
                var val = $(this).val();
                val = $.trim(val);

                if(val !== ""){
                    var url = "${pageContext.request.contextPath}/ValidateUserName";
                    var args = {"userName":val,"time":new Date()};
                    $.post(url,args,function (data) {
                        $("#message").html(data);
                    });
                }
            });
        });
    </script>
</head>
<body>
    <form action="" method="post">
        Username:<input type="text" name="username" title=""/>
        <div id="message"></div>
        <br>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
