package com.yang.scope;

import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.autowire.Address;
import com.yang.autowire.Car;
import com.yang.autowire.Person;

public class Main {

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
		
		Car car = (Car) ctx.getBean("car");
		Car car2 = (Car) ctx.getBean("car");
		
		System.out.println(car == car2); //返回true
		
		
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext("bean-properties.xml");
		DataSource dataSource = (DataSource) ctx2.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}

}
