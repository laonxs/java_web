package cn.laonxs.dbutils;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.junit.Test;
import cn.laonxs.utils.C3P0Utils02;

/**
 * 需求：查询所有记录
 * 
 * @author laonxs
 * @version 1.0， 2017-10-08 16:44:49
 */
public class KeyedHandlerDemo {

	/**
	 * 练习KeyedHandler，将一条记录封装到一个Map集合中。将多条记录封装到一个装有Map集合的Map集合中。而且外面的Map的key是可以指定的。
	 */
	@Test
	public void method01() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());
			String sql = "select * from user";
			Map<Object, Map<String, Object>> map = queryRunner.query(sql, new KeyedHandler<>("id"));
			Set<Object> keySet = map.keySet();
			for (Object object : keySet) {
				System.out.println("---------"+object+"---------");
				Map<String, Object> _map = map.get(object);
				Set<String> _keySet = _map.keySet();
				for (String str : _keySet) {
					System.out.println(str+"------"+_map.get(str));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
