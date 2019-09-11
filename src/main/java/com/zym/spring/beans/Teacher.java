package com.zym.spring.beans;

import java.util.Arrays;
import java.util.List;

public class Teacher {

	private String name;
	private Integer age;

	private String schools[];

	private List<String> frends;

	public String[] getSchools() {
		return schools;
	}

	public void setSchools(String[] schools) {
		this.schools = schools;
	}

	public List<String> getFrends() {
		return frends;
	}

	public void setFrends(List<String> frends) {
		this.frends = frends;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", schools=" + Arrays.toString(schools) + ", frends=" + frends
				+ "]";
	}
}
