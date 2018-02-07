package org.transaction;

public interface AccountDao {

    //转账
    void increaseMoney(Integer id, Double money);

    void decreaseMoney(Integer id, Double money);
}
