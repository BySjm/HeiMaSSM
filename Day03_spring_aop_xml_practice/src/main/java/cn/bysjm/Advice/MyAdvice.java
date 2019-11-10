package cn.bysjm.Advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAdvice {

    public void before() {
        System.out.println("前置通知...");
    }

    public Object around(ProceedingJoinPoint pjp) {
        Object o = null;
        Object[] args = pjp.getArgs();
        try {
            System.out.println("前置通知");
            o = pjp.proceed(args);
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知");
        } finally {
            System.out.println("最终通知");
        }
        return o;
    }

}
