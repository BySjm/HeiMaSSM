package cn.bysjm.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

// 事务管理器（工具类）
@Component
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Around("execution(* cn.bysjm.service..*.*(..))")
    public Object around(ProceedingJoinPoint pjp){
        Object o = null;
        Object[] args = pjp.getArgs();
        try {
            connectionUtils.getTreadConnection().setAutoCommit(false);
            o = pjp.proceed(args);
            connectionUtils.getTreadConnection().commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            try {
                connectionUtils.getTreadConnection().rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                connectionUtils.getTreadConnection().setAutoCommit(true);
                connectionUtils.getTreadConnection().close();
                connectionUtils.removeThreadConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return o;
    }

}
