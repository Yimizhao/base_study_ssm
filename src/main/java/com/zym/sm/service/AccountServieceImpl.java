package com.zym.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zym.sm.mapper.AccountMapper;

@Service
public class AccountServieceImpl implements AccountServiece {

	@Autowired
	AccountMapper accountMapper;

	@Override
	public void transfer(String from, String to, Integer balance) {
		Integer fromMoney = accountMapper.findMoney(from);
		accountMapper.updateAccount(from, fromMoney - balance);
//		System.out.println(1/0);
		Integer toMoney = accountMapper.findMoney(to);
		accountMapper.updateAccount(to, toMoney + balance);

	}

}
