package cn.bysjm.service.impl;

import cn.bysjm.dao.AccountDao;
import cn.bysjm.service.AccountService;
import cn.bysjm.util.ConnectionUtils;
import cn.bysjm.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ConnectionUtils connectionUtils;
    @Autowired
    private TransactionManager transactionManager;

    //手动控制事务
    /*    public void transfer(String outUser, String inUser, Double money) {

        Connection connection = null;
        try {
            // 开启事务
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            // 业务操作
            accountDao.out(connection,outUser, money);// 转出
            // 制作bug
            int i = 1 / 0;
            accountDao.in(connection,inUser, money);// 转入
            System.out.println("转账成功...");

            // 提交事务
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            // 回滚事务
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            // 释放资源
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
    //ThreadLocal控制事务
    /*public void transfer(String outUser, String inUser, Double money) {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            accountDao.in(inUser,money);
            int a = 1 / 0;
            accountDao.out(outUser,money);
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connectionUtils.getThreadConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                connectionUtils.getThreadConnection().setAutoCommit(true);
                connectionUtils.getThreadConnection().close();
                connectionUtils.removeThreadConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/

    //版本三
    @Override
    public void transfer(String outUser, String inUser, Double money) {
        try {
            transactionManager.beginTransaction();
            accountDao.in(inUser, money);
            int a = 1 / 0;
            accountDao.out(outUser, money);
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }
    }
}
