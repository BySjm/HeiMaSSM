package cn.bysjm.dao.impl;

import cn.bysjm.dao.AccountDao;
import cn.bysjm.util.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public void out(String outUser, Double money) {
        String sql = "update account set money = money - ? where name = ?";
        try {
            int update = queryRunner.update(connectionUtils.getThreadConnection(),sql, money, outUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void out(Connection connection,String outUser, Double money) {
        String sql = "update account set money = money - ? where name = ?";
        try {
            int update = queryRunner.update(connection,sql, money, outUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void in(String inUser, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        try {
            int update = queryRunner.update(connectionUtils.getThreadConnection(),sql, money, inUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void in(Connection connection,String inUser, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        try {
            int update = queryRunner.update(connection,sql, money, inUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
