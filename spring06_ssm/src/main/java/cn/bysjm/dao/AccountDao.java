package cn.bysjm.dao;

import cn.bysjm.domain.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountDao {

    List<Account> findAll();

}
