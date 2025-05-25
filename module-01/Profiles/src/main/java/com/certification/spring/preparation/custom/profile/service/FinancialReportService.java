package com.certification.spring.preparation.custom.profile.service;


import com.certification.spring.preparation.custom.profile.dao.FinancialDataDao;
import com.certification.spring.preparation.custom.profile.ds.FinancialMonthSummary;
import com.certification.spring.preparation.custom.profile.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.custom.profile.ds.FinancialYearSummary;
import com.certification.spring.preparation.custom.profile.writer.FinancialReportWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinancialReportService {

    @Autowired
    private FinancialDataDao financialDataDao;
    @Autowired
    private FinancialReportWriter financialReportWriter;

    public void generateReport() {
        FinancialYearSummary financialYearSummary = financialDataDao.findFinancialYearSummary(2019);
        FinancialQuarterSummary financialQuarterSummary = financialDataDao.findFinancialQuarterSummary(2019, 1);
        FinancialMonthSummary financialMonthSummary = financialDataDao.findFinancialMonthSummary(2019, 4);

        financialReportWriter.appendFreeText("Year / Quarter / Month Financial Report");
        financialReportWriter.appendFinancialYearSummary(financialYearSummary);
        financialReportWriter.appendFinancialQuarterSummary(financialQuarterSummary);
        financialReportWriter.appendFinancialMonthSummary(financialMonthSummary);
    }
}
