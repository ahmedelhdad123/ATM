package com.fawry.intern.atm.service;


import com.fawry.intern.atm.commen.AccountModel;
import com.fawry.intern.atm.repository.entity.Account;

import java.util.List;


public interface AtmService {
    void createAccount(AccountModel accountModel);
    List<Account> getAllAccounts();
    Account getAccountById(long userId);
    void deposit(long userId, double amount);
    void withdraw(long userId, double amount);
    double getBalance(long userId);
}
