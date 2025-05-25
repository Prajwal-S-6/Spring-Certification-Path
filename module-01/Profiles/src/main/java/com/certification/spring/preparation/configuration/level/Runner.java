package com.certification.spring.preparation.configuration.level;


import com.certification.spring.preparation.configuration.level.service.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        // Activate profile
        context.getEnvironment().setActiveProfiles("database");
        context.register(ApplicationConfiguration.class);
        context.refresh();

        FinancialReportService financialReportService = context.getBean(FinancialReportService.class);

        financialReportService.generateReport();
    }
}
