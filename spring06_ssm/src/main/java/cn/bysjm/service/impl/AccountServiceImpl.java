package cn.bysjm.service.impl;

import cn.bysjm.dao.AccountDao;
import cn.bysjm.domain.Account;
import cn.bysjm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }
}
