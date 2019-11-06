package cn.bysjm.test;

import cn.takia.domain.Account;
import cn.takia.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.util.List;

public class test {

    @Test
    public void test01() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "update account set money = money + ? where id = ?";
        int update = queryRunner.update(sql, 100, 2);
        System.out.println(update);
    }

    @Test
    public void test02() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from account";
        List<Account> query = queryRunner.query(sql, new BeanListHandler<>(Account.class));
        System.out.println(query);
    }

}
