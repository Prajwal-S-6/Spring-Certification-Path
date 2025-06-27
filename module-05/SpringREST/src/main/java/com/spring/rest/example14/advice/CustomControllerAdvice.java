package com.spring.rest.example14.advice;

import com.spring.rest.example14.exceptions.CustomPaymentRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(CustomPaymentRequiredException.class)
    @ResponseBody
    public String customPaymentRequiredExceptionHandler(Exception e) {
        return "Global level exception handling using ControllerAdvice " + e.getMessage();
    }
}
