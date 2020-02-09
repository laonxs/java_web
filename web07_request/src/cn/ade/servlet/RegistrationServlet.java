package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 需求：用户登录的Servlet
 * 
 * @author ade
 * @version 1.0， 2017-10-09 20:13:53
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取用户名
		String username = req.getParameter("username");
		System.out.println(username);
		
		// 获取密码
		String password = req.getParameter("password");
		System.out.println(password);
		
		// 获取爱好
		String[] hobbies = req.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobbies));
		
		// 获取全部参数
		Map<String, String[]> map = req.getParameterMap();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key+"\t"+Arrays.toString(map.get(key)));
		}
	}
    
}
