package com.itheima.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class TransactionTest {

	@Test
	void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
		accountDao.transfer("Jack", "Rose", 100.0);
		System.out.println("转账成功");
	}

}
