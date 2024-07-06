package com.fawry.intern.atm.rest;

import com.fawry.intern.atm.commen.AccountModel;
import com.fawry.intern.atm.repository.entity.Account;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(atmService.getAllAccounts());
    }

    @GetMapping("findByID/{userId}")
    public ResponseEntity<Account> findAccount(@PathVariable long userId) {
        return ResponseEntity.ok(atmService.getAccountById(userId));
    }

    @PostMapping("create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountModel accountModel) {
        atmService.createAccount(accountModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/balance/{userId}")
    public ResponseEntity<Double> getBalance(@PathVariable long userId) {
        return ResponseEntity.ok(atmService.getBalance(userId));
    }

    @PostMapping(value = "/deposit", params = {"userId", "amount"})
    public ResponseEntity<String> deposit(@RequestParam long userId, @RequestParam double amount) {
        atmService.deposit(userId, amount);
        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping(value = "/withdraw", params = {"userId", "amount"})
    public ResponseEntity<String> withdraw(@RequestParam long userId, @RequestParam double amount) {
        atmService.withdraw(userId, amount);
        return ResponseEntity.ok("Withdraw successful");
    }
}
