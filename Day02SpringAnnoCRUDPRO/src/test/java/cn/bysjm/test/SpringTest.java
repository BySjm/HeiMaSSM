package cn.bysjm.test;

import cn.bysjm.config.SpringConfig;
import cn.bysjm.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfig.class})
public class SpringTest {

    @Autowired
    private AccountService service;

    @Test
    public void test() throws Exception {
        service.findAll();
    }
}
