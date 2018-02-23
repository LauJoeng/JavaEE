package com.yang.transactionxml.service.impl;

import com.yang.transactionxml.BookShopDao;
import com.yang.transactionxml.service.BookShopService;

public class BookShopServiceSImpl implements BookShopService {
	
	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}

	@Override
	public void purchase(String username, String isbn) {
		//1.获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		//3.更新用户余额
		bookShopDao.updateUserAccount(username, price);
	}

}
