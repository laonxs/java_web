package cn.ade.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 需求：练习ServletContext
 * 
 * @author ade
 * @version 1.0，2017-10-11 23:26:56 
 */
public class ServletContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext context = this.getServletContext();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 作为域对象存储数据，参考LoginServlet代码
		System.out.println(this.getServletContext());
		
		// 获取web项目中的指定资源文件
		getFile();
		// getFile2();
		
		// 获取全局初始化参数
		// getInitParameters();
		
		// 获取指定资源文件的MIME类型
		// getMimeType();
	}

	/**
	 * 获取指定资源文件的MIME类型
	 */
	private void getMimeType() {
		String type = context.getMimeType("db.txt");
		System.out.println(type);		// text/plain
	}

	/**
	 * 获取全局初始化参数
	 * <context-param>
  	 * <param-name>name</param-name>
  	 * <param-value>name</param-value>
  	 * </context-param>
	 */
	private void getInitParameters() {
		ServletContext context = this.getServletContext();		// this关键字来代表本类对象的引用
		String name = context.getInitParameter("name");
		System.out.println(name);
		Enumeration<String> names = context.getInitParameterNames();
		while (names.hasMoreElements()) {
			String string = (String) names.nextElement();
			System.out.println(string);
		}
	}

	/**
	 * 获取web项目中指定资源二
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void getFile2() throws FileNotFoundException, IOException {
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath("/WEB-INF/classes/db.properties");
		FileInputStream fis = new FileInputStream(new File(realPath));
		Properties properties = new Properties();
		properties.load(fis);
		System.out.println(properties.getProperty("driverClassName"));
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("username"));
		System.out.println(properties.getProperty("password"));
	}

	/**
	 * 获取web项目中指定资源
	 * 
	 * @throws IOException
	 */
	private void getFile() throws IOException {
		// ServletContext context = this.getServletContext();
		System.out.println(context);
		InputStream stream = context.getResourceAsStream("WEB-INF/classes/db.properties");
		Properties properties = new Properties();
		properties.load(stream);
		System.out.println(properties.getProperty("driverClassName"));
		System.out.println(properties.getProperty("url"));
		System.out.println(properties.getProperty("username"));
		System.out.println(properties.getProperty("password"));
	}
	
}
