package cn.bysjm.service.impl;

import cn.bysjm.dao.CRUDDao;
import cn.bysjm.domain.Account;
import cn.bysjm.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDServiceImpl implements CRUDService {

    @Autowired
    private CRUDDao crudPractice;

    @Override
    public void save() {
        crudPractice.save();
    }

    @Override
    public void update(Integer id) {
        crudPractice.update(id);
    }

    @Override
    public Account selectOne(Integer id) {
        return crudPractice.selectOne(id);
    }

    @Override
    public List<Account> findAll() {
        return crudPractice.findAll();
    }

    @Override
    public void delete(Integer id) {
        crudPractice.delete(id);
    }
}
