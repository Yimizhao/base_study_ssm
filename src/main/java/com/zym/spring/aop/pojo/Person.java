package com.zym.spring.aop.pojo;

import org.springframework.stereotype.Component;

@Component
public class Person {

	public void eat() {
		System.out.println("吃饭");

	}

	public void toilet() {
		System.out.println("方便");

	}

}
