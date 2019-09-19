package com.zym.spring.aop.classic;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class BehaviorAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("便后要洗手");

	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("饭前要洗手");
	}

}
