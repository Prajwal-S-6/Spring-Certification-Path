package com.certification.spring.aop.example1.with.aop.bls;

import com.certification.spring.aop.example1.with.aop.annotations.Cachable;
import com.certification.spring.aop.example1.with.aop.annotations.PerformanceLogger;
import com.certification.spring.aop.example1.with.aop.ds.Report;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportProvider {
    @Cachable
    @PerformanceLogger
    public Report getReport() throws InterruptedException {
        System.out.println("Fetching the report...");
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        System.out.println("Report created");

        return new Report();
    }
}
