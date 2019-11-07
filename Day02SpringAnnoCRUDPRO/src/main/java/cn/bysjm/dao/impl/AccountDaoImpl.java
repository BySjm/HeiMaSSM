package cn.bysjm.dao.impl;

import cn.bysjm.dao.AccountDao;
import cn.bysjm.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public void findAll() {
        try {
            String sql = "select * from `account`";
            List<Account> list = queryRunner.query(sql, new BeanListHandler<>(Account.class));
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
