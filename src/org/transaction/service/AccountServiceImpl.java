package org.transaction.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.transaction.AccountDao;

public class AccountServiceImpl implements AccountService {


    private AccountDao ad;


    private TransactionTemplate tt;

    @Override
    public void transfer(Integer from, Integer to, Double money) {
        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //dec
                ad.decreaseMoney(from, money);
                //inc
                int i = 1 / 0;
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
