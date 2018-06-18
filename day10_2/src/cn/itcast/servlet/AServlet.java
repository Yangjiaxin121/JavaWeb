package cn.itcast.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AServlet
 * 获取客户端的ip地址，请求方式，User-Agent
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String addr = request.getRemoteAddr();
		String method = request.getMethod();
		String userAgent = request.getHeader("User-Agent");
		System.out.println("您的IP地址是："+addr);
		System.out.println("您的请求方式是："+method);
		System.out.println("UserAgent:"+userAgent);
		
		if(userAgent.toLowerCase().contains("chrome")) {
			System.out.println("您好"+addr+"您用的是谷歌浏览器");
		}else if(userAgent.toLowerCase().contains("msie")) {
			System.out.println("您好"+addr+"您用的是IE浏览器");
		}else if(userAgent.toLowerCase().contains("safari")){
			System.out.println("您好"+addr+"您用的是safari浏览器");
		}else {
			System.out.println("您好"+addr+"您用的是其他浏览器");

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
