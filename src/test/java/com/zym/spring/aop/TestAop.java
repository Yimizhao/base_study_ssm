package com.zym.spring.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zym.spring.aop.service.BaseService;

public class TestAop {
	ApplicationContext context;

	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring_config.xml");
	}

	@Test
	public void testAdcice() {
		BaseService personProxy = (BaseService) context.getBean("personProxy");
		personProxy.eat();
		personProxy.toilet();
	}
	
	@After
	public void end() {
		context = null;
	}

}
