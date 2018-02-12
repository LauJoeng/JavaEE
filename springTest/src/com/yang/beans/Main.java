package com.yang.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//1.创建spring的IOC容器对象
		//ApplicationContext 代表IOC容器
		//ClassPathXmlApplicationContext 是ApplicationContext接口的实现类，该实现类从类路径下来加载配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2。从IOC容器中获取bean实例
		//利用id获取IOC容器中的bean
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		//用这种方式获得bean要求在配置文件中只能有一个该类的配置
		HelloWorld helloWorld2 = ctx.getBean(HelloWorld.class);
		helloWorld.hello();
		
		Car car = (Car) ctx.getBean("car2");
		System.out.println(car);
		
		Person person = ctx.getBean(Person.class);
		System.out.println(person);
	}

}
