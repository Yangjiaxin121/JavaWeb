package cn.itcast.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserException;
import cn.itcast.user.service.UserService;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");  //请求编码(POST)
		response.setContentType("text/html;charset=utf-8");//响应编码
		
		//依赖UserService
		UserService userService = new UserService();
		
		/*
		 * 1.封装表单数据（封装到User对象中）
		 */
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		/*
		 * 添加新任务(表单校验)
		 * 1.创建一个Map。用来装载所有的表单错误信息
		 * 	在校验过程之中，如果失败，向map添加错误信息，其中key为表单子弹名称
		 * 2.校验之后，产看map长度时候大于0。如果大于0，说明有错误信息，就是有错误！
		 * 	保存map到request中，保存form到request中，转发regist.jsp
		 * 
		 * 3.如果map为空，说明没有错误信息，向下执行！
		 */
		
		//用来装载所有错误
		Map<String ,String> errors = new HashMap<String,String>();
		//对用户名进行校验
		String username = form.getUsername();//获取表单的username
		if(username == null || username.trim().isEmpty()) {
			errors.put("username", "用户名不能为空！");
		}else if(username.length() < 3 || username.length() > 15) {
			errors.put("username", "用户名长度必须在3～15之间！");
		}
		//对验证码进行校验
		String password = form.getPassword();//获取表单的username
		if(password == null || password.trim().isEmpty()) {
			errors.put("password", "密码不能为空！");
		}else if(password.length() < 3 || password.length() > 15) {
			errors.put("password", "密码长度必须在3～15之间！");
		}
		//对验证码进行校验
		String verifyCode = form.getVerifyCode();
		String sessionVerifyCode = (String) request.getSession().getAttribute("session_vcode");
		if(verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空！");
		}else if(verifyCode.length() !=4) {
			errors.put("verifyCode", "验证码长度必须为4");
		}else if(!sessionVerifyCode.equalsIgnoreCase(form.getVerifyCode())) {
			errors.put("verifyCode", "验证码错误");
		}
		
		/*
		 * 判断验map是否为空，不为空，说明存在错误
		 */
		if(errors != null && errors.size() > 0) {
			/*
			 * 1.保存erroes到request域
			 * 2.保存form到request域，为了回显
			 * 3.转发request.jsp
			 */
			request.setAttribute("errors", errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
			return;
		}
		/*
		 * 新添加验证码：
		 * 	校验验证码
		 * 	1.用户填写的验证码已经封装到user中
		 * 	2.从session获取真正的验证码
		 * 	3.比较二者。如果不同，保存错误信息、保存表单数据，准发到regist.jsp
		 * 	4.如果相同，什么都不做，向下执行
		 */
//		String sessionVerifyCode = (String) request.getSession().getAttribute("session_vcode");
//		if(!sessionVerifyCode.equalsIgnoreCase(form.getVerifyCode())) {
//			request.setAttribute("msg", "验证码错误！");
//			request.setAttribute("user", form);
//			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
//			return;
//		}
		
		/*
		 * 2.调用userService的regist()方法，传递form过去
		 * 3.得到异常信息：保存到request域，转发到request.jsp中显示
		 * 4.没有异常:输出注册成功
		 */
		try {
			userService.regist(form);
			response.getWriter().print("<h1>注册成功！</h1><a href='"+ 
			request.getContextPath() + 
			"/user/login.jsp" + 
			"'>点击这里去登陆</a>");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			//获取异常信息，保存到request域
			request.setAttribute("msg", e.getMessage());
			//还要保存表单数据到request域
			request.setAttribute("user", form);//用来在表单中回显
			//转发到regist.jsp
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
			
			
		}
	}

}
