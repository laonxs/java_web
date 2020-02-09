package cn.ade.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;
import cn.ade.domain.User;
import cn.ade.utils.C3P0Utils02;

/**
 * 需求：练习ResultSetHandler
 * 
 * @author ade
 * @version 1.0， 2017-10-08 16:52:49
 */
public class ResultSetHandlerDemo {
	
	/** 创建核心类对象 */
	QueryRunner queryRunner = new QueryRunner(C3P0Utils02.getDataSource());

	/**
	 * 查询单个记录
	 */
	@Test
	public void method01() {
		try {
			
			String sql = "select * from user where id = ?";
			User user = queryRunner.query(sql, new ResultSetHandler<User>(){

				@Override
				public User handle(ResultSet rs) throws SQLException {
					User user = new User();
					while(rs.next()) {
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setNickname(rs.getString("nickname"));
						user.setAge(rs.getInt("age"));
					}
					return user;
				}
				
			}, 1);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询多条记录
	 */
	@Test
	public void method02() {
		try {
			String sql = "select * from user";
			List<User> list = queryRunner.query(sql, new ResultSetHandler<List<User>>() {

				@Override
				public List<User> handle(ResultSet rs) throws SQLException {
					List<User> list = new ArrayList<User>();
					while(rs.next()) {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setNickname(rs.getString("nickname"));
						user.setAge(rs.getInt("age"));
						list.add(user);
					}
					return list;
				}

			});
			
			for (User user : list) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
