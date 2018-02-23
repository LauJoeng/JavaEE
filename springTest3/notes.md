**Spring的事务**

使用Spring事务需要下面几个步骤

- 在IOC容器里配置事务管理器

```
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
</bean>
```
- 在IOC容器里启用注解管理驱动

```
<tx:annotation-driven transaction-manager="transactionManager"/>
```
- 在方法上添加@Transactional注解启用事务管理

spring支持的事务传播行为

1. REQUIRED:如果有事务在运行，当前的方法就在这个事务运行，否则就启动一个新的事务，并在自己的事务内运行(一个事务里启动了其他事务，若其他事务发生没有提交成功，则最原始的事务也不会成功，即全部无法执行)
![](https://github.com/xuedingedeyang/Image/blob/master/2018-2-23/Spring_REQUIRED.PNG?raw=true)
2. REQUIRES_NEW:当前的方法必须启动新的事务，并在它自己的事务内运行如果有事务在运行，应该将它挂起 (与第一个相反)
![](https://github.com/xuedingedeyang/Image/blob/master/2018-2-23/Sping_REQUIRS_NEW.PNG?raw=true)
3. SUPPORTS：如果有事务在运行，当前方法就在这个事务内运行，否则他可以不运行在事务中
4. NOT_SUPPORTED:当前方法不应该运行在事务中，如果有运行的事务，将它挂起
5. MANDATORY：当前的方法必须运行在事务内部，如果有运行的事务，就抛出异常
6. NEVER：当前的方法不应该运行在事务中，如果有运行的事务，则抛出异常
7. NESTED:如果有事务在运行，当前的方法就应该在这个事务的嵌套事务内运行，否则，就启动一个新的事务，并在它自己的事务内运行