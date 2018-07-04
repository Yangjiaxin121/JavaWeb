package com.itheima.factorbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.jdk.UserDao;

public class ProxyFactoryBeanTest {
	public static void main(String[] args) {
		String xPath = "com/itheima/factorbean/bean.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xPath);
		UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");
		userDao.addUser();
		userDao.deleteUser();
		
	}

}
