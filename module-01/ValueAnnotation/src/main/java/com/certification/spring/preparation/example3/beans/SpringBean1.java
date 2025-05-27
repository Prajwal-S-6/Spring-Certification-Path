package com.certification.spring.preparation.example3.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class SpringBean1 {

    @Value("Prajwal")
    private String name;

    @Value("#{'Wall street'.toUpperCase()}")
    private String streetName;

    @Value("false")
    private boolean isAccountExists;

    @Value("100")
    private Integer idNumber;

    @Value("#{5000 * 2}")
    private Integer accountBalance;

    @Value("${app.department.id}")
    private Integer departmentId;

    @Value("${app.department.name}")
    private String departmentName;

    @Value("${app.manager.name}")
    private String managerName;

    @Value("${app.support.contact}")
    private String supportContactMail;

//    @Value("${app.support.phone}")
    private final String supportPhone;

//    @Value("${app.support.address}")
    private final String supportAddress;

    @Value("${app.cases.id}")
    private List<Integer> casesId;

    @Value("${app.dependent.departments}")
    private String[] dependentDepartments;

    @Value("${app.cases.set}")
    private Set<String> casesSet;

    @Value("#{${app.cases.map}}")
    private Map<String, Integer> casesMap;

    @Value("#{springBean2.taxId}")
    private String taxId;

    public SpringBean1(@Value("${app.support.phone}") String supportPhone, @Value("${app.support.address}") String supportAddress) {
        this.supportPhone = supportPhone;
        this.supportAddress = supportAddress;
    }

    public String getName() {
        return name;
    }

    public String getStreetName() {
        return streetName;
    }

    public boolean isAccountExists() {
        return isAccountExists;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getSupportContactMail() {
        return supportContactMail;
    }

    public String getSupportPhone() {
        return supportPhone;
    }

    public String getSupportAddress() {
        return supportAddress;
    }

    public List<Integer> getCasesIds() {
        return casesId;
    }

    public String[] getDependentDepartments() {
        return dependentDepartments;
    }

    public Set<String> getCasesSet() {
        return casesSet;
    }

    public Map<String, Integer> getCasesMap() {
        return casesMap;
    }

    public String getTaxId() {
        return taxId;
    }
}
