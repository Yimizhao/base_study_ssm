package com.zym.spring.beanPostProcessor;

import org.springframework.beans.factory.config.BeanPostProcessor;

import com.zym.spring.beans.Student;

public class MyBeanPostProcessor2 implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		
		if (beanName.equals("student")) {
			Student student = (Student) bean;
			student.study().toUpperCase();
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		return bean;
	}

}
