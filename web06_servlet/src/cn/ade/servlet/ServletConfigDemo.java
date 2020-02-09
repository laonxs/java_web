package cn.ade.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 需求：练习ServletConfig
 * 
 * @author ade
 * @version 1.0，2017-10-11 22:50:07 
 */
public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameterMap();
		ServletConfig config = this.getServletConfig();
		String servletName = config.getServletName();
		System.out.println(servletName);		// ServletConfigDemo
		
		String initParameter = config.getInitParameter("name");
		System.out.println(initParameter);		// wangzp,tanhq
		
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			String string = (String) names.nextElement();
			System.out.println(string);			// name name1
		}
	}
       
}
