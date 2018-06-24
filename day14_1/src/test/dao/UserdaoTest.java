package test.dao;

import org.junit.Test;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

public class UserdaoTest {
	@Test
	public void testFindByUsername() {
		UserDao userDao = new UserDao();
		User user = userDao.findByUsername("李四");
		System.out.println(user.getPassword());

		
	}
	
	
	
	@Test
	public void testAdd() {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername("李四");
		user.setPassword("1234");
		userDao.add(user);
	}

}
