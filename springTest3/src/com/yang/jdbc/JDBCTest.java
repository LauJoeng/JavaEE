package com.yang.jdbc;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JDBCTest {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	
	public static void main(String[] args) {
		
	}
	
	@Test
	public void test() {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}
}
