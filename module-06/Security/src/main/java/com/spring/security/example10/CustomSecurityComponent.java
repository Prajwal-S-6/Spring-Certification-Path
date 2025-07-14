package com.spring.security.example10;

import org.springframework.stereotype.Component;

@Component("myCustomSecurityComponent")
public class CustomSecurityComponent {

    public boolean isIdOne(int id){
        return id == 1;
    }
}
