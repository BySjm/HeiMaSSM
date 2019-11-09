package cn.bysjm.dao;

import org.springframework.stereotype.Repository;


public interface AccountDao {
    void out(String outUser, Double money);

    void in(String inUser, Double money);
}
