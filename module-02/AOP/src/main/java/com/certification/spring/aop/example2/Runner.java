package com.certification.spring.aop.example2;

import com.certification.spring.aop.example2.bls.CurrencyService;
import com.certification.spring.aop.example2.ds.CurrencyId;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        CurrencyService currencyService = context.getBean(CurrencyService.class);
        currencyService.getCurrencyCountryName(CurrencyId.USD);
        currencyService.getCurrencyLongName(CurrencyId.USD);
        currencyService.getExchangeRate("USD", "EUR");
        currencyService.getExchangeRate("USD", "EUR", 1);
    }
}
