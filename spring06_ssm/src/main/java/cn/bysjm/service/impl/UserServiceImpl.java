package cn.bysjm.service.impl;

import cn.bysjm.dao.UserDao;
import cn.bysjm.domain.User;
import cn.bysjm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
