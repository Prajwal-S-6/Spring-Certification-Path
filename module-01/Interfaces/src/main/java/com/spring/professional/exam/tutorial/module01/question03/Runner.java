package com.spring.professional.exam.tutorial.module01.question03;

import com.spring.professional.exam.tutorial.module01.question03.service.FinancialReportService;
import com.spring.professional.exam.tutorial.module01.question03.service.SimpleFinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@ComponentScan()
public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);

        SimpleFinancialReportService financialReportService = context.getBean(SimpleFinancialReportService.class);
        // Arrays.stream(context.getBeanDefinitionNames()).toList().forEach(System.out::println);

        financialReportService.generateReport();
    }
}
