<h4>请求转发与请求重定向的区别</h4>

1.请求重定向：客户端行为,response.sendRedirect(),从本质上讲等同于两次请求，前一次的请求对象不会保存，地址栏的URL地址会改变

2.请求转发: 服务器行为，request.getRequestDispatcher().forward(request,response);是一次请求，转发后请求对象会保存，地址栏得URL地址不会改变


![](https://github.com/xuedingedeyang/Image/blob/master/qubie.png?raw=true)

<h4>session对象</h4>

![](https://github.com/xuedingedeyang/Image/blob/master/session.png?raw=true)

![](https://github.com/xuedingedeyang/Image/blob/master/sessionfangfa.png?raw=true)

<h5>Session的生命周期：</h5>

**创建->活动->销毁 **

注意：

- 当本次所有页面都关闭再重新访问某个Jsp或者Servlet创建新的会话时，旧的会话仍然存在，只不过再也没有客户端会携带它然后交与服务器端校验，要等这个会话 超时之后才会被销毁

- 某次会话中通过超链接打开的新页面属于同一次会话

- 只要当前会话页面没有全部关闭，重新打开新的浏览器窗口访问同一项目资源时，属于同一次会话	

- 本次会话所有页面都关闭的情况下，再重新访问某个jsp或Servlet时会创建新的会话

- 可以通过调用session.invalidate()方法的方式对session进行销毁

Tomcat默认session超时时间为30分钟

设置session超时有两种方式

1. session.setMaxInactiveInterval(int);//单位为秒

2. 再web.xml中配置

```
<session-config>
<session-timeout>
10
</session-timeout>
</session-config> //单位是分钟
```

<h5>application对象</h5>

![](https://github.com/xuedingedeyang/Image/blob/master/application.png?raw=true)

![](https://github.com/xuedingedeyang/Image/blob/master/applicationmethod.png?raw=true)

