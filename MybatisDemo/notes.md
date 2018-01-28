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

mybatis中的关联关系:

多对一:

在多方的bean中定义一个一方的bean的引用，并在resultMap文件中用association标签配置多对一关系

一对多:

类似多对一，要在一方定义一个集合承装多方，并在resultMap文件用collection标签配置一对多关系

具体见command和commandContent的xml文件

mybatis配置文件中常用标签

![](https://img.mukewang.com/5a6dc398000197b512800720.jpg)

容易混淆的概念

<strong>resultMap和resultType的区别</strong>

相同点:他们都是表示结果集与java对象的一种映射关系，好让mybatis处理结果集，将结果集放到java对象中
当在配置文件中配置resultMap时要属性值要写已经写好的resultMap里的id，如果配置为resultType
则要直接写java类名，即不需要配置resultType了。此时用java类中的属性名与结果集中的列名对应来映射，且对类中属性名大小写不敏感
在resultMap的列标签里可以用typeHandler来处理类型转换,如:
<id column="id" jdbcType="INTEGER" property="id" typeHandler="" />

<strong>parameterMap和parameterType的区别</strong>

parameterType指向一个java类型，与OGNL表达式紧密关联，parameterMap与resultMap相似
parameterMap也需要一个想resultMap那样配置一个这样的内容，也有id，resultMap是表名结果集中的列
与类中的属性的对应关系二parameterMap是表明参数中的属性与数据库中对应的关系，parameterMap并不推荐使用

遇到乱码问题时要注意，要从以下几个方面检查
1. 代码本身的编码
2. jsp页面上设置的编码
3. servlet用来传值用来转换的编码
4. tomcat里的编码设置
5. 数据库的编码