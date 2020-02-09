package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 需求：使用Cookie记录用户上次的访问时间
 *
 * @author ade
 * @version 1.0，2017-10-13 18:14:49
 */
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 接收客户端携带的Cookies
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            response.getWriter().println("欢迎登录");
        } else {
            for (Cookie cookie : cookies) {
                // 获取Cookie的值
                if (cookie.getName().equals("lastVisitTime")) {
                    response.getWriter().println("欢迎登录。你上次的访问时间是：" + cookie.getValue());
                }
            }
        }
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");

        // 添加Cookie
        response.addCookie(new Cookie("lastVisitTime", fm.format(date)));
    }

}
