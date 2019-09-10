package com.zym.dao;

public class Student {
	private Integer Id;
	private String name;
	private String location;
	private String gender;
	private Boolean flag;

	public Boolean getFlag() {
		return flag;
	}

	public String getGender() {
		return gender;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private Integer grade;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Student() {
		super();
	}

	public Student(Integer id, String name, String location, String gender, Boolean flag, Integer grade) {
		Id = id;
		this.name = name;
		this.location = location;
		this.gender = gender;
		this.flag = flag;
		this.grade = grade;
	}

	public Student(String name, String location, String gender, Boolean flag, Integer grade) {
		super();
		this.name = name;
		this.location = location;
		this.gender = gender;
		this.flag = flag;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", location=" + location + ", gender=" + gender + ", flag="
				+ flag + ", grade=" + grade + "]";
	}

}
