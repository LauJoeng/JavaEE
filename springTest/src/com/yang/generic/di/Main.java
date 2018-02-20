package com.yang.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-generic.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		userService.add();

	}

}
