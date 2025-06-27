package com.spring.rest.example14.controllers;

import com.spring.rest.example14.ds.Customer;
import com.spring.rest.example14.exceptions.CustomBadRequestException;
import com.spring.rest.example14.exceptions.CustomBandwidthExceededException;
import com.spring.rest.example14.exceptions.CustomPaymentRequiredException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller6")
public class Controller6 {

    @GetMapping("/method1")
    public Customer method1() {
        throw new CustomBadRequestException();
    }

    @GetMapping("/method2")
    public Customer method2() {
        throw new CustomPaymentRequiredException("Payment is required");
    }

    @GetMapping("/method3")
    public Customer method3() {
        throw new CustomBandwidthExceededException();
    }

    @ExceptionHandler(CustomBadRequestException.class)
    public String customBadRequestHandler(Exception e) {
        ResponseStatus responseStatus = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
        return "Exception was handled by ExceptionHandler " + responseStatus.reason();
    }
}
