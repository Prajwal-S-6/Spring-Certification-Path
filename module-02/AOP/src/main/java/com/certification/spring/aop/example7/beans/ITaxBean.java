package com.certification.spring.aop.example7.beans;

import com.certification.spring.aop.example7.annotations.MonitoredRepository;

public interface ITaxBean {
    float calculateTax(float value);

}
