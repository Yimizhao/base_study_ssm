package com.zym.spring.aop.MyAdvice;

public class ProxyBean {

	private String target;
	private String[] interceptorNames;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String[] getInterceptorNames() {
		return interceptorNames;
	}

	public void setInterceptorNames(String[] interceptorNames) {
		this.interceptorNames = interceptorNames;
	}

}
