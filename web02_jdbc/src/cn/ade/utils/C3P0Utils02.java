package cn.ade.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 需求：Druid工具类
 * 		使用配置文件获取参数
 * 		c3p0-config.xml
 * 
 * @author ade
 * @version 1.0， 2017-10-08 14:04:40
 */
public class C3P0Utils02 {

	/** Druid数据库连接池 */
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
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
