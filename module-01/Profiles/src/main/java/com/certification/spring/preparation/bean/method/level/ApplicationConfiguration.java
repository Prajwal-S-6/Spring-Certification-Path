package com.certification.spring.preparation.bean.method.level;

import com.certification.spring.preparation.bean.method.level.dao.DatabaseStoreFinancialDataDao;
import com.certification.spring.preparation.bean.method.level.dao.FileStoreFinancialDataDao;
import com.certification.spring.preparation.bean.method.level.dao.FinancialDataDao;
import com.certification.spring.preparation.bean.method.level.writer.DatabaseStoreFinancialReportWriter;
import com.certification.spring.preparation.bean.method.level.writer.FileStoreFinancialReportWriter;
import com.certification.spring.preparation.bean.method.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean
    @Profile("database")
    public FinancialDataDao databaseFinancialDataDao() {
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    @Profile("filestore")
    public FinancialDataDao fileStoreFinancialDataDao() {
        return new FileStoreFinancialDataDao();
    }

    @Bean
    @Profile("database")
    public FinancialReportWriter databaseFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }

    @Bean
    @Profile("filestore")
    public FinancialReportWriter fileStoreFinancialReportWriter() {
        return new FileStoreFinancialReportWriter();
    }


}
