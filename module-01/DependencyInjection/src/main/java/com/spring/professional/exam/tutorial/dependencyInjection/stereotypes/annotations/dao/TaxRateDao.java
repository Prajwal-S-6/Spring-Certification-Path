package com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.dao;


import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.Article;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.TaxRate;
import org.springframework.stereotype.Repository;

@Repository
public class TaxRateDao {
    public TaxRate getTaxRate(Article article) {
        return new TaxRate();
    }
}
