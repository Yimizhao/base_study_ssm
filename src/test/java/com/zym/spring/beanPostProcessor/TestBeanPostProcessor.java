package com.zym.spring.beanPostProcessor;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zym.spring.beans.Student;

public class TestBeanPostProcessor {
	
	ApplicationContext context;
	
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring_config.xml");
	}
	
	@Test
	public void testMyBeanPostProcessor() {
		
		Student student = (Student) context.getBean("student");
		student.study();
	}


}
