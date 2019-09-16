package com.zym.factory;

import com.zym.serviceImpl.Person;

public class PersonFactory {

	public Person getPerson() {
		
		return new Person();
	}

	public PersonFactory() {
		System.out.println("PersonFactory");
	}
	
}
