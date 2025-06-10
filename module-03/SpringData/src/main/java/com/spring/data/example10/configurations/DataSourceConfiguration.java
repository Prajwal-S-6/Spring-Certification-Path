package com.spring.data.example10.configurations;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    @Bean("custom_data_source")
    @Qualifier("customDataSource")
    public DataSource customDataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setScriptEncoding("UTF-8")
                .addScript("schema.sql")
                .build();
    }

    @Bean
    // public PlatformTransactionManager platformTransactionManager(@Qualifier("customDataSource") DataSource dataSource) {
    public PlatformTransactionManager platformTransactionManager(@Qualifier("custom_data_source") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
