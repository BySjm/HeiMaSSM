package cn.bysjm.test;

import cn.bysjm.config.SpringConfig;
import cn.bysjm.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnTest {

    @Test
    public void test() throws Exception {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService service = app.getBean(AccountService.class);
        service.findAll();
    }

}
