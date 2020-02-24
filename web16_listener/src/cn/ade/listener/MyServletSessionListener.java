package cn.ade.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 需求：监听域对象Session的创建和销毁
 * 
 * @author ade
 * @version 1.0，2017-10-20 00:13:16
 */
public class MyServletSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("域对象Session创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("域对象Session销毁了");
	}

    
	
}
