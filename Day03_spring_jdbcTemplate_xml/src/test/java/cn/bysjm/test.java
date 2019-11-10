package cn.bysjm;

import cn.bysjm.domain.Account;
import cn.bysjm.util.JdbcUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加一条数据
    @Test
    public void save() throws Exception {
        String sql = "insert into account values(null,?,?)";
        int i = jdbcTemplate.update(sql, "sjm", 3000);
        System.out.println(i);
    }

    //查询单个
    @Test
    public void selectSingle() throws Exception {
        String sql = "select * from account where id = ?";
//        List<Account> account = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class),1);
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), 1);
        System.out.println(account);
    }

    //查询所有
    @Test
    public void findAll() throws Exception {
        String sql = "select * from account";
//        List<Account> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }

}
