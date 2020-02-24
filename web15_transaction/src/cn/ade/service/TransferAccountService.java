package cn.ade.service;

import cn.ade.dao.TransferAccountDao;
import cn.ade.utils.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 需求：业务类
 *
 * @author ade
 * @version 1.0，2017-10-14 18:58:26
 */
public class TransferAccountService {

    /**
     * 转账的业务操作
     *
     * @param from  付款人
     * @param to    收款人
     * @param money 转账金额
     * @throws SQLException
     * @throws Exception
     */
    public void transfer(String from, String to, String money) throws SQLException {
        Connection conn = null;
        try {
            // 开启事务
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);

            // 处理数据
            TransferAccountDao dao = new TransferAccountDao();
            dao.transfer(from, to, money);

            // 提交事务
            DbUtils.commitAndClose(conn);
        } catch (Exception e) {
            // 回滚事务
            DbUtils.rollbackAndClose(conn);
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
