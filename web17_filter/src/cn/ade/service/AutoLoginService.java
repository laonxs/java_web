package cn.ade.service;

import cn.ade.domain.User;

/**
 * 需求：业务类
 * 
 * @author ade
 * @version 1.0，2017-10-20 14:45:50
 */
public class AutoLoginService {
	
	/**
	 * 用户自动登录
	 * 
	 * @param name 用户名
	 * @return user 用户实体对象
	 */
	public User autoLogin(String name) {
		if ("zhangsan".equals(name)) {
			User user = new User();
			user.setName("zhangsan");		
			return user;
		}
		return null;
	}

}
