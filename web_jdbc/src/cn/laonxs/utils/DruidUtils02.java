package cn.laonxs.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 需求：Druid工具类
 * 		通过配置文件配置参数
 * 
 * @author laonxs
 * @version 1.0， 2017-10-08 13:45:53
 */
public class DruidUtils02 {

	/** Druid数据库连接池 */
	private static DataSource dataSource;	// 静态的加载优先于对象，随着类的加载而加载
	
	/**
	 * 初始化
	 */
	static {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/druid.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
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
			return dataSource.getConnection();	// DruidPooledConnection extends java.sql.Connection
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
