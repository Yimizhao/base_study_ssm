package com.zym.spring.aop.AspectAnnotationDriver;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BehaviorAdvice {

	@Pointcut("execution(* com.zym.spring.aop.AspectAnnotationDriver.*.*toilet(..))")
	public void pintcut() {
		
	}
	
	@Before(value="execution(* com.zym.spring.aop.AspectAnnotationDriver.*.*eat(..))")
	public void before() {
		System.out.println("饭前请洗手");
	}
	
	
	@AfterReturning(pointcut="pintcut()")
	public void after() {
		System.out.println("便后请洗手");
	}
	
	
}
