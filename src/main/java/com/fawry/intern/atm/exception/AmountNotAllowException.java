package com.fawry.intern.atm.exception;

public class AmountNotAllowException extends  RuntimeException{
    public AmountNotAllowException(String message) {
        super(message);
    }
}
