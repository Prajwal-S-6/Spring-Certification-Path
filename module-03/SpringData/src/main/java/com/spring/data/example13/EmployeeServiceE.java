package com.spring.data.example13;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceE {

    @Transactional
    protected void operationEProtected() {

    }

    @Transactional
    private void operationEPrivate() {
        System.out.println("Invoked operationEPrivate");
    }

    @Transactional
    void operationEPackage() {

    }
}
