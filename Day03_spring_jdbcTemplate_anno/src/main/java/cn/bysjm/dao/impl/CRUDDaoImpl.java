package cn.bysjm.dao.impl;

import cn.bysjm.dao.CRUDDao;
import cn.bysjm.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CRUDDaoImpl implements CRUDDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save() {
        String sql = "insert into account values(null,?,?)";
        int i = jdbcTemplate.update(sql, "sjm", "1000");
        System.out.println(i);
    }

    @Override
    public void update(Integer id) {
        String sql = "update account set money = ? where id = ?";
        int i = jdbcTemplate.update(sql, "1100", "2");
        System.out.println(i);
    }

    @Override
    public Account selectOne(Integer id) {
        String sql = "select * from account where id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), "2");
        return account;
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        List<Account> accounts = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        return accounts;
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete * from account where id = ?";
        int i = jdbcTemplate.update(sql,  "2");
        System.out.println(i);
    }
}
