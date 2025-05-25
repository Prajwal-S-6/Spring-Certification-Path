package com.certification.spring.preparation.bean.method.level.dao;

import com.certification.spring.preparation.bean.method.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialYearSummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


public class FileStoreFinancialDataDao implements FinancialDataDao {
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
