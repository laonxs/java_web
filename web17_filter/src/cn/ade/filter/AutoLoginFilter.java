package cn.ade.filter;

import cn.ade.domain.User;
import cn.ade.service.AutoLoginService;
import cn.ade.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 需求：用户自动登录
 * 
 * @author ade
 * @version 1.0，2017-10-20 14:32:33
 */
public class AutoLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		HttpServletRequest req = (HttpServletRequest) request;
		
		// 先从Session中获取
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("existUser");
		if (user != null) {
			try {
				chain.doFilter(req, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// 再从Cookie中获取
			Cookie[] cookies = req.getCookies();
			String cookie = CookieUtils.getCookie(cookies, "existUser");
			
			if (cookie == null) {
				try {
					chain.doFilter(req, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				String[] strs = cookie.split("#");
				String name = strs[0];
				AutoLoginService loginService = new AutoLoginService();
				User _user = loginService.autoLogin(name);
				if (_user == null) {
					try {
						chain.doFilter(req, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					session.setAttribute("existUser", _user);
					try {
						chain.doFilter(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void destroy() {}

}
