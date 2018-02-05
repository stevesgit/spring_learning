package org.proxy;

import org.service.UserService;
import org.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceProxyFactory2 implements MethodInterceptor {
    private UserService us;

    public UserServiceProxyFactory2(UserService us) {
        this.us = us;
    }

    public UserService getUserServiceProxy() {
        Enhancer en = new Enhancer();
        en.setSuperclass(UserServiceImpl.class);//对谁代理
        en.setCallback(this);//代理做什么
        UserService us = (UserService) en.create();
        return us;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("open transaction");
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("close transaction");
        return obj;
    }
}
