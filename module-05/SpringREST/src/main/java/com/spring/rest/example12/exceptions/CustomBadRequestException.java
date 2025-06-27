package com.spring.rest.example12.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This is a bad request")
public class CustomBadRequestException extends RuntimeException {

}
