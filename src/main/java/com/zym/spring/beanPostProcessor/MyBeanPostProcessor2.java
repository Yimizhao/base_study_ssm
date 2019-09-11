package com.zym.spring.beanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.zym.spring.service.BaseService;
import com.zym.spring.serviceImpl.CServiceImpl;
import com.zym.spring.util.BeanPostProcessor;

public class MyBeanPostProcessor2 implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object beanInstance, String beanName) {
		System.out.println("初始化之前。。。。。");
		Class<?> beanClass = beanInstance.getClass();
		if (beanClass == CServiceImpl.class) {
			return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
					new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							String value = (String) method.invoke(beanInstance, args);
							return value.toUpperCase();
						}
					});
		}
		return beanInstance;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("初始化化之后。。。。。。");
		return bean;
	}

}
