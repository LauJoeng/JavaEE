package com.yang.transactionxml;

public interface BookShopDao {
	
	//根据书单号获取书的单价
	public int findBookPriceByIsbn(String isbn);
	
	//更新库存  
	public void updateBookStock(String isbn);
	
	//更新用户账户的余额，是username的账户余额减少price
	public void updateUserAccount(String username,int price);
}
