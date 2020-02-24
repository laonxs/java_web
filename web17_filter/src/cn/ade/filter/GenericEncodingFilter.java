package cn.ade.filter;

import cn.ade.utils.MyHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 需求：设置通用字符集的过滤器
 * 
 * @author ade
 * @version 1.0，2017-10-20 11:19:58
 */
public class GenericEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		MyHttpServletRequestWrapper myReq = new MyHttpServletRequestWrapper(req);
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(myReq, response);
	}

	@Override
	public void destroy() {} 		

}
