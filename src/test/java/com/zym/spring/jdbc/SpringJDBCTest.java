package com.zym.spring.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:springJDBC-configuration.xml")
public class SpringJDBCTest {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void run1() {
		// 创建连接池，先使用Spring框架内置的连接池
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/atguigu?useUnicode=true&characterEncoding=UTF-8");
//		dataSource.setUsername("root");
//		dataSource.setPassword("123456");
		// 创建模板类
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// 完成数据的添加
		jdbcTemplate.update("insert into dept values (null,?,?)", "开发三部", "沈阳");
	}
}
