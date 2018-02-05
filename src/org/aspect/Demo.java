package org.aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.UserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:org/aspect/app.xml")
public class Demo {
    @Resource(name="userService")
    private UserService us ;

    @Test
    public void fun1(){
        us.save();
    }
}
