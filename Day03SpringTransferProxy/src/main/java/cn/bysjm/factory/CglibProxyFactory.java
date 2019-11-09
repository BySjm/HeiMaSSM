package cn.bysjm.factory;

import cn.bysjm.service.AccountService;
import cn.bysjm.service.impl.AccountServiceImpl;
import cn.bysjm.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class CglibProxyFactory {

    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;

    @Autowired
    TransactionManager transactionManager;

    @Bean("accountServiceCglibProxy")
    public AccountService CreateAccountServiceCglibProxy() {
        AccountService accountServiceProxy = null;
        accountServiceProxy = (AccountService) Enhancer.create(accountService.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                try {
                    transactionManager.beginTransaction();
                    result = methodProxy.invoke(accountService, objects);
                    transactionManager.commit();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    transactionManager.rollback();
                } finally {
                    transactionManager.release();
                }
                return result;
            }
        });
        return accountServiceProxy;
    }

}
