package com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.components;


import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.Article;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.TaxCalculation;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.TaxRate;
import org.springframework.stereotype.Component;

@Component
public class TaxCalculationComponent {

    public TaxCalculation calculateTax(Article article, TaxRate taxRate) {
        return new TaxCalculation();
    }
}
