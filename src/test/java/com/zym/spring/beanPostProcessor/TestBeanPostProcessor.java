package com.zym.spring.beanPostProcessor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.zym.spring.beans.Teacher;
import com.zym.spring.service.BaseService;
import com.zym.spring.util.BeanDefinited;
import com.zym.spring.util.BeanFactory;
import com.zym.spring.util.Property;

public class TestBeanPostProcessor {

	ApplicationContext context;
	BeanFactory beanFactory;

	@Before
	public void init() throws Exception {
		// spring后置处理器
		// context = new ClassPathXmlApplicationContext("spring_config.xml");

		List<BeanDefinited> xmltConfigurion = new ArrayList<BeanDefinited>();
		// 自定义后置处理器
		// BeanDefinited cServiceInstance = new BeanDefinited();
		// cServiceInstance.setId("cService");
		// cServiceInstance.setClazz("com.zym.spring.serviceImpl.CServiceImpl");
		// xmltConfigurion.add(cServiceInstance);

//		 BeanDefinited myBeanPostProcessorBean = new BeanDefinited();
//		 myBeanPostProcessorBean.setClazz("com.zym.spring.beanPostProcessor.MyBeanPostProcessor2");
//		 xmltConfigurion.add(myBeanPostProcessorBean);

		// DI的自定义
		BeanDefinited techerBeanDefinited = new BeanDefinited();
		techerBeanDefinited.setId("teacher");
		techerBeanDefinited.setClazz("com.zym.spring.beans.Teacher");
		Property techerNameProperty = new Property();
		Property techerAgeProperty = new Property();
		Property techerSchoolsProperty = new Property();
		Property techerFrendsProperty = new Property();
		techerNameProperty.setName("name");
		techerNameProperty.setValue("赵颖铭");
		techerAgeProperty.setName("age");
		techerAgeProperty.setValue("30");
		techerSchoolsProperty.setName("schools");
		techerSchoolsProperty.setValue("清丰一中,大连工业大学");
		techerFrendsProperty.setName("frends");
		techerFrendsProperty.setValue("毛泽东,江泽民,胡锦涛,习近平");
		List<Property> properties = new ArrayList<Property>();
		properties.add(techerNameProperty);
		properties.add(techerAgeProperty);
		properties.add(techerSchoolsProperty);
		properties.add(techerFrendsProperty);
		techerBeanDefinited.setPropertys(properties);
		techerBeanDefinited.setScope("prototype");
		xmltConfigurion.add(techerBeanDefinited);
		beanFactory = new BeanFactory(xmltConfigurion);
	}

	@Test
	public void testMyBeanPostProcessor() {

		BaseService cService = (BaseService) context.getBean("cService");
		System.out.println(cService.doSomething());
	}

	@Test
	public void testMyBeanPostProcessor1() throws Exception {

		BaseService cService = (BaseService) beanFactory.getBean("cService");
		System.out.println(cService.doSomething());
	}

	@Test
	public void testMyDI() throws Exception {

		Teacher teacher = (Teacher) beanFactory.getBean("teacher");
		Teacher teacher1 = (Teacher) beanFactory.getBean("teacher");
		System.out.println("teacher : " + teacher);
		System.out.println("teacher1 : " + teacher1);
		System.out.println("teacher == : teacher1 : " + (teacher == teacher1));
	}

}
