package com.fawry.intern.atm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiException {

    private final String message;
    private final HttpStatus httpStatus;
}
