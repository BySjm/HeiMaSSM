package cn.takia.dao.impl;

import cn.takia.dao.AccountDao;
import cn.takia.domain.Account;
import cn.takia.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public void save(Account account) {
        try {
            String sql = "insert into `account` values (null,?,?)";
            queryRunner.update(sql, account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        try {
            String sql = "update `account` set name = ?, money = ? where id = ?";
            queryRunner.update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String sql = "delete from `account` where id = ?";
            queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findById(Integer id) {
        Account account = null;
        try {
            String sql = "select * from `account` where id = ?";
            account = queryRunner.query(sql, new BeanHandler<>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = null;
        try {
            String sql = "select * from `account` ";
            list = queryRunner.query(sql, new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
