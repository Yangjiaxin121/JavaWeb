package com.itheima.ioc;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void say() {
		// TODO Auto-generated method stub
		this.userDao.say();
		System.out.println("userService say hello World!");
	}

}
