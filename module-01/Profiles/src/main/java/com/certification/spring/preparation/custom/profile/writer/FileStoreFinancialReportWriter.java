package com.certification.spring.preparation.custom.profile.writer;


import com.certification.spring.preparation.custom.profile.annotations.FileStoreProfile;
import com.certification.spring.preparation.custom.profile.ds.FinancialMonthSummary;
import com.certification.spring.preparation.custom.profile.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.custom.profile.ds.FinancialYearSummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@FileStoreProfile
class FileStoreFinancialReportWriter implements FinancialReportWriter {
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
