package com.itheima.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
	/**
	 * 
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		//JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

//		jdbcTemplate.execute("create table account2 ("
//				+ "id int primary key auto_increment,"
//				+ "username varchar(50),"
//				+ "balance double)");
//		
		AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
//		Account account = new Account();
//		account.setUsername("tom");
//		account.setBalance(1000.00);
//		int num = accountDao.addAcount(account);
		//Account account2 = accountDao.findAccountById(1);
		//System.out.println(account2);
		List<Account> accounts = accountDao.findAllAccountById();
		for (Account account : accounts) {
			System.out.println(account);
		}
//		//int num = accountDao.deleteAccount(1);
//		if(num>0) {
//			System.out.println("成功插入了"+num+"条数据");
//		} else {
//			System.out.println("插入操作失败");
			
//			
//		}
		
		
	}

}
