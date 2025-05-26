package com.certification.spring.preparation.definition.bean.level.dao;


import com.certification.spring.preparation.definition.bean.level.ds.FinancialMonthSummary;
import com.certification.spring.preparation.definition.bean.level.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.definition.bean.level.ds.FinancialYearSummary;

public interface FinancialDataDao {
    FinancialYearSummary findFinancialYearSummary(int year);

    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
}
