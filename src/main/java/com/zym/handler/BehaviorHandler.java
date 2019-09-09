package com.zym.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BehaviorHandler implements InvocationHandler {

	Object obj;

	public BehaviorHandler(Object behavior) {
		this.obj = behavior;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object value = null;
		if ("eat".equals(method.getName())) {
			System.out.println("饭前请洗手！");
			value = method.invoke(obj, args);
		} else if ("toilet".equals(method.getName())) {
			value = method.invoke(obj, args);
			System.out.println("便后请洗手！");
		}

		return value;
	}

}
