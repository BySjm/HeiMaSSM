package cn.bysjm.test;

import cn.takia.domain.Account;
import cn.takia.serivce.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = app.getBean("accountService", AccountService.class);
//        Account account = accountService.findById(1);
//        System.out.println(account);
        List<Account> list = accountService.findAll();
        System.out.println(list);
    }

}
