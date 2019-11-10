package cn.bysjm.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* cn.bysjm.service..*.*(..))")
    public void myPointcut(){}

//    @Before("MyAdvice.myPointcut()")
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

    @Around("myPointcut()")
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
