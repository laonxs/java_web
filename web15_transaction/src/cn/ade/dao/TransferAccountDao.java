package cn.ade.dao;

import cn.ade.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

/**
 * 需求：转账
 * 
 * @author ade
 * @version 1.0，2017-10-14 19:02:09 
 */
public class TransferAccountDao {

	/**
	 * 转账
	 * 
	 * @param from 付款人
	 * @param to 收款人
	 * @param money 转账金额
	 * @exception
	 */
	public void transfer(String from, String to, String money) throws Exception {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update account set money = money + ? where name = ?";
		double _money = Double.parseDouble(money);
		Connection conn = JDBCUtils.getConnection();
		queryRunner.update(conn, sql, -_money, from);
		// System.out.println(1/0);
		queryRunner.update(conn, sql, _money, to);
	}

}
