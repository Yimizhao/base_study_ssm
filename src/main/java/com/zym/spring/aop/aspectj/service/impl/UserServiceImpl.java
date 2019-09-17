package com.zym.spring.aop.aspectj.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.zym.spring.aop.aspectj.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void saveUser() {

		System.out.println("保存user对象");

	}

	/**
	 * 最终目标类中的方法会被springAOP 利用反射包装成下面的形式并生成一个代理类
	 */
//	InvocationHandler() {
	
//	Object obj;
//	public InvocationHandler(Object obj){
//		this.obj = obj;
//	}
//		
//	@Override
//	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		Object value;
		//try {
			//try {
			//	System.out.println("前置通知");(调用前置通知)
			//	value =  mthod.invoke(obj, args)
			//} finally {
			//	System.out.println("最终通知");(调用最终通知)
			//}
			//System.out.println("后置通知");(调用后置通知)
		//} catch (Exception e) {
		//System.out.println("异常通知");(调用异常通知)
		//}
//
//		return value;
//	}
//};

}
