package com.zym.mapper;

import java.util.List;

import com.zym.dao.Student;

public interface StudentMapper {
	List<Student> stuFind();

	List<Student> stuFindById(List<Integer> ids);

	void stuSave(Student student);

	void stuListSave(List<Student> students);
}
