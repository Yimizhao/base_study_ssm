package com.zym.spring.util;

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

				isProcessor(instance, beanDefinited);

				springIoc.put(beanDefinited.getId(), instance);
			}
		}
	}

	private void isProcessor(Object instance, BeanDefinited beanDefinited) {
		if (instance instanceof BeanPostProcessor) {
			beanPostProcessor = (BeanPostProcessor) instance;
		}
	}

	public Object getBean(String classId) throws Exception {

		Object result = null;
		for (BeanDefinited beanDefinited : beanDefinitedList) {
			if (classId.equals(beanDefinited.getId())) {
				if ("prototype".equals(beanDefinited.getScope())) {
					Class<?> beanClass = Class.forName(beanDefinited.getClazz());
					Object instance = beanClass.newInstance();
					result = instance;
				} else {
					result = springIoc.get(beanDefinited.getId());
				}
			}
		}

		if (Objects.nonNull(beanPostProcessor)) {
			result = beanPostProcessor.postProcessBeforeInitialization(result, classId);

			result = beanPostProcessor.postProcessAfterInitialization(result, classId);
		}

		return result;
	}

}
