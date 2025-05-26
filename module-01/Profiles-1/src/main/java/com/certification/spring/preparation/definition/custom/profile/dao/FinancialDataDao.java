package com.certification.spring.preparation.definition.custom.profile.dao;


import com.certification.spring.preparation.definition.custom.profile.ds.FinancialMonthSummary;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialQuarterSummary;
import com.certification.spring.preparation.definition.custom.profile.ds.FinancialYearSummary;

public interface FinancialDataDao {
    FinancialYearSummary findFinancialYearSummary(int year);

    FinancialQuarterSummary findFinancialQuarterSummary(int year, int quarter);

    FinancialMonthSummary findFinancialMonthSummary(int year, int month);
}
