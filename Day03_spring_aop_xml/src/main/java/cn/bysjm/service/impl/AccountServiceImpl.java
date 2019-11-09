package cn.bysjm.service.impl;

import cn.bysjm.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void transfer() {
        int i = 1 / 0;
        System.out.println("转账成功...");
    }

    @Override
    public void findAll() {
        System.out.println("查询所有");
    }
}
