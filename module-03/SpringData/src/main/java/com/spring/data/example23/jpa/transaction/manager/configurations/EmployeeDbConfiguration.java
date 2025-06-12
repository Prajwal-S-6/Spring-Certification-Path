package com.spring.data.example23.jpa.transaction.manager.configurations;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.spring.data.example23.jpa.transaction.manager.db.employee.dao",
        entityManagerFactoryRef = "employeeEntityManagerFactoryBean",
        transactionManagerRef = "employeeTransactionManager")
public class EmployeeDbConfiguration {

    @Bean
    public DataSource employeeDataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setScriptEncoding("UTF-8")
                .addScript("schema-employees.sql")
                .build();
    }

    @Bean(name = "employeeEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactoryBean(DataSource employeeDataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(employeeDataSource);

        localContainerEntityManagerFactoryBean.setPackagesToScan("com.spring.data.example23.jpa.transaction.manager.db.employee.ds");
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties props = new Properties();
        props.put("hibernate.hbm2ddl.auto", "create"); // or "update"
        props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");

        localContainerEntityManagerFactoryBean.setJpaProperties(props);


        return localContainerEntityManagerFactoryBean;
    }

    @Bean(name = "employeeTransactionManager")
    public PlatformTransactionManager employeeTransactionManager(@Qualifier("employeeEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
