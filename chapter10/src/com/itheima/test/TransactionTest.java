package com.itheima.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.po.Customer;
import com.itheima.service.CustomerService;

public class TransactionTest {
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = act.getBean(CustomerService.class);
		Customer customer = new Customer();
		customer.setUsername("zhangsan12");
		customer.setJobs("manager21");
		customer.setPhone("123446621");
		customerService.addCustomer(customer);
	}

}
