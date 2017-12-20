package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {
    private HashMap<Items, Integer> goods;
    private double totalPrice;

    public Cart() {
        goods = new HashMap<>();
        totalPrice = 0.0;
    }

    public boolean addGoodsInCart(Items item, int number) {
        if (goods.containsKey(item)) {
            goods.put(item, goods.get(item) + number);
        } else {
            goods.put(item, number);
        }
        calTotalPrice();
        return true;
    }

    public boolean removeGoodsFromCart(Items item) {
        goods.remove(item);
        return true;
    }

    public double calTotalPrice() {
        double sum = 0d;
        Set<Items> keys = goods.keySet();//获得键的集合
        Iterator<Items> it = keys.iterator();
        while (it.hasNext()) {
            Items i = it.next();
            sum += Double.valueOf(i.getPrice())*goods.get(i);
        }
        this.setTotalPrice(sum);
        return sum;
    }

    public HashMap<Items, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Items, Integer> goods) {
        this.goods = goods;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static void main(String[] args) {
        Items it1 = new Items(1, "特步球鞋", "温州", String.valueOf(200+""), 500, "001.jpg");
        Items it2 = new Items(2, "李林运动鞋", "广州", String.valueOf(300+""), 1500, "002.jpg");
        Items it3 = new Items(1, "特步球鞋", "温州", String.valueOf(200+""), 500, "001.jpg");

        Cart c = new Cart();
        c.addGoodsInCart(it1, 1);
        c.addGoodsInCart(it2, 2);
        c.addGoodsInCart(it3, 3);
        Set<Map.Entry<Items, Integer>> items = c.getGoods().entrySet();
        for (Map.Entry<Items, Integer> obj : items) {
            System.out.println(obj);
        }
        System.out.println("购物车总金额:"+c.getTotalPrice());

    }

}
