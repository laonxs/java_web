package cn.ade.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器Filter创建了");
		String filterName = filterConfig.getFilterName();
		System.out.println("filterName="+filterName);
		String initParameter = filterConfig.getInitParameter("username");
		System.out.println(initParameter);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器Filter执行了");
		// 放行
		String username = request.getParameter("username");
		if ("username".equals(username)) {
			chain.doFilter(request, response);
		} else {
			System.out.println("用户名不正确");
		}
	}

	@Override
	public void destroy() {
		System.out.println("过滤器Filter销毁了");
	}


}
