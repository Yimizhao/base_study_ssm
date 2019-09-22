package com.zym.sm.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

	public Integer findMoney(String name);

	public void updateAccount(@Param("name") String username, @Param("balance") Integer balance);

}
