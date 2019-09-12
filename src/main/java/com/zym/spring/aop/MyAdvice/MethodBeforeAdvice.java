package com.zym.spring.aop.MyAdvice;

import java.lang.reflect.Method;

public interface MethodBeforeAdvice extends Advice {
   void before(Method method, Object[] args, Object target) throws Throwable;
}
