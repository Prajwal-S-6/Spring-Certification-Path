package com.spring.rest.example14.advice;

import com.spring.rest.example14.exceptions.CustomBadRequestException;
import com.spring.rest.example14.exceptions.CustomBandwidthExceededException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomControllerAdvice2 {

    @ExceptionHandler(CustomBandwidthExceededException.class)
    public String customBadRequestExceptionHandler(Exception e) {
        return "Global level bad request exception handler using @RestControllerAdvice " + e;
    }
}
