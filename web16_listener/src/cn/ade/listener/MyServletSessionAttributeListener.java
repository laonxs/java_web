package cn.ade.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 需求：监听域对象Session中属性的创建、修改、移除
 * 
 * @author ade
 * @version 1.0，2017-10-20 08:21:04
 */
public class MyServletSessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("域对象Session中添加属性了");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("域对象Session中移除属性了");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("域对象Session中修改属性了");
	}
	
}
