package com.fawry.intern.atm.rest;

import com.fawry.intern.atm.commen.AccountModel;
import com.fawry.intern.atm.repository.entity.Account;
import com.fawry.intern.atm.repository.entity.AmountRequest;
import com.fawry.intern.atm.service.AtmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atm")
public class AtmResource {

    private final AtmService atmService;

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(atmService.getAllAccounts());
    }

    @GetMapping("{userId}")
    public ResponseEntity<Account> findAccount(@PathVariable long userId) {
        return ResponseEntity.ok(atmService.getAccountById(userId));
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountModel accountModel) {
        atmService.createAccount(accountModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{userId}/balance")
    public ResponseEntity<Double> getBalance(@PathVariable long userId) {
        return ResponseEntity.ok(atmService.getBalance(userId));
    }

    @PostMapping(value = "{userId}/deposit")
    public ResponseEntity<String> deposit(@PathVariable long userId, @RequestBody AmountRequest request) {
        double amount = request.getAmount();
        atmService.deposit(userId, amount);
        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping(value = "{userId}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable long userId, @RequestBody AmountRequest request) {
        double amount = request.getAmount();
        atmService.withdraw(userId, amount);
        return ResponseEntity.ok("Withdraw successful");
    }
}
