package com.certification.spring.preparation.definition.bean.level;

import com.certification.spring.preparation.definition.bean.level.dao.DatabaseStoreFinancialDataDao;
import com.certification.spring.preparation.definition.bean.level.dao.FileStoreFinancialDataDao;
import com.certification.spring.preparation.definition.bean.level.dao.FinancialDataDao;
import com.certification.spring.preparation.definition.bean.level.service.FinancialReportService;

import com.certification.spring.preparation.definition.bean.level.writer.DatabaseStoreFinancialReportWriter;
import com.certification.spring.preparation.definition.bean.level.writer.FileStoreFinancialReportWriter;
import com.certification.spring.preparation.definition.bean.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FinancialReportService financialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        return new FinancialReportService(financialDataDao, financialReportWriter);
    }

    @Bean
    @Profile("database")
    public FinancialDataDao databaseStoreFinancialDataDao() {
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    @Profile("database")
    public FinancialReportWriter databaseStoreFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }

    @Bean
    @Profile("file")
    public FinancialDataDao fileStoreFinancialDataDao() {
        return new FileStoreFinancialDataDao();
    }

    @Bean
    @Profile("file")
    public FinancialReportWriter fileStoreFinancialReportWriter() {
        return new FileStoreFinancialReportWriter();
    }

}
