package com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.service;


import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.components.TaxCalculationComponent;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.dao.TaxRateDao;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.Article;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.TaxCalculation;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.TaxInformation;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.TaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxInformationService {

    @Autowired
    private TaxRateDao taxRateDao;
    @Autowired
    private TaxCalculationComponent taxCalculationComponent;

    public TaxInformation getTaxInformation(Article article) {
        TaxRate taxRate = taxRateDao.getTaxRate(article);

        TaxCalculation taxCalculation = taxCalculationComponent.calculateTax(article, taxRate);

        return new TaxInformation(article, taxCalculation);
    }
}
