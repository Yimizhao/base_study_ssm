package com.zym.spring.aop.MyAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AdviceProxyFctory {
	
	public static Object creatAdviceProxyBean(Object obj, Advice advice) {
		
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object value = null;
				if (advice instanceof MethodBeforeAdvice) {
					((MethodBeforeAdvice) advice).before(method, args, obj);
					value = method.invoke(obj, args);
				} else if(advice instanceof AfterReturningAdvice){
					value = method.invoke(obj, args);
					((AfterReturningAdvice) advice).afterReturning(value, method, args, obj);
				} 
				return value;
			}
		});
		
	}
}
