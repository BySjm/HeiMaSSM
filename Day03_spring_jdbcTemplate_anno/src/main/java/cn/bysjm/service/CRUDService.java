package cn.bysjm.service;

import cn.bysjm.domain.Account;

import java.util.List;

public interface CRUDService {
    void save();
    void update(Integer id);
    Account selectOne(Integer id);
    List<Account> findAll();
    void delete(Integer id);
}
