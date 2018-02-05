package org.aspect_annotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
//表示该类是一个通知类
public class MyAdvice {
    //前置
    //指定该方法是指定通知且是切入点
    @Before("execution(* org.service.*ServiceImpl.*(..))")
    public void before() {
        System.out.println("前置通知");
    }

    //后置
    @AfterReturning("execution(* org.service.*ServiceImpl.*(..))")
    public void afterReturning() {
        System.out.println("后置通知 出现异常不会调用");
    }

    //环绕
    @Around("execution(* org.service.*ServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知");
        Object proceed = pjp.proceed();
        System.out.println("环绕通知");
        return proceed;
    }
    //异常拦截
    @AfterThrowing("execution(* org.service.*ServiceImpl.*(..))")
    public void afterException(){
        System.out.println("异常通知");
    }
    //后置通知
    @After("execution(* org.service.*ServiceImpl.*(..))")
    public void after(){
        System.out.println("后置通知出现异常也会调用");
    }
}
