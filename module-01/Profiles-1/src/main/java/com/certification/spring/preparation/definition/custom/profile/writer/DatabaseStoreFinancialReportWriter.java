package com.certification.spring.preparation.definition.custom.profile.writer;


import com.certification.spring.preparation.definition.custom.profile.annotations.DatabaseProfile;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialMonthSummary;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialYearSummary;
import org.springframework.stereotype.Component;

@Component
@DatabaseProfile
class DatabaseStoreFinancialReportWriter implements FinancialReportWriter {
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
