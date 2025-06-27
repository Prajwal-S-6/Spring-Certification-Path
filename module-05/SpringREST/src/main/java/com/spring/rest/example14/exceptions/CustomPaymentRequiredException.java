package com.spring.rest.example14.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
public class CustomPaymentRequiredException extends RuntimeException {
    public CustomPaymentRequiredException(String message) {
        super(message);
    }
}
