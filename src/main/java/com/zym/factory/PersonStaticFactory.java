package com.zym.factory;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.zym.serviceImpl.Person;

public class PersonStaticFactory {

	@Autowired
	public static Person person;

	public static Person getPerson() {

		if (Objects.isNull(person)) {
			
			System.out.println("PersonStaticFactory");

			return new Person();
		}
		return person;
	}
}
