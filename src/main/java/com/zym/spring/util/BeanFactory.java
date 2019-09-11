package com.zym.spring.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BeanFactory {

	List<BeanDefinited> beanDefinitedList;

	Map<String, Object> springIoc = new HashMap<>();
	
	BeanPostProcessor beanPostProcessor;

	public BeanFactory(List<BeanDefinited> beanDefinitedList) throws Exception {
		this.beanDefinitedList = beanDefinitedList;

		for (BeanDefinited beanDefinited : beanDefinitedList) {
			if ("singleton".equals(beanDefinited.getScope())) {
				Class<?> beanClass = Class.forName(beanDefinited.getClazz());
				Object instance = beanClass.newInstance();
				List<Property> propertys = beanDefinited.getPropertys();
				for (Property property : propertys) {
					String name = property.getName();
					Object value = property.getValue();
					Field field = beanClass.getDeclaredField(name);
					field.setAccessible(true);
					field.set(instance, value);
				}
				
				if (beanClass == BeanPostProcessor.class) {
					beanPostProcessor = (BeanPostProcessor) instance;
				} else {
					
					springIoc.put(beanDefinited.getId(), instance);
				}
			}
		}
	}

	public Object getBean(String classId) throws Exception {

		Object result = null;

		for (BeanDefinited beanDefinited : beanDefinitedList) {
			if (classId.equals(beanDefinited.getId())) {
				if ("prototype".equals(beanDefinited.getScope())) {
					Class<?> beanClass = Class.forName(beanDefinited.getClazz());
					Object instance = beanClass.newInstance();
					List<Property> propertys = beanDefinited.getPropertys();
					for (Property property : propertys) {
						String name = property.getName();
						Object value = property.getValue();
						Field field = beanClass.getDeclaredField(name);
						field.setAccessible(true);
						field.set(instance, value);
					}
					result = instance;
				} else {
					result = springIoc.get(beanDefinited.getId());
				}
			}
		}
		
//		if (Objects.nonNull(beanPostProcessor)) {
//			
//			Proxy.newProxyInstance(result.getClass().getClassLoader(), result.getClass().getGenericInterfaces() , new InvocationHandler() {
//				
//				@Override
//				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//					beanPostProcessor.postProcessBeforeInitialization(result, classId);
//					beanPostProcessor.postProcessAfterInitialization(result, classId);
//					method.invoke(result, args);
//					return null;
//				}
//			})
//		}
		
		return result;
	}

}
