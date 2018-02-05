package org.bean;

import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("user")
@Scope(scopeName = "singleton")//对象的作用范围
public class User {
    @Value("tom")//反射Field赋值
    private String name;
    @Value("黄河街道")
    private String address;
    @Value("1")
    private int age;

    @Autowired//自动装配 如果匹配多个类型一致的对象则无法选择
    @Qualifier("car2")//预选 防止多个类型选择一个
//  @Resource  也可以用这个
    private Car car;
    public User() {
        System.out.println("test");
    }
    @PostConstruct//对象被构造后 初始化方法
    public void init(){
        System.out.println("init...");
    }
    @PreDestroy//销毁前被调用
    public void destroy()
    {
        System.out.println("destroy...");
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }
    @Value("kobe")//通过set方法赋值
    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
