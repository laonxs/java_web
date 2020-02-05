package cn.laonxs.test;

import java.sql.*;

import org.junit.Test;
import cn.laonxs.utils.C3P0Utils02;

/**
 * 需求：jdbc 入门
 * 
 * @author laonxs
 * @version 1.0， 2017-10-08 08:33:02
 */
public class JDBCDemo01 {
	
	/**
	 * 简单的数据库操作
	 */
	@Test
	public void method01() throws Exception {
		// 1 加载驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 2 获取数据库连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_jdbc", "root", "z+111111");

		// 3 执行sql
		// 3.1 获取执行sql的对象
		Statement statement = conn.createStatement();
		// 3.2 需要执行的sql
		String sql = "select * from user";
		// 3.3 执行sql
		ResultSet rs = statement.executeQuery(sql);
		// 3.4 遍历结果
		while(rs.next()){
			System.out.print(rs.getInt("id")+" ");
			System.out.print(rs.getString("username")+" ");
			System.out.print(rs.getString("password")+" ");
			System.out.print(rs.getString("nickname")+" ");
			System.out.print(rs.getInt("age"));
			System.out.println();
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			conn = null;
		}

		// 4 释放资源
		rs.close();
		statement.close();
		conn.close();
		/*try {
			// 创建数据库连接
			Connection conn = C3P0Utils02.getConnection();

			// 执行SQL语句
			String sql = "select * from user";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);

			// 遍历结果
			while (rs.next()) {
				System.out.printf("%d %s %s %s %d %n", rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("nickname"), rs.getInt("age"));
			}

			// 释放资源
			C3P0Utils02.release(rs, stat, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
}
