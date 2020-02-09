package cn.ade.dbutils;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.junit.Test;
import cn.ade.utils.C3P0Utils02;

/**
 * 需求：查询某列
 * 
 * @author ade
 * @version 1.0，2017-10-08 16:24:53 
 */
public class ColumnListHandlerDemo {

	/**
	 * 练习ColumnListHandler，查询到的结果是装有某列数据的List集合
	 */
	@Test
	public void method01() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());
			String sql = "select username from user";
			List<Object> list = queryRunner.query(sql, new ColumnListHandler<Object>());
			for (Object obj : list) {
				System.out.println(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
