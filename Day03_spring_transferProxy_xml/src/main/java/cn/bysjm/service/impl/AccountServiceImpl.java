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
    public void transfer(String outUser, String inUser, Double money) {
        // 业务操作
        accountDao.out(outUser, money);
        // 异常
//        int i = 1 / 0;
        accountDao.in(inUser, money);
        System.out.println("转账成功....");
    }
}
