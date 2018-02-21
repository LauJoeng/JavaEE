package com.yang.aoptest2;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 可以使用@Order注解指定切面优先级，值越小优先级越高
 * @author Yang
 *
 */
@Order(2)
@Component
@Aspect
public class LoggingAspect2 {
	
	/*
	 * 定义一个，用于声明切入点表达式，一般的，该方法中再不需要添加其他代码
	 * 使用@Pointcut来声明切入点表达式
	 * 后面的其他通知直接使用方法名来引用当前的切入点表达式
	 */
	@Pointcut("execution(public int com.yang.aoptest2.ArithmeticCalculator.*(..))")
	public void declareJoinPointExpression() {}
	
	/*
	 * 在com.yang.aoptest2.ArithmeticCalculator 接口的每一个实现类的每一个方法开始之前执行一段代码
	 */
	@Before("declareJoinPointExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("the method begins with "+Arrays.asList(args));
	}
	
	@After("execution(public int com.yang.aoptest2.ArithmeticCalculator.*(..))")
	public void afterMethod(JoinPoint joinPoint)
	{
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" ends");
	}
	
	/*
	 * 在方法正常结束执行的代码
	 * 返回通知是可以返回方法执行的值
	 */
	@AfterReturning(value="execution(public int com.yang.aoptest2.ArithmeticCalculator.*(..))",returning="result")
	public void afterRunning(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" ends with "+ result);
	}
	
	/*
	 * 在目标方法出现异常时会执行的代码
	 * 可以访问到异常对象，且可以指定在出现特定异常时再执行通知代码
	 */
	@AfterThrowing(value="execution(public int com.yang.aoptest2.ArithmeticCalculator.*(..))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" occur with exception: "+ ex);
	}
	
	/*
	 * 环绕通知需要携带ProceedingJoinPoint类型的参数
	 * 环绕通知类似于动态代理的全过程:ProceedingJoinPoint类型的参数可以决定是是否执行目标方法
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 */
	@Around("execution(public int com.yang.aoptest2.ArithmeticCalculator.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjd) {
		System.out.println("aroundMethod");
		String methodName = pjd.getSignature().getName();
		//执行目标方法
		Object result = null;
		try {
			//前置通知
			System.out.println("the method "+methodName+" begins with "+Arrays.asList(pjd.getArgs()));
			result = pjd.proceed();
			//返回通知
			System.out.println("the method "+methodName+" ends with "+result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("the method occurs with exception: "+e);
		}
		//后置通知
		System.out.println("the method "+methodName+" ends");
		return result;
	}
}
