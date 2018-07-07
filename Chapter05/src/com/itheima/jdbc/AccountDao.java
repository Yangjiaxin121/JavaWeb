package com.itheima.jdbc;

import java.util.List;

interface AccountDao {
	public int addAcount(Account account);
	public int updateAccount(Account account);
	public int deleteAccount(int id);
	public Account findAccountById(int id);
	public List<Account> findAllAccountById();
	
	public void transfer(String outUser,String inUser,Double money);
}
