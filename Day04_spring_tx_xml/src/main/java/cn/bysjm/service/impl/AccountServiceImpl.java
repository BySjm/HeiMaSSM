package cn.bysjm.service.impl;

import cn.bysjm.dao.AccountDao;
import cn.bysjm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String inUser, String outUser, Double money) {
        accountDao.out(outUser,money);
        int a = 1 / 0;
        accountDao.in(inUser,money);
        System.out.println("转账成功...");
    }
}
