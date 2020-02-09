package cn.ade.dbutils;

import cn.ade.domain.User;
import cn.ade.utils.C3P0Utils02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * 需求：查询所有记录
 * 
 * @author ade
 * @version 1.0，2017-10-08 16:05:04 
 */
public class BeanListHandlerDemo {

	/**
	 * 练习BeanListHandler,查询到的结果是一个装有JavaBean的List集合
	 */
	@Test
	public void method01() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());
			String sql = "select * from user";
			List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class));
			for (User user : users) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
