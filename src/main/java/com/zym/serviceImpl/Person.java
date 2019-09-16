package com.zym.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zym.service.Behavior;
@Component
public class Person implements Behavior {
	
	@Autowired
	public Dog dog;

	@Override
	public void eat() {
		System.out.println("用筷子......");

	}
	@Override
	public void toilet() {
		System.out.println("排泄.......");
	}
	
	public Person() {
		System.out.println("Person");
	}
}
