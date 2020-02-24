package cn.ade.servlet;

import cn.ade.domain.User;
import cn.ade.service.AutoLoginService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 需求：用户登录的Servlet
 * 
 * @author ade
 * @version 1.0，2017-10-20 14:30:41
 */
public class AutoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		AutoLoginService loginService = new AutoLoginService();
		User user = loginService.autoLogin(username);
		if (user == null) {
			response.getWriter().println("用户不存在");
		} else {
			if ("true".equals(request.getParameter("autologin"))) {
				
				Cookie cookie = new Cookie("existUser", username);
				cookie.setPath("/web_listener_filter");
				cookie.setMaxAge(60*60);
				response.addCookie(cookie);
				System.out.println(cookie);
			}
			request.getSession().setAttribute("existUser", user);
			response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
		}
	}

}
