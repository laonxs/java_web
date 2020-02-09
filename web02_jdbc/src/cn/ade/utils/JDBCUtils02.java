package cn.ade.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 需求：JDBC工具类二
 * 		使用配置文件配置参数
 * 
 * @author ade
 * @version 1.0， 2017-10-08 10:56:40
 */
public class JDBCUtils02 {

	/** 驱动路径 */
	private static String driverClassName;
	
	/** 数据库路径 */
	private static String url;
	
	/** 数据库用户名 */
	private static String username;
	
	/** 数据库密码 */
	private static String password;
	 
	/**
	 * 初始化成员变量
	 * */
	static {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/db.properties"));
			driverClassName = properties.getProperty("driverClassName");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 加载驱动
	 */
	public static void loadDriver() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * 
	 * @return Connection 数据库连接对象
	 */
	public static Connection getConnection() {
		try {
			JDBCUtils02.loadDriver();
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * 释放资源
	 * 
	 * @param stat SQL语句执行对象
	 * @param conn 数据库连接对象
	 */
	public static void release(Statement stat, Connection conn) {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stat = null;
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	/**
	 * 释放资源
	 * 
	 * @param rs 结果集对象
	 * @param stat SQL语句执行对象
	 * @param conn 数据库连接对象
	 */
	public static void release(ResultSet rs, Statement stat, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stat = null;
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}
