package com.zym.spring.aop.aspectj.service.impl;

import org.springframework.stereotype.Service;

import com.zym.spring.aop.aspectj.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Override
	public void saveUser() {
		System.out.println("保存user对象");

	}

}
