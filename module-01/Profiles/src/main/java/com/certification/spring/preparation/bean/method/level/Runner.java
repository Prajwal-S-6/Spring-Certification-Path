package com.certification.spring.preparation.bean.method.level;


import com.certification.spring.preparation.bean.method.level.service.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("database");
        context.register(ApplicationConfiguration.class);
        context.refresh();

        FinancialReportService financialReportService = (FinancialReportService) context.getBean("financialReportService");
        financialReportService.generateReport();
    }
}
