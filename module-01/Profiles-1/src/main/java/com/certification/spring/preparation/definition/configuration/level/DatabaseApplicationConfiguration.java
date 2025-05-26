package com.certification.spring.preparation.definition.configuration.level;

import com.certification.spring.preparation.definition.configuration.level.dao.DatabaseStoreFinancialDataDao;
import com.certification.spring.preparation.definition.configuration.level.dao.FinancialDataDao;
import com.certification.spring.preparation.definition.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import com.certification.spring.preparation.definition.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("database")
public class DatabaseApplicationConfiguration {

    @Bean
    public FinancialReportWriter databaseStoreFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }

    @Bean
    public FinancialDataDao databaseStoreFinancialDataDao() {
        return new DatabaseStoreFinancialDataDao();
    }
}
