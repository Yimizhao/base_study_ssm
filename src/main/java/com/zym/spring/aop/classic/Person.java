package com.zym.spring.aop.classic;

public class Person implements Behavior {

	@Override
	public void eat() {
		System.out.println("吃饭");

	}

	@Override
	public void toilet() {
		System.out.println("方便");

	}

}
