package com.certification.spring.preparation.definition.bean.level.writer;


import com.certification.spring.preparation.definition.bean.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.definition.bean.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.definition.bean.level.ds.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
