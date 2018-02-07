package org.transaction.service;

public interface AccountService {
    void transfer(Integer from, Integer to, Double money);
}
