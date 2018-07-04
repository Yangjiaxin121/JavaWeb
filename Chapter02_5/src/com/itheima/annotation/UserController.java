package com.itheima.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller("userControlelr")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	public void save() {
		this.userService.save();
		System.out.println("usercontroller...save...");
	}

}
