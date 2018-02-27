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

在web 环境下使用Spring

- 需要额外加入jar包

spring-web-4.0.5.RELEASE.jar
spring-webmvc-4.0.5.RELEASE.jar

- Spring的配置文件和非web环境没什么不同
- 需要在web.xml文件中加如下配置:

```
  <!-- 配置Spring配置文件的名称和位置 -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  

	<!-- 启动IOC容器的ServletContextListener -->
	<!-- Bootstraps the root web application context before servlet initialization -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener> 
```

2. Spring如何整合Struts2

整合目标：使IOC容器来管理Struts2的Action!

如何整合

- 正常加入Struts2

- 在Spring的IOC容器中配置Struts2的action  注意:在配置IOC容器中配置Struts2的Action时，需要配置scope属性，其值必须为prototype

```
<bean id="personAction" class="com.example.spring.struts2.actions.PersonAction" scope="prototype">
		<property name="personService" ref="personService"></property>
</bean>
```

- 配置Struts2的配置文件:action节点的class属性需要指向IOC容器中该bean的id

```
<action name="person-save" class="personAction">
	<result>/success.jsp</result>
</action>
```

- 加入jar包

struts2-spring-plugin-2.3.15.3.jar

- 整合原理：通过添加struts2-spring-plugin-2.3.15.3.jar以后，Struts2会先从IOC容器获取Action的实例，如果不存在则反射创建