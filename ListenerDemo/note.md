监听器与过滤器及servlet的启动顺序为

- 监听器 --> 过滤器 --> servlet 

1. 监听域对象自身的创建和销毁的事件监听器(ServletContext HttpSession ServletRequest)

监听三个对象分别要实现ServletContextListener HttpSessionListener ServletRequestListener

