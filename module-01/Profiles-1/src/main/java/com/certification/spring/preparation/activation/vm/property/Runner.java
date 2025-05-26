package com.certification.spring.preparation.activation.vm.property;

import com.certification.spring.preparation.activation.programmatically.dao.FinancialDataDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.registerShutdownHook();

        FinancialDataDao financialDataDao = context.getBean(FinancialDataDao.class);
        System.out.println(financialDataDao.getClass().getSimpleName());
    }
}
