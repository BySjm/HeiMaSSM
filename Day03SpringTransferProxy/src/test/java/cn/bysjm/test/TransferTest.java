package cn.bysjm.test;

import cn.bysjm.service.AccountService;
import cn.bysjm.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransferTest {

    @Autowired
    @Qualifier("accountServiceCglibProxy")
    private AccountService accountService;

    @Test
    public void test(){
        accountService.transfer("tom","jerry",100d);
    }

}
