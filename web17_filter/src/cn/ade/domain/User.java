package cn.ade.domain;

/**
 * 需求：用户实体类
 * 
 * @author ade
 * @version 1.0，2017-10-20 14:35:31
 */
public class User {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	
	
}
