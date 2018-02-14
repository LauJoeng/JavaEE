package com.yang.cycle;

public class Car {
	public Car() {
		System.out.println("Car's constructor...");
	}
	
	private String brand;
	public void setBrand(String brand)
	{
		System.out.println("set brand...");
		this.brand = brand;
	}
	public void init() {
		System.out.println("init...");
	}
	public void destroy() {
		System.out.println("destroy...");
	}
}
