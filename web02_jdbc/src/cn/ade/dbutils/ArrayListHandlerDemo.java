package cn.ade.dbutils;

import cn.ade.utils.C3P0Utils02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * 需求：查询所有记录
 * 
 * @author ade
 * @version 1.0， 2017-10-08 15:44:05
 */
public class ArrayListHandlerDemo {

	/**
	 * 练习ArrayListHandler，查询到的结果是一个装有Object[]的List集合
	 */
	@Test
	public void method01() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());
			String sql = "select * from user";
			List<Object[]> query = queryRunner.query(sql, new ArrayListHandler());
			for (Object[] obj : query) {
				System.out.println(Arrays.toString(obj));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
