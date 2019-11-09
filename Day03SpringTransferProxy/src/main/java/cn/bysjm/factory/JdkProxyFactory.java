package cn.bysjm.factory;

import cn.bysjm.service.AccountService;
import cn.bysjm.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class JdkProxyFactory {


    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    @Bean("accountServiceJdkProxy")
    public AccountService accountServiceJdkProxy() {
        AccountService accountServiceJdkProxy = null;
        accountServiceJdkProxy = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    transactionManager.beginTransaction();
                    result = method.invoke(accountService,args);
                    transactionManager.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    transactionManager.rollback();
                } finally {
                    transactionManager.release();
                }

                return result;
            }
        });
        return accountServiceJdkProxy;
    }

}
