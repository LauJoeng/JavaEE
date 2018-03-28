package com.yang.ajaxtest.bean;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private int totalBookNum;

    //存放ShoppingCartItem的Map。键：书名，值：ShoppingCartItem对象
    private Map<String,ShoppingCartItem>items = new HashMap<>();

    public void addToCart(String bookName,int price){
        if (items.containsKey(bookName)){
            ShoppingCartItem item = items.get(bookName);
            item.setNumber(item.getNumber()+1);
        }else{
            ShoppingCartItem item = new ShoppingCartItem();
            item.setBookName(bookName);
            item.setNumber(1);
            item.setPrice(price);
            items.put(bookName,item);
        }
    }

    public int getTotalBookNumber(){
        int total = 0;

        return total;
    }

    public int getTotalMoney(){
        int  money = 0;
        for(ShoppingCartItem item:items.values()){
            money+=item.getNumber()*item.getPrice();
        }
    }

}
