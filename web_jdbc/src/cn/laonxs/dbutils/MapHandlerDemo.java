package cn.laonxs.dbutils;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;
import cn.laonxs.utils.C3P0Utils02;

/**
 * 需求：查询一条记录
 * 
 * @author laonxs
 * @version 1.0， 2017-10-08 16:12:33
 */
public class MapHandlerDemo {

	/**
	 * 练习MapHandler,查询到的结果是一个Map集合，key是字段名，value是存储的值。
	 */
	@Test
	public void method01() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());
			String sql = "select * from user where id = ?";
			Map<String, Object> map = queryRunner.query(sql, new MapHandler(), 1);
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				System.out.println(key+"\t\t"+map.get(key));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
