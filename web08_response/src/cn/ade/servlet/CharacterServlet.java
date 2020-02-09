package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 需求：Response的响应中文问题解析
 * 
 * @author ade
 * @version 1.0，2017-10-13 08:51:25 
 */
public class CharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1 响应普通的英文字符aa，响应结果是：aa
		/*String str1 = "aa";
		response.getWriter().println(str1);*/		
		
		// 2 响应中文字符‘张三’，响应结果是：??
		/* 这是因为response响应的字符集是iso-8859-1，它对不认识的字符统一使用数字63来表示
		 * 浏览器对接收的参数‘6363’使用字符集GB2312来进行解析，它会将63解析成：？
		 * */
		/*String str2 = "张三";
		response.getWriter().println(str2);	*/
		
		// 3 将response响应的字符集设置成能识别中文字符的utf-8字符集，响应中文字符‘张三’，响应结果：浣犲ソ（出现了乱码）
		// 浏览器对接收的参数使用GB2312来进行解析，它无法正确解析utf-8表示的中文字符
		/*response.setCharacterEncoding("utf-8");
		response.getWriter().println("你好");*/
		
		// 4 于是，我进一步通知浏览器使用utf-8字符集来解析响应信息，得到的结果：你好
		/*response.setCharacterEncoding("utf-8");
		response.addHeader("Content-Type", "text/html;charset=utf-8");
		response.getWriter().println("你好");*/
		
		// 5 进一步简写，得到响应结果：你好
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("你好");
	}

}
