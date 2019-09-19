package com.zym.spring.aop.pojo;

import org.springframework.stereotype.Component;

@Component
public class BehaviorAdvice {


	
	public void before() {
		System.out.println("饭前请洗手");
	}
	
	
	public void after() {
		System.out.println("便后请洗手");
	}
	
	
}
