package com.zym.spring.aop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value={"com.zym.serviceImpl"})
public class SpringConfiguration {
	
//	@Bean
//	@Scope(scopeName="PROTOTYPE")
//	public Person person() {
//		return new Person();
//	}

}
