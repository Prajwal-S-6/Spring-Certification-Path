package com.spring.rest.example12.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED, reason = "Payment is Required")
public class CustomPaymentRequiredException extends RuntimeException {

}
