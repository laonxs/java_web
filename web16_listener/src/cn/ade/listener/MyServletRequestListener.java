package cn.ade.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 需求：监听域对象Request的创建和销毁
 * 
 * @author ade
 * @version 1.0，2017-10-20 00:10:11
 */
public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("域对象Request销毁了");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("域对象Request创建了");
	}

	
}
