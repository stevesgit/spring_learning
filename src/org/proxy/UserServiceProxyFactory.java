package org.proxy;

import org.service.UserService;
import org.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxyFactory implements InvocationHandler {
    private UserService us;

    public UserServiceProxyFactory(UserService us) {
        this.us = us;
    }

    public UserService getUserServiceProxy() {
        UserService usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(), this);
        return usProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("open transaction");
        Object invoke = method.invoke(us, args);
        System.out.println("close transaction");
        return invoke;
    }
}
