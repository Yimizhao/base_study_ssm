package com.zym.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zym.service.Behavior;

@Component
public class Dog implements Behavior {
	
	@Autowired
	Collar collar;

	@Override
	public void eat() {
		System.out.println("啃骨头");

	}

	@Override
	public void toilet() {
		System.out.println("三立");

	}
	
	public Dog() {
		System.out.println("Dog");
	}

}
