package cn.bysjm.service.impl;

import cn.bysjm.dao.UserDao;
import cn.bysjm.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
