package com.zym.spring.beanPostProcessor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zym.spring.beans.Student;
import com.zym.spring.service.BaseService;
import com.zym.spring.util.BeanDefinited;
import com.zym.spring.util.BeanFactory;

public class TestBeanPostProcessor {

	ApplicationContext context;
	BeanFactory beanFactory;

	@Before
	public void init() throws Exception {
		// spring后置处理器
		 context = new ClassPathXmlApplicationContext("spring_config.xml");
		
		// 自定义后置处理器
//		List<BeanDefinited> xmltConfigurion = new ArrayList<BeanDefinited>();
//		BeanDefinited studentBean = new BeanDefinited();
//		studentBean.setId("student");
//		studentBean.setClazz("com.zym.spring.beans.Student");
//		xmltConfigurion.add(studentBean);
//
//		BeanDefinited beanPostProcessorBean = new BeanDefinited();
//		beanPostProcessorBean.setClazz("com.zym.spring.beanPostProcessor.MyBeanPostProcessor2");
//		xmltConfigurion.add(beanPostProcessorBean);
//
//		beanFactory = new BeanFactory(xmltConfigurion);
	}

	@Test
	public void testMyBeanPostProcessor() {

		BaseService cService = (BaseService) context.getBean("cService");
		System.out.println(cService.doSomething());
	}

	@Test
	public void testMyBeanPostProcessor1() throws Exception {

		Student student = (Student) beanFactory.getBean("student");
		student.study();
	}

}
