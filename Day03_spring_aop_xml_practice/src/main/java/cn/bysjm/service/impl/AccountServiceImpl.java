package cn.bysjm.service.impl;

import cn.bysjm.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void transfer() {
//        int a = 1 / 0;
        System.out.println("转账完成");
    }
}
