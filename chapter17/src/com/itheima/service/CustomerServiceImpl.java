package com.itheima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.CustomerDao;
import com.itheima.po.Customer;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	//注解注入Customer
	@Autowired
	private CustomerDao customerDap;
	//查询客户
	@Override
	public Customer findCustomerById(Integer id) {
		// TODO Auto-generated method stub
		
		return this.customerDap.findCustomerById(id);
	}

}
