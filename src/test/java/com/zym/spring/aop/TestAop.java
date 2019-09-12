package com.zym.spring.aop;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zym.spring.aop.service.BaseService;
import com.zym.spring.aop.util.BeanFactory;
import com.zym.spring.util.BeanDefinited;
import com.zym.spring.util.Property;

public class TestAop {
	ApplicationContext context;
	BeanFactory beanFactory;

	@Before
	public void init() throws Exception {
//		context = new ClassPathXmlApplicationContext("spring_config.xml");
		// 目标对象
		BeanDefinited personInstanceDefinied = new BeanDefinited();
		personInstanceDefinied.setId("person");
		personInstanceDefinied.setClazz("com.zym.spring.aop.serviceImpl.Persion");
		
		// 切面
		BeanDefinited myAdciceInstanceDefinied = new BeanDefinited();
		myAdciceInstanceDefinied.setId("myAdcice");
		myAdciceInstanceDefinied.setClazz("com.zym.spring.aop.MyAdvice.MyAdvice");
		
		// 织入
		BeanDefinited personProxyInstanceDefinied = new BeanDefinited();
		personProxyInstanceDefinied.setId("personProxy");
		personProxyInstanceDefinied.setClazz("com.zym.spring.aop.MyAdvice.ProxyBean");
		List<Property> propertys = new ArrayList<Property>();
		Property targetProperty = new Property();
		targetProperty.setName("target");
		targetProperty.setValue("person");
		propertys.add(targetProperty);
		Property interceptorNamesProperty = new Property();
		interceptorNamesProperty.setName("interceptorNames");
		interceptorNamesProperty.setValue("myAdcice");
		propertys.add(interceptorNamesProperty);
		personProxyInstanceDefinied.setPropertys(propertys);
		
		List<BeanDefinited> beanDefinitedList = new ArrayList<>();
		beanDefinitedList.add(personInstanceDefinied);
		beanDefinitedList.add(myAdciceInstanceDefinied);
		beanDefinitedList.add(personProxyInstanceDefinied);
		beanFactory= new BeanFactory(beanDefinitedList);
	}

	@Test
	public void testAdcice() {
		BaseService personProxy = (BaseService) context.getBean("personProxy");
		personProxy.eat();
		personProxy.toilet();
	}
	@Test
	public void testMyAdcice() throws Exception {
		BaseService personProxy = (BaseService) beanFactory.getBean("personProxy");
		personProxy.eat();
		personProxy.toilet();
	}
	
	@After
	public void end() {
		context = null;
	}

}
