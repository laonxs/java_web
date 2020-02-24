package cn.ade.servlet;

import cn.ade.service.TransferAccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 需求：转账的Servlet
 * 
 * @author ade
 * @version 1.0，2017-10-14 18:44:47 
 */
public class TransferAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 处理响应中文乱码问题
			response.setContentType("text/html;charset=utf-8");
			
			// 接收数据
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String money = request.getParameter("money");
			
			// 调用业务层执行操作
			TransferAccountService service = new TransferAccountService();
			service.transfer(from, to, money);
			
			// 响应页面
			response.getWriter().println("付款成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
