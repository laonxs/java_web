package cn.ade.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 需求：监听域对象ServletContext的创建和销毁
 *
 * @author ade
 * @version 1.0，2017-10-20 00:02:02
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("域对象ServletContext创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("域对象ServletContext销毁了");
    }
}
