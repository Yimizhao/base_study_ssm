package com.zym.spring.aop.MyAdvice;

public interface MethodInterceptor extends Advice {
	Object invoke(Object invocation) throws Throwable;
}
