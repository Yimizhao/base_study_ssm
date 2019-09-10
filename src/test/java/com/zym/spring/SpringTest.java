package com.zym.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zym.spring.beans.Student;
import com.zym.spring.beans.Teacher;
import com.zym.spring.util.BeanDefinited;
import com.zym.spring.util.BeanFactory;
import com.zym.spring.util.Property;

public class SpringTest {

	@Test
	public void testBeanFactory() {

		ApplicationContext aContext = new ClassPathXmlApplicationContext("spring_config.xml");
		Teacher teacher = (Teacher) aContext.getBean("teacher");
		System.out.println(teacher);
	}

	@Test
	public void testMyBeanFactory() throws Exception {

		BeanDefinited beanDefinited = new BeanDefinited();
		List<Property> propertys = new ArrayList<Property>();
		Property nameProperty = new Property();
		Property ageProperty = new Property();
		List<BeanDefinited> definiteds = new ArrayList<BeanDefinited>();
		
		
		
		// <bean id="teacher" class="com.zym.spring.beans.Teacher"
		// scope="prototype"></bean>
		// 定义标签的过程
		beanDefinited.setClazz("com.zym.spring.beans.Teacher");
		beanDefinited.setId("teacher");
		beanDefinited.setScope("prototype");
		nameProperty.setName("name");
		nameProperty.setValue("YImi");
		ageProperty.setName("age");
		ageProperty.setValue(26);
		propertys.add(nameProperty);
		propertys.add(ageProperty);
		beanDefinited.setPropertys(propertys);
		
		
		
		// <bean id="student" class="com.zym.spring.beans.Student"
		// scope="singleton"></bean>
		BeanDefinited beanDefinited1 = new BeanDefinited();
		Property nameProperty1 = new Property();
		Property ageProperty1 = new Property();
		List<Property> propertys1 = new ArrayList<Property>();
		beanDefinited1.setClazz("com.zym.spring.beans.Student");
		beanDefinited1.setId("student");
		nameProperty1.setName("name");
		nameProperty1.setValue("jony");
		ageProperty1.setName("age");
		ageProperty1.setValue(13);
		propertys1.add(nameProperty1);
		propertys1.add(ageProperty1);
		beanDefinited1.setPropertys(propertys1);
		
		// 相当于XML的配置文件
		definiteds.add(beanDefinited);
		definiteds.add(beanDefinited1);
		
		// 等价于将配置文件中的bean注入容器
		BeanFactory beanFactory = new BeanFactory(definiteds);
		Teacher teacher = (Teacher) beanFactory.getBean("teacher");
//		Teacher teacher1 = (Teacher) beanFactory.getBean("teacher");
		Student student = (Student) beanFactory.getBean("student");
		System.out.println(teacher);
		System.out.println(student);
//		Student student1 = (Student) beanFactory.getBean("student");
//		System.out.println("teacher == teacher:" + (teacher == teacher1));
//		System.out.println("student == student:" + (student == student1));
	}

}
