package com.certification.spring.preparation.configuration.level;

import com.certification.spring.preparation.configuration.level.dao.DatabaseStoreFinancialDataDao;
import com.certification.spring.preparation.configuration.level.dao.FileStoreFinancialDataDao;
import com.certification.spring.preparation.configuration.level.dao.FinancialDataDao;
import com.certification.spring.preparation.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import com.certification.spring.preparation.configuration.level.writer.FileStoreFinancialReportWriter;
import com.certification.spring.preparation.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("filestore")
public class FileStoreApplicationConfiguration {

    @Bean
    public FinancialDataDao financialDataDao() {
        return new FileStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter financialReportWriter() {
        return new FileStoreFinancialReportWriter();
    }
}
