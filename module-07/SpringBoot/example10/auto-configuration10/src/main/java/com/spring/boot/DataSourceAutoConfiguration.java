package com.spring.boot;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@AutoConfiguration
@ConditionalOnClass({org.hsqldb.Database.class})
public class DataSourceAutoConfiguration {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setScriptEncoding("UTF-8")
                .addScript("embedded-db-schema.sql")
                .addScript("embedded-db-data.sql")
                .build();
    }
}
