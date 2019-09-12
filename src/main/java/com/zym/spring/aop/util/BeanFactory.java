package com.zym.spring.aop.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.zym.spring.aop.MyAdvice.Advice;
import com.zym.spring.aop.MyAdvice.AdviceProxyFctory;
import com.zym.spring.aop.MyAdvice.ProxyBean;
import com.zym.spring.util.BeanDefinited;
import com.zym.spring.util.BeanPostProcessor;
import com.zym.spring.util.Property;

public class BeanFactory {

	List<BeanDefinited> beanDefinitedList;

	Map<String, Object> springIoc = new HashMap<>();

	BeanPostProcessor beanPostProcessor;

	Advice advice;

	public BeanFactory(List<BeanDefinited> beanDefinitedList) throws Exception {
		this.beanDefinitedList = beanDefinitedList;

		for (BeanDefinited beanDefinited : beanDefinitedList) {
			if ("singleton".equals(beanDefinited.getScope())) {
				Class<?> beanClass = Class.forName(beanDefinited.getClazz());
				Object instance = beanClass.newInstance();

				setParamete(instance, beanDefinited.getPropertys());

				isProcessor(instance, beanDefinited);

				isAdvice(instance, beanDefinited);

				springIoc.put(beanDefinited.getId(), instance);
			}
		}
		creatAdviceProxy();
	}

	private void creatAdviceProxy() {
		if (Objects.nonNull(advice)) {

			Set<String> keys = springIoc.keySet();

			String adviceKeyName = "";

			for (String key : keys) {
				if (springIoc.get(key) == advice) {
					adviceKeyName = key;
				}
			}

			Collection<Object> values = springIoc.values();

			for (Object instance : values) {
				if (instance instanceof ProxyBean) {
					ProxyBean proxyBean = (ProxyBean) instance;
					if (Arrays.asList(proxyBean.getInterceptorNames()).contains(adviceKeyName)) {
						Object result = AdviceProxyFctory.creatAdviceProxyBean(springIoc.get(proxyBean.getTarget()),
								advice);
						for (String key : keys) {
							if (springIoc.get(key) == instance) {
								springIoc.put(key, result);
								break;
							}
						}
						break;
					}
				}
			}

		}

	}

	private void isAdvice(Object instance, BeanDefinited beanDefinited) {
		if (instance instanceof Advice) {
			advice = (Advice) instance;
		}

	}

	private void setParamete(Object instance, List<Property> propertys) throws Exception {
		Class<?> beanClass = instance.getClass();
		Field[] declaredFields = beanClass.getDeclaredFields();
		if (Objects.isNull(propertys) || propertys.isEmpty() || Objects.isNull(declaredFields)
				|| declaredFields.length == 0) {
			return;
		}

		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			String fieldName = field.getName();
			Method setFieldMethod = null;
			Property fieldProperty = null;

			for (Property property : propertys) {
				String propertyName = property.getName();
				if (propertyName.equals(fieldName)) {
					fieldProperty = property;
					break;
				}
			}

			if (Objects.isNull(fieldProperty)) {
				break;
			}

			Method[] methods = beanClass.getMethods();
			String setFieldMethodName = "set" + fieldName;
			for (int j = 0; j < methods.length; j++) {
				String methodName = methods[j].getName();
				if (methodName.equalsIgnoreCase(setFieldMethodName)) {
					setFieldMethod = methods[j];
					break;
				}
			}
			if (Objects.isNull(setFieldMethod)) {
				break;
			}
			String propertyValue = fieldProperty.getValue();
			String fieldTypeName = field.getType().getName();
			if (Integer.class.getTypeName().equals(fieldTypeName)) {
				setFieldMethod.invoke(instance, Integer.valueOf(propertyValue));
			} else if (Boolean.class.getTypeName().equals(fieldTypeName)) {
				setFieldMethod.invoke(instance, Boolean.valueOf(propertyValue));
			} else if (List.class.getTypeName().equals(fieldTypeName)) {
				String[] valueArray = propertyValue.split(",");
				setFieldMethod.invoke(instance, Arrays.asList(valueArray));
			} else if (String.class.getTypeName().equals(fieldTypeName)) {
				setFieldMethod.invoke(instance, propertyValue);

			} else {
				String[] valueArray = propertyValue.split(",");
				Object setMethodParameta[] = { valueArray };
				setFieldMethod.invoke(instance, setMethodParameta);
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
			List<Property> propertys = beanDefinited.getPropertys();

			if (classId.equals(beanDefinited.getId())) {
				if ("prototype".equals(beanDefinited.getScope())) {
					Class<?> beanClass = Class.forName(beanDefinited.getClazz());
					result = beanClass.newInstance();
					setParamete(result, propertys);
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
