package com.zym.factory;

import java.lang.reflect.Proxy;

import com.zym.handler.BehaviorHandler;

public class ProxyFactory {

	public static Object builder(Class<?> proxyClass)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException {

		return Proxy.newProxyInstance(proxyClass.getClassLoader(), proxyClass.getInterfaces(),
				new BehaviorHandler(proxyClass.newInstance()));
	}

}
