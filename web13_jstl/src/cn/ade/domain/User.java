package cn.ade.domain;

/**
 * 需求：用户实体类
 * 
 * @author ade
 * @version 1.0，2017-10-14 14:24:14 
 */
public class User {

	/** 用户名 */
	private String username;
	
	/** 用户年龄 */
	private int age;
	
	/** 用户别名 */
	private String nickname;

	public User(String username, int age, String nickname) {
		super();
		this.username = username;
		this.age = age;
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
