package cn.ade.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 需求：jdbc工具类
 *
 * @author ade
 * @version 1.0，2017-10-14 18:38:12
 */
public class JDBCUtils {

    /**
     * c3p0连接池
     */
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /** 给当前线程绑定连接 */
	 private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

    /**
     * 获取数据库连接
     *
     * @return Connection 数据库连接
     * @throws SQLException 执行SQL语句的异常
     */
    public static Connection getConnection() {
        try {
            // 使用传统方式
//            return dataSource.getConnection();

            // 使用线程ThreadLocal方式
            Connection conn = local.get();
            if (conn == null) {
				conn = dataSource.getConnection();
				local.set(conn);
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
