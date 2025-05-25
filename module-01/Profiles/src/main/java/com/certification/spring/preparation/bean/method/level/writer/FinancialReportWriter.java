package com.certification.spring.preparation.bean.method.level.writer;


import com.certification.spring.preparation.bean.method.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialYearSummary;

public interface FinancialReportWriter {
    void appendFreeText(String title);

    void appendFinancialYearSummary(FinancialYearSummary financialYearSummary);

    void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary);

    void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary);
}
