package com.certification.spring.preparation.activation.programmatically;

import com.certification.spring.preparation.activation.programmatically.dao.FinancialDataDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("file");
        context.register(ApplicationConfiguration.class);
        context.refresh();

        FinancialDataDao financialDataDao = context.getBean(FinancialDataDao.class);
        System.out.println(financialDataDao.getClass().getSimpleName());
    }
}
