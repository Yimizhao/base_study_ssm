package com.zym.spring.aop.MyAdvice;

import java.lang.reflect.Method;

public class MyAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("洗手。。。。。。。。。。。");

	}

}
