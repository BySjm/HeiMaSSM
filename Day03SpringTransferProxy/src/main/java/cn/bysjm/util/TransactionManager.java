package cn.bysjm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

// 事务管理器（工具类）
@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;


    // 开启事务
    public void beginTransaction(){
        try {
            connectionUtils.getTreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 提交事务
    public void commit(){
        try {
            connectionUtils.getTreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 回滚事务
    public void rollback(){
        try {
            connectionUtils.getTreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 释放资源
    public  void release(){
        try {
            connectionUtils.getTreadConnection().setAutoCommit(true);
            connectionUtils.getTreadConnection().close();
            connectionUtils.removeThreadConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
