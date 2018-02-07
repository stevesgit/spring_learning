package org.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.transaction.service.AccountService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/org/transaction/app2.xml")
public class Demo2 {
    @Resource(name = "accountService")
    private AccountService as;

    @Test
    public void fun1() {
        as.transfer(1, 2, 300.00);
    }
}
