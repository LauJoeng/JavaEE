Spring如何在WEB应用中使用

① jar包

spring-web-4.0.5.RELEASE.jar
spring-webmvc-4.0.5.RELEASE.jar

② Spring的配置文件，没有什么不同

③如何创建IOC容器

- 非web应用中在main方法中直接创建
- 应该在web应用被服务器加载时就创建IOC容器：

在ServletContextListener的contextInitialized(ServletContextEvent sce)方法中创建IOC容器

- 在web应用的其他组件中如何访问IOC容器

在ServletContextListener的contextInitialized(ServletContextEvent sce)方法中创建IOC容器后，可以把其放在ServletContext(即Application域)的一个属性中

实际上，Spring配置文件的名字和位置也是可配置的！将其配置到当前web应用的初始化参数中较为合适

2. Spring如何整合Struts2