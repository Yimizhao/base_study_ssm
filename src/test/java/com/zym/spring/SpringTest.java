package com.zym.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zym.spring.beans.Teacher;

public class SpringTest {

	@Test
	public void testBeanFactory() {

		ApplicationContext aContext = new ClassPathXmlApplicationContext("spring_config.xml");
		Teacher teacher = (Teacher) aContext.getBean("teacher");
		System.out.println(teacher);
	}

}
