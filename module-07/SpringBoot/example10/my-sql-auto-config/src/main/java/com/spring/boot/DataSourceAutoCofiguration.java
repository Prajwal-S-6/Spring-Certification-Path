package com.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@AutoConfiguration
@ConditionalOnClass({com.mysql.cj.jdbc.Driver.class})
@EnableConfigurationProperties(MySqlProperties.class)
@PropertySource("classpath:mysql.properties")
public class DataSourceAutoCofiguration {

    @Autowired
    private MySqlProperties mySqlProperties;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = driverManagerDataSource();
        initializeDataSource(dataSource);
        return dataSource;
    }

    private DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl(String.format("jdbc:mysql://%s:%d/%s", mySqlProperties.getHost(), mySqlProperties.getPort(), mySqlProperties.getDbname()));
        driverManagerDataSource.setUsername(mySqlProperties.getName());
        driverManagerDataSource.setPassword(mySqlProperties.getPassword());

        return driverManagerDataSource;
    }

    private void initializeDataSource(DriverManagerDataSource dataSource) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("mysql-schema.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("mysql-data.sql"));
        resourceDatabasePopulator.execute(dataSource);
    }

}
