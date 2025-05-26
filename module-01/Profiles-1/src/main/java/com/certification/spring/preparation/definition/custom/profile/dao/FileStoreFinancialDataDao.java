package com.certification.spring.preparation.definition.custom.profile.dao;


import com.certification.spring.preparation.definition.custom.profile.annotations.FileStoreProfile;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialMonthSummary;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialYearSummary;
import org.springframework.stereotype.Component;

@Component
@FileStoreProfile
class FileStoreFinancialDataDao implements FinancialDataDao {
    @Override
    public FinancialYearSummary findFinancialYearSummary(int year) {
        System.out.println("File Dao => findFinancialYearSummary");
        return new FinancialYearSummary();
    }

    @Override
    public FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter) {
        System.out.println("File Dao => findFinancialQuarterSummary");
        return new FinancialQuarterSummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthSummary(int year, int month) {
        System.out.println("File Dao => findFinancialMonthSummary");
        return new FinancialMonthSummary();
    }
}
