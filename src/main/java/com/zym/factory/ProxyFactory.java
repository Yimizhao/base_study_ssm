package com.zym.factory;

import java.lang.reflect.Proxy;

import com.zym.handler.BehaviorHandler;

public class ProxyFactory {

	@SuppressWarnings("unchecked")
	public static <T> T builder(Class<T> proxyClass)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException {

		return (T) Proxy.newProxyInstance(proxyClass.getClassLoader(), proxyClass.getInterfaces(),
				new BehaviorHandler((T)proxyClass.newInstance()));
	}

}
