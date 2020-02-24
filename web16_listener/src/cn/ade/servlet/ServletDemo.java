package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 需求：Servlet
 * 
 * @author ade
 * @version 1.0，2017-10-20 00:04:16
 */
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 测试域对象ServletContext中属性的创建和销毁
//		ServletContext context = this.getServletContext();
//		context.setAttribute("list", "list1");
//		context.setAttribute("list", "list2");
//		context.removeAttribute("list");
		
		// 测试Session域对象及其属性的创建和销毁
//		HttpSession session = request.getSession();
//		session.setAttribute("list", "list1");
//		session.setAttribute("list", "list2");
//		session.removeAttribute("list");
//		session.invalidate();		// 手动销毁Session
//
		// 测试域对象Request中属性的创建和销毁
//		request.setAttribute("list", "list1");
//		request.setAttribute("list", "list2");
//		request.removeAttribute("list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
