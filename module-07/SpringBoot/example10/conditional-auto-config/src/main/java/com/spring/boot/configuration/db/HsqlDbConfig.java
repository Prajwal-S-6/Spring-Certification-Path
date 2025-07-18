package com.spring.boot.configuration.db;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@AutoConfiguration
@ConditionalOnClass({org.hsqldb.jdbc.JDBCDriver.class})
public class HsqlDbConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setScriptEncoding("UTF-8")
                .addScript("hsql-schema.sql")
                .addScript("hsql-data.sql")
                .build();
    }


}
