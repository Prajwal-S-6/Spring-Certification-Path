package com.certification.spring.preparation.bean.method.level.dao;


import com.certification.spring.preparation.bean.method.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.bean.method.level.ds.FinancialYearSummary;

public interface FinancialDataDao {
    FinancialYearSummary findFinancialYearSummary(int year);

    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
}
