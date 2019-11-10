package cn.bysjm.test;

import cn.bysjm.config.SpringConfig;
import cn.bysjm.domain.Account;
import cn.bysjm.service.CRUDService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AnnTest {

    @Autowired
    private CRUDService service;

    @Test
    public void test() throws Exception {
        List<Account> all = service.findAll();
        System.out.println(all);
    }

}
