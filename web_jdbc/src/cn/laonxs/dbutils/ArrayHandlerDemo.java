package cn.laonxs.dbutils;

import java.sql.SQLException;
import java.util.Arrays;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.junit.Test;
import cn.laonxs.utils.C3P0Utils02;

/**
 * 需求：查询一条记录
 * 
 * @author laonxs
 * @version 1.0， 2017-10-08 15:26:23
 */
public class ArrayHandlerDemo {
	
	/**
	 * 练习ArrayHandler，查询到的结果是一个Object[]
	 */
	@Test
	public void method01() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());
			String sql = "select * from user where id = ?";
			Object[] query = queryRunner.query(sql, new ArrayHandler(),1);
			System.out.println(Arrays.toString(query));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
