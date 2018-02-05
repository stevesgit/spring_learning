package org.proxy;

import org.junit.Test;
import org.service.UserService;
import org.service.UserServiceImpl;

public class Demo {
        //动态代理
    @Test
    public void fun1(){
        UserService us = new UserServiceImpl();
        UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
        UserService usProxy = factory.getUserServiceProxy();
        usProxy.save();
    }
    @Test
    public void fun2(){
        UserService us = new UserServiceImpl();
        UserServiceProxyFactory2 factory = new UserServiceProxyFactory2(us);
        UserService usProxy = factory.getUserServiceProxy();
        usProxy.save();
    }
}
