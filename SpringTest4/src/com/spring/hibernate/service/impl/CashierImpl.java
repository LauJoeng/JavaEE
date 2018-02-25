package com.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.hibernate.service.BookShopService;
import com.spring.hibernate.service.Cashier;

@Service
public class CashierImpl implements Cashier{

	private BookShopService bookShopService;
	
	@Override
	public void checkout(String username, List<String> isbns) {
		for(String isbn:isbns) {
			bookShopService.purchase(username, isbn);
		}
	}

}
