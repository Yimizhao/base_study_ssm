package com.zym.mapperTest;

import java.util.List;
import java.util.Objects;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zym.dao.Student;
import com.zym.mapper.StudentMapper;

public class MapperTest {
	private SqlSession session;

	@Before
	public void init() throws Exception {
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsStream("mybatis-config.xml"));
		session = sessionFactory.openSession();

	}

	@Test
	public void testStuFine() {
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.stuFind();
		System.out.println(students);
	}

	@Test
	public void testStuSave() {
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setName("Jony");
		student.setLocation("nanjing");
		student.setGender("nan");
		student.setGrade(90);
		studentMapper.stuSave(student);
		session.commit();
	}

	@After
	public void end() {
		if (Objects.nonNull(session)) {
			session.close();
		}
	}

}
