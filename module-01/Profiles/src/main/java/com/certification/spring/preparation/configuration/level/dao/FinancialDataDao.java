package com.certification.spring.preparation.configuration.level.dao;


import com.certification.spring.preparation.configuration.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.configuration.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.configuration.level.ds.FinancialYearSummary;

public interface FinancialDataDao {
    FinancialYearSummary findFinancialYearSummary(int year);

    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
}
