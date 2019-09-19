package com.zym.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zym.spring.aop.pojo.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringPOJO-configuration.xml")
public class PojoTest {

	@Autowired
	Person person;

	@Test
	public void test() throws Exception {
		person.eat();
		person.toilet();
	}

}
