创建一个拦截器大致分为两步

1. 创建一个类继承自AbstractInterceptor类，实现intercept方法，在intercept方法中实现拦截逻辑业务
2. 在struts.xml文件中配置，先注册拦截器，再在action中引用拦截器













jstl表达式(JavaServer Pages Standard Tag Library)和el表达式(Expression Language)

el表达式通常与jstl表达式一起使用，使得jsp页面更直观写法更简单

普通写法 <%=session.getValue("name")%>

el表达式 <c:out value="${session.name}"/>

el表达式格式 ${表达式}

${user.firstname}  #{user["first_name"]}

EL变量

![](https://img4.mukewang.com/5a5f44a600016d4512800720.jpg)