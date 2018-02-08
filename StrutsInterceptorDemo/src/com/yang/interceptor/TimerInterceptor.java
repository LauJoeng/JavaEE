package com.yang.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 计算执行action花费的时间
 * @author Yang
 *
 */
public class TimerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long start = System.currentTimeMillis();
		String result = invocation.invoke();
		long end = System.currentTimeMillis();
		System.out.println("执行action花费时间："+(end-start)+"ms");
		return result;
	}

}
