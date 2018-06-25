package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserService {
	//service层以来dao层
	private UserDao userdao = new UserDao();
	/**
	 * service的查询，需要使用到来完成！
	 * @return
	 */
	public User find() {
		return userdao.find();
	}

}
