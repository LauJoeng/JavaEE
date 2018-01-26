使用mybatis只要引入jar包即可

使用mybatis的步骤:

1. 配置configuration的xml文件，可以先复制模板，里面要配置数据库用户名、密码、驱动、映射文件等.
2. 配置映射文件。映射文件里有命名空间，同一个命名空间下不能有相同的resultMap的id，resultMap相当于javaBean
的映射，主键用id子标签，其他列用column子标签
3. 在map文件中配置sql语句，用select，update，delete等标签配置sql语句，每个标签有一个id
用于等下再java代码中调用
4.Java代码中调用
```java
List<Message>messages = new ArrayList<>();
//通过配置文件获取连接信息
Reader reader = Resources.getResourceAsReader("config/Configuration.xml");
//通过配置信息构建一个sqlsessionfactory
SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(reader);
SqlSession sqlsession = sqlSessionFactory.openSession();
Message message = new Message();
message.setCommand(command);
message.setDescription(description);
//通过sqlSession执行sql语句
messages = sqlSession.selectList("Message.queryMessageList",message);
```

![](https://img1.mukewang.com/5a6b1d4000019bd512800720.jpg)


![](https://img4.mukewang.com/5a6b1e220001d3d212800720.jpg)