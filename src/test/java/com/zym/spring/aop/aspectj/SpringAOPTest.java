package com.zym.spring.aop.aspectj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zym.spring.aop.aspectj.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springaopConfiguration.xml")
public class SpringAOPTest {

	@Autowired
	UserService userService;

	@Test
	public void test() {
		userService.saveUser();
	}

}
