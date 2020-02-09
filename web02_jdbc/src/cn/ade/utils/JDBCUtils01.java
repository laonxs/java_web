package cn.ade.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 需求：JDBC工具类一
 * 		手动配置参数
 * 
 * @author ade
 * @version 1.0， 2017-10-08 10:03:25
 */
public class JDBCUtils01 {

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
		driverClassName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/db1";
		username = "root";
		password = "1234";
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
			JDBCUtils01.loadDriver();
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
	 * @throws SQLException 
	 */
	public static void release(ResultSet rs, Statement stat, Connection conn) throws SQLException {
		try {
			if (rs != null) {
				rs.close();
			}
			rs = null;
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				stat = null;
			} finally {
				if (conn != null) {
					conn.close(); 
				}
				conn = null;
			}
		}
	}
	
}
