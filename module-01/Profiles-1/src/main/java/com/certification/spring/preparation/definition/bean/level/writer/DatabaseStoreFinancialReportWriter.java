package com.certification.spring.preparation.definition.bean.level.writer;


import com.certification.spring.preparation.definition.bean.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.definition.bean.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.definition.bean.level.ds.FinancialYearSummary;

public class DatabaseStoreFinancialReportWriter implements FinancialReportWriter {
    @Override
    public void appendFreeText(String title) {
        System.out.println("Database Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("Database Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("Database Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("Database Writer => appendFinancialMonthSummary");
    }
}
