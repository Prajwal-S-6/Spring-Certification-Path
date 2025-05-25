package com.certification.spring.preparation.configuration.level;


import com.certification.spring.preparation.configuration.level.dao.FinancialDataDao;
import com.certification.spring.preparation.configuration.level.service.FinancialReportService;
import com.certification.spring.preparation.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseApplicationConfiguration.class, FileApplicationConfiguration.class})
public class ApplicationConfiguration {

    @Bean
    public FinancialReportService financialReportService(FinancialDataDao financialDataDao, FinancialReportWriter financialReportWriter) {
        return new FinancialReportService(financialDataDao, financialReportWriter);
    }
}
