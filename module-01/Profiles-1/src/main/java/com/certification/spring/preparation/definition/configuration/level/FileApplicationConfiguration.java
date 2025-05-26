package com.certification.spring.preparation.definition.configuration.level;

import com.certification.spring.preparation.definition.configuration.level.dao.DatabaseStoreFinancialDataDao;
import com.certification.spring.preparation.definition.configuration.level.dao.FileStoreFinancialDataDao;
import com.certification.spring.preparation.definition.configuration.level.dao.FinancialDataDao;
import com.certification.spring.preparation.definition.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import com.certification.spring.preparation.definition.configuration.level.writer.FileStoreFinancialReportWriter;
import com.certification.spring.preparation.definition.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("file")
public class FileApplicationConfiguration {

    @Bean
    public FinancialReportWriter fileStoreFinancialReportWriter() {
        return new FileStoreFinancialReportWriter();
    }

    @Bean
    public FinancialDataDao fileStoreFinancialDataDao() {
        return new FileStoreFinancialDataDao();
    }
}
