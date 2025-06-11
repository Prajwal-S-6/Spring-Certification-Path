package com.spring.data.example13.service;

import org.springframework.transaction.annotation.Transactional;

public interface EmployeeServiceD {

    @Transactional
    void operationD();
}
