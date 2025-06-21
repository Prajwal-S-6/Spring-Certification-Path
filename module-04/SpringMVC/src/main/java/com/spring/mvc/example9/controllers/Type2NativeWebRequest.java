package com.spring.mvc.example9.controllers;

import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import static com.spring.mvc.example9.utils.JoinUtils.join;

@RestController
public class Type2NativeWebRequest {

    @GetMapping("/actionB")
    public String actionB(NativeWebRequest nativeWebRequest) {
        return String.format("Request with headers and request params: Headers: %s, Params: %s", join(nativeWebRequest.getHeaderNames()), join(nativeWebRequest.getParameterNames()));
    }
}
