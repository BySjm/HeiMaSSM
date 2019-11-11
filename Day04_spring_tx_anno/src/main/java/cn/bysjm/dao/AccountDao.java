package cn.bysjm.dao;

public interface AccountDao {

    void out(String outUser, Double money);
    void in(String inUser, Double money);

}
