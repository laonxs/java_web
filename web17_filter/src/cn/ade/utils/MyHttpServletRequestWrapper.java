package cn.ade.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;


/**
 * 需求：装饰者模式
 *
 * @author ade
 * @version 1.0，2017-10-20 14:39:44
 */
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {
	
	private HttpServletRequest request;

	public MyHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		String method = request.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			try {
				return new String(request.getParameter(name).getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else if ("post".equalsIgnoreCase(method)) {
			try {
				request.setCharacterEncoding("utf-8");
				return request.getParameter(name);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return request.getParameter(name);
	}
	
}
