package com.fawry.intern.atm.exception;

public class AccountNotFountException extends RuntimeException{
    public AccountNotFountException(String message) {
        super(message);
    }
}