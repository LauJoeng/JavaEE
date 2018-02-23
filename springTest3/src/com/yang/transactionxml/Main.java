package com.yang.transactionxml;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.transactionxml.service.BookShopService;
import com.yang.transactionxml.service.Cashier;

public class Main {
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
	private static BookShopDao bookShopDao = ctx.getBean(BookShopDao.class);
	private static BookShopService bookShopService = ctx.getBean(BookShopService.class);
	private static Cashier cashier = ctx.getBean(Cashier.class);
	
	public static void  main(String[] args) {
//		testBookShopService();
		testTransactionPropagation();
	}
	
	
	public static void testBookShopService() {
		bookShopService.purchase("Anna", "1001");
	}
	
	public static void testTransactionPropagation() {
		cashier.checkout("Anna", Arrays.asList("1001","1002"));
	}
}
