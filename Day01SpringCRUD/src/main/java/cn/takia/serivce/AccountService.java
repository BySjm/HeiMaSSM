package cn.takia.serivce;

import cn.takia.domain.Account;

import java.util.List;

public interface AccountService {
    // 新增
    public void save(Account account);

    // 修改
    public void update(Account account);

    // 删除
    public void delete(Integer id);

    // 查询一个
    public Account findById(Integer id);

    // 查询所有 课下作业
    public List<Account> findAll();
}
