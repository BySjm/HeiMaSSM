package cn.bysjm.service.impl;

import cn.bysjm.dao.AccountDao;
import cn.bysjm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, timeout = -1, readOnly = false)
    public void transfer(String inUser, String outUser, Double money) {
        accountDao.out(outUser, money);
        int i = 1 / 0;
        accountDao.in(inUser, money);
        System.out.println("转账成功...");
    }
}
