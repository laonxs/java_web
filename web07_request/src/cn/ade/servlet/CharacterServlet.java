package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 需求：请求中文的问题解析
 *
 * @author ade
 * @version 1.0，2017-10-12 20:53:50
 */
public class CharacterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get方式提交参数
        // http协议不支持中文，因此会使用iso-8859-1进行编码，所以在服务器需要使用iso-885-1解码，然后在使用可以识别中文的字符集utf-8/gbk进行编码
        String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
        System.out.println(username);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 表单方式提交参数
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
    }

}
