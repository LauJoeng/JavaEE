package com.yang.aoptest3;

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

public class LoggingAspect2 {
	
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
	
	public void afterReturning(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" ends with "+ result);
	}
	
	public void afterThrowing(JoinPoint joinPoint,Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" occur with exception: "+ ex);
	}
	
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
