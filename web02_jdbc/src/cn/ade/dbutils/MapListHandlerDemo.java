package cn.ade.dbutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import cn.ade.utils.C3P0Utils02;

/**
 * 需求：查询所有记录
 * 
 * @author ade
 * @version 1.0， 2017-10-08 16:18:23
 */
public class MapListHandlerDemo {

	/**
	 * 练习MapListHandler,查询到的结果是装有Map集合的List集合
	 */
	@Test
	public void method01() {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());
			String sql = "select * from user";
			List<Map<String,Object>> list = queryRunner.query(sql, new MapListHandler());
			for (Map<String, Object> map : list) {
				Set<String> keySet = map.keySet();
				for (String key : keySet) {
					System.out.println(key+"-----"+map.get(key));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
