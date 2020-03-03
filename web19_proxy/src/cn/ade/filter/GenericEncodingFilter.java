package cn.ade.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 需求：使用动态代理实现通用字符集编码过滤器
 * 
 * @author ade
 * @version 1.0，2017-10-21 14:12:19
 */
@WebFilter("/*")
public class GenericEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest req = (HttpServletRequest) request;
		
		// 增强req
		HttpServletRequest myReq = (HttpServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// 判断是否是在执行getParameter()方法
				if ("getParameter".equals(method.getName())) {
					// 判断是get还是post请求
					String _method = req.getMethod();
					if ("get".equalsIgnoreCase(_method)) {
						String value = (String) method.invoke(req, args);
						return new String(value.getBytes("iso-8859-1"),"utf-8");
					} else if ("post".equalsIgnoreCase(_method)) {
						req.setCharacterEncoding("utf-8");
					}
					
				} 
				return method.invoke(req, args);
			}
		});
		
		// 设置响应头
		response.setContentType("text/html;charset=utf-8");
		
		// 放行
		chain.doFilter(myReq, response);
	}

	@Override
	public void destroy() {}

}
