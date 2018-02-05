package org.aspect;


import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
    //前置
    public void before() {
        System.out.println("前置通知");
    }

    //后置
    public void afterReturning() {
        System.out.println("后置通知 出现异常不会调用");
    }

    //环绕
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知");
        Object proceed = pjp.proceed();
        System.out.println("环绕通知");
        return proceed;
    }
    //异常拦截
    public void afterException(){
        System.out.println("异常通知");
    }
    //后置通知
    public void after(){
        System.out.println("后置通知出现异常也会调用");
    }
}
