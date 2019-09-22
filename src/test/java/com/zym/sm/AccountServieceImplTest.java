package com.zym.sm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zym.sm.service.AccountServiece;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/sm/app.xml")
public class AccountServieceImplTest {
	
	@Autowired
	private AccountServiece accountService;

	@Test
	public void testTransfer() {
		accountService.transfer("老公", "老婆", 100);
	}

}
