package org.transaction.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.transaction.AccountDao;

public class AccountServiceImpl implements AccountService {


    private AccountDao ad;


    private TransactionTemplate tt;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(Integer from, Integer to, Double money) {
        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //dec
                ad.decreaseMoney(from, money);
                int i = 1 / 0;
                //inc
                ad.increaseMoney(to, money);
            }
        });

    }

    public void setAd(AccountDao ad) {
        this.ad = ad;
    }

    public void setTt(TransactionTemplate tt) {
        this.tt = tt;
    }
}
