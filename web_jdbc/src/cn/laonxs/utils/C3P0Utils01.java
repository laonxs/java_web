package cn.laonxs.utils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 需求：Druid工具类
 * 		通过配置文件配置参数
 * 
 * @author laonxs
 * @version 1.0， 2017-10-08 14:04:40
 */
public class C3P0Utils01 {

	/** Druid数据库连接池 */
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/**
	 * 初始化
	 */
	static {
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db1");
			dataSource.setUser("root");
			dataSource.setPassword("1234");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接池对象
	 * 
	 * @return DataSource 数据库连接池对象
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 获取数据库连接对象
	 * 
	 * @return Connection 数据库连接对象
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
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
