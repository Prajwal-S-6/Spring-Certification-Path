package com.certification.spring.preparation.bean.method.level.writer;


import com.certification.spring.preparation.bean.method.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialYearSummary;

public class FileStoreFinancialReportWriter implements FinancialReportWriter {
    @Override
    public void appendFreeText(String title) {
        System.out.println("File Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("File Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("File Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("File Writer => appendFinancialMonthSummary");
    }
}
