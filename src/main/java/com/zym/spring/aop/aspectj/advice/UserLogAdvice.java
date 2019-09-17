package com.zym.spring.aop.aspectj.advice;

import org.springframework.stereotype.Component;

@Component
public class UserLogAdvice {
	public void startLog() {
		System.out.println("method开始，开始日志记录");
	}

	public void endLog() {

		System.out.println("method结束，开始日志记录");
	}
}
