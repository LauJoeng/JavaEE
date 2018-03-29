<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 2018/3/27
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.10.1.js"></script>
  <script type="text/javascript">

      /*
      window.onload = function () {
          //1.获取a节点，并为其添加onclick响应函数，取消其默认行为
          document.getElementsByTagName("a")[0].onclick = function () {
              // 3.创建一个XMLHttpRequest对象
              var request = new XMLHttpRequest();
              //4准备发送请求的数据：url
              var url = this.href;
              // var method = "GET";
              var method = "POST";
              //5.调用XMLHttpRequest对象的open方法
              request.open(method,url);

              request.setRequestHeader("ContentType","application/x-www-form-urlencodeed");
              //6.调用XMLHttpRequest的send方法
              request.send("name='yang'");
              //7.为XMLRequest对象添加onreadystatechange响应函数
              request.onreadystatechange = function () {
                  // alert(request.readyState);
                  //8.判断响应是否完成:XMLHttpRequest对象的readyState属性为值4的时候
                  if(request.readyState === 4){
                      //9.再判断响应是否可用，XMLHttpRequest对象的属性值为200
                      if(request.status == 200 || request.status == 304){
                          //打印响应结果:responseText
                          alert(request.responseText);
                      }
                  }
              }
              return false;
          };
      }*/
  </script>
</head>
<body>
<a href="helloAjax.txt">HelloAjax</a>
</body>
</html>
