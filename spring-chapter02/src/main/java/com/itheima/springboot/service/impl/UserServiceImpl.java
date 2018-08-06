package com.itheima.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.springboot.mapper.UserMapper;
import com.itheima.springboot.po.User;
import com.itheima.springboot.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	//注入用户Mapper
	@Autowired
	private UserMapper userMapper;
	
	//查询所有用户
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return this.userMapper.getAllUsers();
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("删除了id为"+id+"的用户");
		this.userMapper.delete(id);
	}

}
