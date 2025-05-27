package com.certification.spring.preparation.example3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean2 {

    @Value("6")
    private int taxId;

    @Value("#{${app.tax.value}/100.0}")
    private float taxValue;

    @Value("#{'${app.tax.department.name}'.toUpperCase()}")
    private String taxDepartmentName;

    @Value("${tax.department.alt.name:IS}")
    private String taxDepartmentAltName;

    public int getTaxId() {
        return taxId;
    }

    public float getTaxValue() {
        return taxValue;
    }

    public String getTaxDepartmentName() {
        return taxDepartmentName;
    }

    public String getTaxDepartmentAlternateName() {
        return taxDepartmentAltName;
    }
}
