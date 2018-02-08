Struts访问Servlet的API

1. ActionContext
2. 实现***Aware接口
3. ServletActionContext

动态方法调用

1. 指定method属性，如，在action属性里配置method，<action name="helloworld" method="add" class="com.example.HelloWorld"></action>
2. 感叹号方式如下
	<package name="default" namespace="/" extends="struts-default" strict-method-invocation="false">
		<action name="HelloWorld" class="com.example.action.HelloWorldAction">
			<result>/result.jsp</result>
			<result name="add">/add.jsp</result>
		</action>
	</package>
	<constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
3. 通配符方式如下:
	<package name="default" namespace="/" extends="struts-default" strict-method-invocation="false">
		<action name="HelloWorld_*" method="{1}" class="com.example.action.{1}Action">
			<result>/result.jsp</result>
			<result name="add">/{1}.jsp</result>
		</action>
	</package>
即用_*做通配符，花括号里加数字表示通配符参数个数

注意

1.感叹号方法

   除了要常量<constant .../>，还要在<package>中增加属性：strict-method-invocation="false"

2.通配符方法

   不需要常量<constant.../>，但要在<package>中增加属性：strict-method-invocation="false"

即：<package name="default" namespace="/" extends="struts-default" strict-method-invocation="false">


配置默认action

通过<default-action-ref name=""></default-action-ref>指定默认action，这用用途比如能使找不到页面时调到错误处理的一个友好界面



修改url中后缀

在struts结点内添加这样一个子结点<constant name="struts.action.extention" value="html"></constant>,其中value即指定后缀，也可以在struts.properties或web.xml中的过滤器中配置

struts中接收参数有三种方式

1. 使用action的属性接收   直接在方法中接收
2. 使用DomainModle接收   建立Javabean，直接在页面上定Javabean的属性
3. 使用ModelDriven接收   继承ModelDriven接口，通过接口泛型决定参数的属性

处理结果类型

1. SUCCESS action正确的执行完，返回相应的视图，success是name属性的默认值
2. NONE 表示action正确执行完成，但不返回任何视图
3. ERROR 表示action执行失败，返回错误的处理视图
4. LOGIN action因为用户没有登录的原因没有正确执行，将返回该登录视图，要求用户进行登录验证
5. INPUT action的执行，需要从前端界面获取参数，INPUT就是代表这个参数的输入界面，一般在应用中。会对这些参数进行验证，如果验证没有通过，将自动返回该视图

result标签实际还有param子标签
<param>具有两个属性:
1.location  该属性定义了该视图对应的实际视图资源
2. parse  该参数指定是否可以存在视图中使用OGNL表达式 ，struts默认是true





