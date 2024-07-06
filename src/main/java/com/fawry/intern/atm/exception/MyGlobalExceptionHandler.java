package com.fawry.intern.atm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(AccountNotFountException.class)
    public ResponseEntity<ApiException> handleAccountNotFount(AccountNotFountException exception) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiException apiException=new ApiException(
                exception.getMessage(),
                status
        );
        return new ResponseEntity<>(apiException, status);
    }

    @ExceptionHandler(AmountNotAllowException.class)
    public ResponseEntity<ApiException> handleAmountNotAllow(AmountNotAllowException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiException apiException=new ApiException(
                exception.getMessage(),
                status
        );
        return new ResponseEntity<>(apiException, status);
    }

}
