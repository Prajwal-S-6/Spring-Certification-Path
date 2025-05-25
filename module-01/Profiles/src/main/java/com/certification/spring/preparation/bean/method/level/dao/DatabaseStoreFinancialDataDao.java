package com.certification.spring.preparation.bean.method.level.dao;


import com.certification.spring.preparation.bean.method.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialYearSummary;
import org.springframework.stereotype.Component;

public class DatabaseStoreFinancialDataDao implements FinancialDataDao {
    @Override
    public FinancialYearSummary findFinancialYearSummary(int year) {
        System.out.println("Database Dao => findFinancialYearSummary");
        return new FinancialYearSummary();
    }

    @Override
    public FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter) {
        System.out.println("Database Dao => findFinancialQuarterSummary");
        return new FinancialQuarterSummary();
    }

    @Override
    public FinancialMonthSummary findFinancialMonthSummary(int year, int month) {
        System.out.println("Database Dao => findFinancialMonthSummary");
        return new FinancialMonthSummary();
    }
}
