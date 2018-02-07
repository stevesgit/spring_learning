package org.jdbc_template;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.bean.customer;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:org/jdbc_template/app.xml")
public class Demo {
    @Resource(name = "customerDao")
    private CustomerDao cd;

    @Test
    public void fun2() {
        customer customer = new customer();
        customer.setSex(1);
        customer.setBirthday("1994-09-12");
        customer.setAddress("创业大街25号楼2楼");
        customer.setName("sjf");
        cd.save(customer);

    }

    @Test
    public void fun3() {
        customer customer = new customer();
        customer.setId(2);
        customer.setName("Kuzma");
        cd.update(customer);
    }

    @Test
    public void fun4() {
        customer customer = new customer();
        cd.delete(2);
    }

    @Test
    public void fun5() {
        customer customer = new customer();
        int total = cd.getTotalCount();
        System.out.println(total);
    }

    @Test
    public void fun6() {
        System.out.println(cd.getAll());
    }

    @Test
    public void fun1() throws Exception {
        //
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //1
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1/customer?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("Wujiahui2013");
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String datestr = new Date().toString();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String date = ft.format(new Date());
//        System.out.println(date);
        String sql = "insert into user values(null,'steve',1,'杭州', '" + date + "')";
        System.out.println(sql);
        jt.update(sql);
    }
}
