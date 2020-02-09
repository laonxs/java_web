package cn.ade.dbutils;

import cn.ade.domain.User;
import cn.ade.utils.C3P0Utils02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;

/**
 * 需求：查询一条记录
 * 
 * @author ade
 * @version 1.0， 2017-10-08 15:54:59
 */
public class BeanHandlerDemo {

	/**
	 * 练习BeanHandler,查询到的结果会封装到一个JavaBean中
	 */
	@Test
	public void method01() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());
			String sql = "select * from user where id = ?";
			User user = queryRunner.query(sql, new BeanHandler<User>(User.class), 1);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
