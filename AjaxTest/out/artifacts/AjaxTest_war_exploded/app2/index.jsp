<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/3/28
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <%--
        1.获取当前页面所有a节点，并为每一个a节点添加onclick响应函数，同时取消其磨人行为
        2.准备Ajax请求：url；args
        3.响应一个JSON对象，包括：bookName，totalBookNumber，totalMoney
        4.把对应的属性添加到对应的位置
    --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.10.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a").click(function () {
                var url = this.href;
                var args = {"time":new Date()};
                $.getJSON(url,args,function (data) {
                    $("#bookName").text(data.bookName);
                    $("#totalBookNumber").text(data.totalBookNumber);
                    $("#totalMoney").text(data.totalMoney);
                });
                return false;
            });
        });

    </script>
</head>
<body>
您已将&nbsp;<span id="bookName"></span>&nbsp;加入到购物车，
购物车中的书有&nbsp;<span id="totalBookNumber"></span> &nbsp; 本，
总价格 &nbsp;<span id="totalMoney"></span> &nbsp; 元

<br><br>
JAVA &nbsp;<a href="AddToCartServlet?id=java&price=180">加入购物车</a>
<br><br>

Oracle&nbsp;<a href="AddToCartServlet?id=Oracle&price=200">加入购物车</a>
<br><br>

PHP&nbsp;<a href="AddToCartServlet?id=PHP&price=100">加入购物车</a>
<br><br>

</body>
</html>
