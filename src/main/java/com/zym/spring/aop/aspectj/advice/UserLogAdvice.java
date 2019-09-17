package com.zym.spring.aop.aspectj.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("myAdvice")
@Aspect
public class UserLogAdvice {

	@Before(value = "execution(* com.zym.spring.aop.aspectj.service.*.*(..))")
	public void startLog() {
		System.out.println("前置通知");
	}

	@AfterReturning(pointcut = "execution(* com.zym.spring.aop.aspectj.service.*.*(..))")
	public void endLog() {

		System.out.println("后置通知");
	}

	// @Around(value = "execution(*
	// com.zym.spring.aop.aspectj.service.*.*(..))")
	// public Object aroundLog(ProceedingJoinPoint pjp) {
	// String methodName = pjp.getSignature().getName();
	// Object[] args = pjp.getArgs();
	// Object proceed = null;
	// try {
	// // 前置通知 Befor
	// System.out.println("Before methodName : " + methodName + ";args : " +
	// Arrays.asList(args));
	// proceed = pjp.proceed(args);
	//
	// // 测试异常通知
	// // int i = 0;
	// // int j = 1;
	// // int h = j / i;
	//
	// // 后置通知 AfterReturn
	// System.out.println("AfterReturning methodName : " + methodName + ";args :
	// " + Arrays.asList(args));
	// } catch (Throwable e) {
	// // 异常通知
	// System.out.println("AfterThrowing methodName : " + methodName + ";args :
	// " + Arrays.asList(args));
	// } finally {
	// // After 后置通知
	// System.out.println("After methodName : " + methodName + ";args : " +
	// Arrays.asList(args));
	// }
	// return proceed;
	//
	// }

	@After(value = "execution(* com.zym.spring.aop.aspectj.service.*.*(..))")
	public void afterAdvice() {
		System.out.println("最终通知");
	}

	@AfterThrowing(pointcut = "execution(* com.zym.spring.aop.aspectj.service.*.*(..))")
	public void afterThrowing() {
		System.out.println("异常通知");
	}
}
