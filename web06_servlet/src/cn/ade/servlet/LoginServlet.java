package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 需求：用户登录的Servlet
 * 
 * @author ade
 * @version 1.0， 2017-10-09 20:13:53
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		int count = 0;
		this.getServletContext().setAttribute("count", count);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("success");
		int count = (int) this.getServletContext().getAttribute("count");
		count++;
		this.getServletContext().setAttribute("count", count);
		
		// 定时刷新
		resp.setHeader("Refresh", "3;url=/web_servlet/CountServlet");
	}
    
}
