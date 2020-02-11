package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 需求：使用Session完成验证码的校验
 * 
 * @author ade
 * @version 1.0，2017-10-13 19:04:17
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		session.removeAttribute("code");
		String username = request.getParameter("username");
		String checkcode = request.getParameter("checkcode");
		if (("lisi".equals(username)) && (checkcode.equalsIgnoreCase(code))) {
			response.getWriter().println("登录成功");
		} else {
			response.getWriter().println("登录失败");
		}
	}

}
