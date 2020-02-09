package cn.ade.dbutils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.ade.utils.C3P0Utils02;

/**
 * 需求：查询单值
 * 
 * @author ade
 * @version 1.0，2017-10-08 16:38:43 
 */
public class ScalarHandlerDemo {

	/**
	 * 练习ScalarHandler，查询单值
	 * */
	@Test
	public void method01() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());
			String sql = "select username from user where id = ?";
			String username = queryRunner.query(sql, new ScalarHandler<String>(), 1);
			System.out.println(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
