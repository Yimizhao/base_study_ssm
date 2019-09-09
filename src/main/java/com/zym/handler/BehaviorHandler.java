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
		String methodNm = method.getName();
		if ("eat".equals(methodNm)) {
			wash();
			value = method.invoke(obj, args);
		} else if ("toilet".equals(methodNm)) {
			value = method.invoke(obj, args);
			wash();
		}

		return value;
	}

	public void wash() {

		System.out.println("请洗手！");
	}

}
