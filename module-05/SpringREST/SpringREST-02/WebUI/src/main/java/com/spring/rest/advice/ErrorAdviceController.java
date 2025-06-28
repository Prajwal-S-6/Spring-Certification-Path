package com.spring.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorAdviceController {

    @ExceptionHandler(Throwable.class)
    public String exception(Throwable e, Model model) {
        String errorMessage = (e != null ? e.getMessage() : "Error occurred");
        model.addAttribute("httpStatus", HttpStatus.INTERNAL_SERVER_ERROR);
        model.addAttribute("reasonPhrase", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}
