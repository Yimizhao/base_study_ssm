package com.zym.spring.beanPostProcessor;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("postProcessBeforeInitialization   beanName :" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("postProcessAfterInitialization   beanName :" + beanName);
		return bean;
	}

}
