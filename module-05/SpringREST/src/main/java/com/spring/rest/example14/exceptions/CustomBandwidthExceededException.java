package com.spring.rest.example14.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
public class CustomBandwidthExceededException extends RuntimeException {

}
