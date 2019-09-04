package com.zym.mapper;

import java.util.List;

import com.zym.dao.Student;

public interface StudentMapper {
	List<Student> stuFind();

	void stuSave(Student student);
}
