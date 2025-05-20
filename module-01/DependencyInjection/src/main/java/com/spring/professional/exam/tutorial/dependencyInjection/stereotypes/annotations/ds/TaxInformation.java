package com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds;

public class TaxInformation {
    private final Article article;
    private final TaxCalculation taxCalculation;

    public TaxInformation(Article article, TaxCalculation taxCalculation) {

        this.article = article;
        this.taxCalculation = taxCalculation;
    }

    public Article getArticle() {
        return article;
    }

    public TaxCalculation getTaxCalculation() {
        return taxCalculation;
    }
}
