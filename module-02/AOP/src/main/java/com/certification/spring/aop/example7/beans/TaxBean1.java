package com.certification.spring.aop.example7.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("taxBean1")
public class TaxBean1 implements ITaxBean {
    @Override
    public float calculateTax(float value) {
        return 1f;
    }
}
