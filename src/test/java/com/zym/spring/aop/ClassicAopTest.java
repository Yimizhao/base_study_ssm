package com.zym.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zym.spring.aop.classic.Behavior;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springClassicAOP-configuration.xml")
public class ClassicAopTest {

	@Autowired
	Behavior beheviorProxy;
//	ApplicationContext context;

	@Test
	public void testClassicAop() {
//		Behavior person = (Behavior) context.getBean("beheviorProxy");
		beheviorProxy.eat();
		beheviorProxy.toilet();
	}

}
