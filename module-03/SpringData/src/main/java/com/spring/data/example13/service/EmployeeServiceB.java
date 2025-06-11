package com.spring.data.example13.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceB {

    @Transactional
    public void operationB() {
    }
}
