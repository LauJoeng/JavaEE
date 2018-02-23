package com.yang.transaction;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static BookShopDao bookShopDao = ctx.getBean(BookShopDao.class);
	private static BookShopService bookShopService = ctx.getBean(BookShopService.class);
	private static Cashier cashier = ctx.getBean(Cashier.class);
	
	public static void  main(String[] args) {
//		testBookShopDaoFindPriceByIsbn();
//		testBookShopDaoUpdateBookStock();
//		testBookShopDaoUpdateUserAccount();
//		testBookShopService();
		testTransactionPropagation();
	}
	
	public static void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}
	
	public static void testBookShopDaoUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}
	
	public static void testBookShopDaoUpdateUserAccount() {
		bookShopDao.updateUserAccount("Anna", 100000);
	}
	
	public static void testBookShopService() {
		bookShopService.purchase("Anna", "1001");
	}
	
	public static void testTransactionPropagation() {
		cashier.checkout("Anna", Arrays.asList("1001","1002"));
	}
}
