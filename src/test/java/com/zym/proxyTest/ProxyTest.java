package com.zym.proxyTest;

import org.junit.Test;

import com.zym.factory.ProxyFactory;
import com.zym.service.Behavior;
import com.zym.serviceImpl.Person;

public class ProxyTest {

	@Test
	public void behavoirProxyTest() throws IllegalArgumentException, InstantiationException, IllegalAccessException {
		Behavior persion = (Behavior) ProxyFactory.builder(Person.class);
		persion.eat();
		persion.toilet();
	}

}
