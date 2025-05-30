package com.certification.spring.aop.example1.no.aop.actions;


import com.certification.spring.aop.example1.no.aop.PerformanceLogger;
import com.certification.spring.aop.example1.no.aop.PerformanceLogger.*;
import com.certification.spring.aop.example1.no.aop.bls.ComplexReportFormatter;
import com.certification.spring.aop.example1.no.aop.bls.ComplexReportProvider;
import com.certification.spring.aop.example1.no.aop.bls.ComplexReportRepository;
import com.certification.spring.aop.example1.no.aop.ds.FormattedReport;
import com.certification.spring.aop.example1.no.aop.ds.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplexReportAction {

    @Autowired
    private ComplexReportProvider complexReportProvider;
    @Autowired
    private ComplexReportFormatter complexReportFormatter;
    @Autowired
    private ComplexReportRepository complexReportRepository;
    @Autowired
    private PerformanceLogger performanceLogger;

    public void perform() throws InterruptedException {
        PerformanceLoggerInfo performanceLoggerInfo;

        performanceLoggerInfo = performanceLogger.start("complexReportProvider.getReport()");
        Report report = complexReportProvider.getReport();
        performanceLogger.stop(performanceLoggerInfo);

        performanceLoggerInfo = performanceLogger.start("complexReportFormatter.formatReport(...)");
        FormattedReport formattedReport = complexReportFormatter.formatReport(report);
        performanceLogger.stop(performanceLoggerInfo);

        performanceLoggerInfo = performanceLogger.start("complexReportRepository.save(...)");
        complexReportRepository.save(formattedReport);
        performanceLogger.stop(performanceLoggerInfo);

        performanceLoggerInfo = performanceLogger.start("complexReportProvider.getReport()");
        report = complexReportProvider.getReport();
        performanceLogger.stop(performanceLoggerInfo);
    }
}
