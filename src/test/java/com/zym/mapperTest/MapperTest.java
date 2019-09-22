package com.zym.mapperTest;

import java.util.ArrayList;
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
import com.zym.sm.mapper.AccountMapper;

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
	public void testStuFindById() {
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Integer> ids = new ArrayList<>();
		ids.add(201107);
		// ids.add(201809);
		// ids.add(201819);
		List<Student> students = studentMapper.stuFindById(ids);
		System.out.println("-----------------------------");
		System.out.println(students);
		System.out.println("-----------------------------");
	}

	@Test
	public void testStuSave() {
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = new Student();
		student.setName("Lay");
		student.setLocation("长沙");
		student.setGender("男");
		student.setGrade(90);
		student.setFlag(true);
		studentMapper.stuSave(student);
		session.commit();
	}

	@Test
	public void testStuListSave() {
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Student> students = new ArrayList<Student>();
		Student student1 = new Student("李楠", "上海", "男", true, 60);
		Student student2 = new Student("李楠", "上海", "男", true, 60);
		Student student3 = new Student("李楠", "上海", "男", true, 60);
		students.add(student1);
		students.add(student2);
		students.add(student3);
		studentMapper.stuListSave(students);
		session.commit();
	}

	@After
	public void end() {
		if (Objects.nonNull(session)) {
			session.close();
		}
	}

	@Test
	public void testAccount() {
		AccountMapper accountMapper = (AccountMapper) session.getMapper(AccountMapper.class);
		Integer money = accountMapper.findMoney("老公");
		System.out.println(money);

	}

}
