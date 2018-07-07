package com.itheima.jdbc;

import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AccountDaoImpl implements AccountDao {

	private JdbcTemplate JdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addAcount(Account account) {
		// TODO Auto-generated method stub
		String sql = "insert into account(username,balance) values(?,?)";
		Object[] obj = new Object[] {
				account.getUsername(),
				account.getBalance()
		};
		int num = this.JdbcTemplate.update(sql,obj);
		return num;
	}

	@Override
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		String sql = "update account set usename=?,balance=?,where id=?";
		Object[] obj = new Object[] {
				account.getUsername(),
				account.getBalance(),
				account.getId()
		};
		int num = this.JdbcTemplate.update(sql,obj);
		return num;
	}

	@Override
	public int deleteAccount(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from account where id=?";
		int num = this.JdbcTemplate.update(sql,id);
		return num;
	}

	@Override
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from account where id=?";
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		return this.JdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public List<Account> findAllAccountById() {
		// TODO Auto-generated method stub
		String sql = "select * from account";
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		return this.JdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void transfer(String outUser, String inUser, Double money) {
		// TODO Auto-generated method stub
		this.JdbcTemplate.update("update account set balance = balance+? where username=?",money,inUser);
		int i = 1/0;
		this.JdbcTemplate.update("update account set balance = balance-? where username=?",money,outUser);
	}
}

