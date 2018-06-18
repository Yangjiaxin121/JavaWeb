package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DServlet
 * 演示定时刷新
 * 设置一个Refresh，他表示定时刷新！
 */
@WebServlet("/DServlet")
public class DServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 下面用来发送响应体
		 */
		PrintWriter writer = response.getWriter();
		writer.print("欢迎xxx登录，待会儿你看到的一定是乱码");
		/**
		 * 设置名为Refresh的响应头
		 */
		response.setHeader("Refresh", "5;URL=/day10_1/EServlet");
	}

}
