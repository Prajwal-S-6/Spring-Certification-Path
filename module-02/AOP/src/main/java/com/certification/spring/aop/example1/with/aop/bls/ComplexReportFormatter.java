package com.certification.spring.aop.example1.with.aop.bls;


import com.certification.spring.aop.example1.with.aop.annotations.PerformanceLogger;
import com.certification.spring.aop.example1.with.aop.ds.FormattedReport;
import com.certification.spring.aop.example1.with.aop.ds.Report;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportFormatter {
    @PerformanceLogger
    public FormattedReport formatReport(Report report) throws InterruptedException {
        System.out.println("Formatting the report...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("Report Formatted");

        return new FormattedReport(report);
    }
}
