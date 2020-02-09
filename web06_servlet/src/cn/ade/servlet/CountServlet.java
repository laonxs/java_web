package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 需求：记录网站登录人数
 * 
 * @author ade
 * @version 1.0， 2017-10-09 21:42:17
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		int count = (int) this.getServletContext().getAttribute("count");
		resp.getWriter().println("您是第"+count+"位登陆者");
	}
       
}
