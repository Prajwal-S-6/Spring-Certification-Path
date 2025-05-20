package com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.controller;


import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.Article;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.ds.TaxInformation;
import com.spring.professional.exam.tutorial.dependencyInjection.stereotypes.annotations.service.TaxInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TaxInformationController {

    @Autowired
    private TaxInformationService taxInformationService;

    public void printTaxInformation(Article article) {
        TaxInformation taxInformation = taxInformationService.getTaxInformation(article);

        String formattedTaxInformation = String.format("%s %s",
                taxInformation.getArticle().getName(),
                taxInformation.getTaxCalculation().getTaxValue()
        );

        System.out.println(formattedTaxInformation);
    }
}
