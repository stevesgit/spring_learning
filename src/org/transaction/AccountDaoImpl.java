package org.transaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void increaseMoney(Integer id, Double money) {
        super.getJdbcTemplate().update("update account set money = money+ ? where id = ?", money, id);
    }

    @Override
    public void decreaseMoney(Integer id, Double money) {
        super.getJdbcTemplate().update("update account set money = money- ? where id = ?", money, id);

    }
}
