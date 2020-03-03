package cn.ade.loader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 需求：使用类加载器读取文件
 *
 * @author ade
 * @version 1.0，2017-10-12 00:20:47
 */
@WebServlet(urlPatterns="/ClassLoader")
public class ClassLoader extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(is);
        System.out.println(properties.getProperty("driverClassName"));
        System.out.println(properties.getProperty("url"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }

}
