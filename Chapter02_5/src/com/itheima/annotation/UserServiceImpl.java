package com.itheima.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		this.userDao.save();
		System.out.println("userService...save..");
	}

	
	

}
