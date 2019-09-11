package com.zym.spring.beanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.config.BeanPostProcessor;

import com.zym.spring.service.BaseService;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("初始化之前执行。。。。。");
		Object proxyInstance = bean;
		if (bean instanceof BaseService) {
			proxyInstance = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
					new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							String value = (String) method.invoke(bean, args);
							return value.toUpperCase();
						}
					});
		}
		return proxyInstance;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("初始化之后执行。。。。。");
		return bean;
	}

}
