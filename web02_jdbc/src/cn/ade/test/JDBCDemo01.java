package cn.ade.test;

import org.junit.Test;

import java.sql.*;

/**
 * 需求：jdbc 入门
 *
 * @author ade
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
        while (rs.next()) {
            System.out.print(rs.getInt("id") + " ");
            System.out.print(rs.getString("username") + " ");
            System.out.print(rs.getString("password") + " ");
            System.out.print(rs.getString("nickname") + " ");
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
    }

}
