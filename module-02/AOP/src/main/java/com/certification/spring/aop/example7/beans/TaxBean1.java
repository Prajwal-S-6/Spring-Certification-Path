package com.certification.spring.aop.example7.beans;

import com.certification.spring.aop.example7.annotations.MonitoredRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("taxBean1")
@MonitoredRepository
public class TaxBean1 implements ITaxBean {
    @Override
    public float calculateTax(float value) {
        return 1f;
    }
}
