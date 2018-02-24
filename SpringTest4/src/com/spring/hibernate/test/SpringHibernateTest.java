package com.spring.hibernate.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.hibernate.service.BookShopService;


public class SpringHibernateTest {
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static BookShopService bookShopService = ctx.getBean(BookShopService.class);
	
	public static void main(String[] args) throws SQLException {
//		testDataSource();
		testBookShopService();
	}
	
	public static void testDataSource() throws SQLException {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	
	public static void testBookShopService() {
		bookShopService.purchase("Anna", "1001");
	}
}
