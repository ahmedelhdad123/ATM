package com.fawry.intern.atm.service.impl;

import com.fawry.intern.atm.commen.AccountModel;
import com.fawry.intern.atm.exception.AccountNotFountException;
import com.fawry.intern.atm.exception.AmountNotAllowException;
import com.fawry.intern.atm.repository.AtmRepo;
import com.fawry.intern.atm.repository.entity.Account;
import com.fawry.intern.atm.repository.entity.Status;
import com.fawry.intern.atm.service.AtmService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AtmServiceImpl implements AtmService {


    private final AtmRepo atmRepo;





    @Override
    public Account getAccountById(long userId) {
        return atmRepo.findById(userId)
                .orElseThrow(() -> new AccountNotFountException("Account Not Found"));
    }

    @Override
    @Transactional
    public void createAccount(final AccountModel accountModel) {
        Account account = new Account();
        account.setUserId(accountModel.getUserId());
        account.setBalance(accountModel.getBalance());
        account.setName(accountModel.getName());
        account.setStatus(accountModel.getStatus());
        atmRepo.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return atmRepo.findAll();
    }

    @Override
    @Transactional
    public void deposit(long userId, double amount) {
        if (amount <= 0) {
            throw new AmountNotAllowException("Amount Not Allowed ");
        }
        Account account = getAccountById(userId);
        account.setBalance(account.getBalance() + amount);
        atmRepo.save(account);
    }

    @Override
    @Transactional
    public void withdraw(long userId, double amount) {
        Account account = getAccountById(userId);
        if (amount <= 0) {
            throw new AmountNotAllowException("Amount Not Allowed: Withdrawal amount must be greater than zero");
        }
        double currentBalance = account.getBalance();
        double newBalance = currentBalance - amount;
        final double ALLOW_OVERDRAFT_LIMIT = 5000.0;

        if (newBalance < 0) {
            if (account.getStatus().equals(Status.NOT_VIP)) {
                throw new AmountNotAllowException("Amount Not Allowed: Insufficient balance for non-VIP account");
            } else {
                if (-newBalance > ALLOW_OVERDRAFT_LIMIT) {
                    throw new AmountNotAllowException("Amount Not Allowed: Exceeds overdraft limit for VIP account");
                }
            }
        }
        account.setBalance(newBalance);
        atmRepo.save(account);
    }


    @Override
    public double getBalance(long userId) {
        Account account = getAccountById(userId);
        return account.getBalance();
    }
}
