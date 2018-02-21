**AOP**

AOP(Aspect-Orientied Programming)面向切面编程是一种新的方法论，是对传统OOP(Object-Orientied Programming)面向对象编程的补充

AOP的主要编程对象是切面(Aspect),而切面模块化横切关注点

在应用AOP编程时，仍然需要定义公共功能，但可以明确定义这个功能在哪里，以什么方式应用，并且不必修改受影响的类。这样一来横切关注点就被模块化到特殊的对象(切面)里

AOP的好处

- 每个的事务逻辑位于一个位置，代码不分散，便于维护和升级
- 业务模块更简洁，只包含核心业务代码

spring2.0以上版本可以使用AspectJ注解或基于xml配置AOP

1.springAOP需要加入jar包

aopalliance-1.0.jar
aspectjrt-1.7.4.jar
aspectjweaver-1.7.4.jar
spring-aop-4.0.5.RELEASE.jar
spring-aspects-4.0.5.RELEASE.jar

commons-logging-1.1.jar
spring-beans-4.0.5.RELEASE.jar
spring-context-4.0.5.RELEASE.jar
spring-core-4.0.5.RELEASE.jar
spring-expression-4.0.5.RELEASE.jar

2.在配置文件中加入aop的命名空间

3. 基于注解的方式

在配置文件中加入如下配置

<aop:aspectj-autoproxy></aop:aspectj-autoproxy>

把横切关注点的代码抽象到切面类中

切面首先是一个IOC中的bean，即加了@Component注解，切面还需要加入@Aspect注解

在类中生命各种通知，在AspectJ中有五种通知

 - @Before:前置通知：在方法执行之前执行
 - @After 后置通知，在方法执行之后执行
 - @AfterRunning 返回通知，在方法返回结果之后执行
 - @Afterthrowing 异常通知，在方法抛出异常之后执行
 - @Around 环绕通知，围绕着方法执行
 
 在类中声明各种通知:

 声明一个方法，在方法前加入@Before注解
 
 可以在通知方法中声明一个类型为JointPoint的参数，然后就能访问链接细节，如方法名称和参数
 
 
 
 
 
 **spring对jdbc的支持**
 
 