package com.certification.spring.preparation.definition.custom.profile.writer;


import com.certification.spring.preparation.definition.custom.profile.ds.FinancialMonthSummary;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
