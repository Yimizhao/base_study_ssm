package com.zym.serviceImpl;

import com.zym.service.Behavior;

public class Person implements Behavior {

	@Override
	public void eat() {
		System.out.println("用筷子......");

	}

	@Override
	public void toilet() {
		System.out.println("排泄.......");
	}

}
