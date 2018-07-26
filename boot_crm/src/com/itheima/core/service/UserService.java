package com.itheima.core.service;

import com.itheima.core.po.User;

/**
 * 用户service接口
 * @author yangjiaxin
 *
 */
public interface UserService {
	//通过账号和密码查询用户
	public User findUser(String usercode, String password);

}
