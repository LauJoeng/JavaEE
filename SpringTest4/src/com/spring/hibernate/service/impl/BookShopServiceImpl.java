package com.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.dao.BookShopDao;
import com.spring.hibernate.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService{

	@Autowired
	private BookShopDao bookShopDao;
	
	/*
	 * Spring Hibernate 事务的流程
	 * 1.在方法开始之前
	 * ①获取session
	 * ②把session和当前线程绑定，这样就可以在Dao中使用SessionFactory的getCurrentSession()方法来获取session了
	 * ③开启事务
	 * 
	 * 2.若方法正常结束，即没有出现异常，则
	 * ①提交事务
	 * ②使和当前线程绑定的Session接触绑定
	 * ③关闭session
	 * 
	 * 3.若方法出现异常，则
	 * ①回滚事务
	 * ②使和当前线程绑定的Session接触绑定
	 * ③关闭session
	 */
	@Override
	public void purchase(String username, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}

}
