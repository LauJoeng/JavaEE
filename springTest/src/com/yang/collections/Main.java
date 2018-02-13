package com.yang.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) ctx.getBean("person2");
		System.out.println(person);
		
		NewPerson newPerson = ctx.getBean(NewPerson.class);
		System.out.println(newPerson);
		
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource);
		
		Person person3 = (Person) ctx.getBean("person3");
		System.out.println(person3);
		
		Person person4 = (Person) ctx.getBean("person4");
		System.out.println(person4);
	}

}
