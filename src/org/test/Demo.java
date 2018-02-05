package org.test;

import org.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)//创建容器
@ContextConfiguration("classpath:applicationConfig.xml")
public class Demo {
    @Resource(name = "user")
    private User u;
    @Test
    public void fun1() {
        System.out.println(u);
        //创建所有对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationConfig.xml");
//        User u = (User) ac.getBean("user");
//        System.out.print(u);

    }

    @Test
    public void fun2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationConfig.xml");
        User u1 = (User) ac.getBean("user");
        System.out.println(u1.getCar().getPrice());
//        User u2 = (User) ac.getBean("user");
//        System.out.println(u1==u2);
    }

    @Test
    public void fun3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationConfig.xml");
        User u = (User) ac.getBean("user3");

    }
}
