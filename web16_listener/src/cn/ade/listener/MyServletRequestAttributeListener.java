package cn.ade.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * 需求：监听域对象Request中属性的创建、移除、销毁
 * 
 * @author ade
 * @version 1.0，2017-10-20 08:16:37
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("域对象Request中添加属性了");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("域对象Request中移除属性了");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("域对象Request中修改属性了");
	}

}
