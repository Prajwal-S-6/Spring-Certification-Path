package com.certification.spring.preparation.definition.configuration.level.writer;


import com.certification.spring.preparation.definition.configuration.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.definition.configuration.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.definition.configuration.level.ds.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
