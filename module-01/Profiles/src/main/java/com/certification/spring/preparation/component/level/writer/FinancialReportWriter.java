package com.certification.spring.preparation.component.level.writer;


import com.certification.spring.preparation.component.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.component.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.component.level.ds.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
