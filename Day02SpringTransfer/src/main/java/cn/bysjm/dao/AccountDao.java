package cn.bysjm.dao;

import java.sql.Connection;

public interface AccountDao {

    void out(String outUser, Double money);
    void out(Connection connection,String outUser, Double money);
    void in(String inUser, Double money);
    void in(Connection connection,String inUser, Double money);

}
