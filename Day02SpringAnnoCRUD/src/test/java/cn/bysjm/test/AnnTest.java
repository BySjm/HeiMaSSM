package cn.bysjm.test;

import cn.bysjm.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service = app.getBean("accountServiceImpl", AccountService.class);
        service.findAll();
    }

}
