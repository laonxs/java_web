package cn.ade.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 需求：监听域对象ServletContext中属性的添加、移除、修改
 *
 * @author ade
 * @version 1.0，2017-10-20 08:04:25
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("域对象ServletContext添加属性了");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("域对象ServletContext移除属性了");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("域对象ServletContext修改属性了");
    }

}
