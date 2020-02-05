package cn.laonxs.domain;

/**
 * 需求：用户实体类
 * 
 * @author laonxs
 * @version 1.0，2017-10-08 15:34:15 
 */
public class User {

	/** 用户id */
	private int id;
	
	/** 用户名 */
	private String username;
	
	/** 用户密码 */
	private String password;
	
	/** 用户别名 */
	private String nickname;
	
	/** 用户年龄 */
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", age=" + age + "]";
	}
	
}
