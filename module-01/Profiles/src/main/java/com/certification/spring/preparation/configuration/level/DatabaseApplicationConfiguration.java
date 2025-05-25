package com.certification.spring.preparation.configuration.level;

import com.certification.spring.preparation.configuration.level.dao.DatabaseStoreFinancialDataDao;

import com.certification.spring.preparation.configuration.level.dao.FinancialDataDao;
import com.certification.spring.preparation.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import com.certification.spring.preparation.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("database")
public class DatabaseApplicationConfiguration {

    @Bean
    public FinancialDataDao databaseStoreFinancialDataDao() {
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter databaseStoreFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }
}
