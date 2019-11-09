package cn.bysjm.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

    public void before(){
        System.out.println("前置通知");
    }

    public void afterReturning(){
        System.out.println("后置通知");
    }

    public void afterThrowing(){
        System.out.println("异常通知");
    }

    public void after(){
        System.out.println("最终通知");
    }

    public Object around(ProceedingJoinPoint pjp){
        Object object = null;
        Object[] args = pjp.getArgs();
        try {
            System.out.println("前置通知");
            object = pjp.proceed(args);
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常通知");
        }finally {
            System.out.println("最终通知");
        }
        return object;
    }

}
