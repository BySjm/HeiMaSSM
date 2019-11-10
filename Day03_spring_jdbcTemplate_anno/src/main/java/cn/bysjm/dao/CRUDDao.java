package cn.bysjm.dao;

import cn.bysjm.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CRUDDao {
    void save();
    void update(Integer id);
    Account selectOne(Integer id);
    List<Account> findAll();
    void delete(Integer id);
}
