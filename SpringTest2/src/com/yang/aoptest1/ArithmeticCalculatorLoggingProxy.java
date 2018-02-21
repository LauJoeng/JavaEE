package com.yang.aoptest1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
	private ArithmeticCalculator target;
	
	
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}



	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;
		Class[] interfaces = new Class[] {ArithmeticCalculator.class};
		//当调用代理对象其中的方法时，应该执行的代码
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * proxy：正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象
			 * method:正在被调用的方法
			 * args:调用方法时传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//日志
				System.out.println("the method"+method.getName()+"begins with"+Arrays.asList(args));
				//执行方法
				Object result = method.invoke(target, args);
				//日志
				System.out.println("the method"+method.getName()+"ends with"+result);
				return result;
			}
		};
		ClassLoader loader = target.getClass().getClassLoader();
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
