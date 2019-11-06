package com.bysjm.test;

import cn.bysjm.dao.UserDao;
import cn.bysjm.domain.User;
import cn.bysjm.service.UserService;
import cn.bysjm.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {

    @Test
    public void test01() throws Exception {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = app.getBean("userService", UserService.class);
        //UserService userService = app.getBean(UserService.class);
        userService.save();
    }

    @Test
    public void test02() throws Exception {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = app.getBean("user", User.class);
        System.out.println(user);

    }

    @Test
    public void test03() throws Exception {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = app.getBean("userDao", UserDao.class);
        userDao.save();
    }

}
