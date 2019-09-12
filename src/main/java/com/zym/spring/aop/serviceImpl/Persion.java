package com.zym.spring.aop.serviceImpl;

import com.zym.spring.aop.service.BaseService;

public class Persion implements BaseService {

	// pointCut 切入点
	@Override
	public void eat() {
		System.out.println("吃黄焖鸡----------");
	}

	
	// pointcut 切入点
	@Override
	public void toilet() {
		System.out.println("排泄----------");
	}

}
