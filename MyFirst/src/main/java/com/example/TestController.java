package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //标识一个控制器 接收用户请求,RestController=Controller+ResponseBody
public class TestController {
	
	@RequestMapping("/index.do")//HTTP请求
	public String test() {
		System.out.println("TestController>>>test>>>is running....return a string");
		return "index";//返回一个视图（HTML页面）
	}
}