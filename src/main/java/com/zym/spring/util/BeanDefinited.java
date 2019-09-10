package com.zym.spring.util;

import java.util.List;
/*
 * 这个类等价于标签<bean>
 *
 */
public class BeanDefinited {
	private String id;

	private String clazz;

	private String scope = "singleton";

	private List<Property> propertys;

	public List<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}
