package com.yang.factory;

import java.util.HashMap;
import java.util.Map;


/*
 * 实例工厂方法:实力工厂的方法，即需要创建工厂本身，再调用工厂的实例方法来返回bean的实例
 */
public class InstanceCarFactory {
	private Map<String,Car>cars = null;
	public InstanceCarFactory() {
		cars = new HashMap<>();
		cars.put("audi", new Car("audi", 300000));
		cars.put("ford", new Car("ford", 400000));
	}
	
	public Car getCar(String name) {
		return cars.get(name);
	}
}
