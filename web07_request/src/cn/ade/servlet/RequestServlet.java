package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 需求：获取请求参数
 * 
 * @author ade
 * @version 1.0，2017-10-13 10:57:09
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get01(request);
		
		// get02(request);
		
		// get03(request);
	}

	/**
	 * 获取请求体参数
	 * 
	 * @param request
	 */
	private void get03(HttpServletRequest request) {
		String username = request.getParameter("username");
		System.out.println(username);
	}

	/**
	 * 获取请求头参数
	 * 
	 * @param request
	 */
	private void get02(HttpServletRequest request) {
		String type = request.getContentType();
		System.out.println(type);
		
		String encoding = request.getCharacterEncoding();
		System.out.println(encoding);
		
		String header = request.getHeader("Content-Type");
		System.out.println(header);
	}

	/**
	 * 获取请求行的参数
	 * 
	 * @param request
	 */
	private void get01(HttpServletRequest request) {
		// 获取请求参数
		String method = request.getMethod();
		System.out.println(method);			// GET
		 
		String remoteAddr = request.getLocalAddr();
		System.out.println(remoteAddr);		// 0:0:0:0:0:0:0:1
		
		String contextPath = request.getContextPath();
		System.out.println(contextPath);	// /web_request
	}

}
