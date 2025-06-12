package com.spring.data.example23.jta.transaction.manager.configuration;

import bitronix.tm.resource.jdbc.PoolingDataSource;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.UserTransaction;
import org.hibernate.engine.transaction.jta.platform.internal.BitronixJtaPlatform;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.spring.data.example23.jta.transaction.manager.db.employee.dao",
        entityManagerFactoryRef = "employeeEntityManagerFactoryBean",
        transactionManagerRef = "jtaTransactionManager"
)
public class EmployeeDbConfiguration {

    @Bean(name = "employeeXADataSource", destroyMethod = "close")
    public PoolingDataSource employeeXADataSource() {
        PoolingDataSource ds = new PoolingDataSource();
        ds.setClassName("org.hsqldb.jdbc.pool.JDBCXADataSource");
        ds.setUniqueName("employeeDb");
        ds.setMinPoolSize(1);
        ds.setMaxPoolSize(5);
        ds.setAllowLocalTransactions(true);
        ds.getDriverProperties().put("databaseName", "employeeDb");
        ds.getDriverProperties().put("url", "jdbc:hsqldb:mem:employeeDb;shutdown=true");
        ds.getDriverProperties().put("user", "praj");
        ds.getDriverProperties().put("password", "");
        ds.init();
        return ds;
    }

    @Bean(name = "employeeEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactoryBean(@Qualifier("employeeXADataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("com.spring.data.example23.jta.transaction.manager.db.employee.ds");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJtaDataSource(dataSource);

        Properties props = new Properties();
        props.put("hibernate.transaction.jta.platform", BitronixJtaPlatform.class.getName());
        props.put("hibernate.transaction.coordinator_class", "jta");
        props.put("hibernate.hbm2ddl.auto", "create-drop");
        props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        props.put("hibernate.show_sql", "true");

        emf.setJpaProperties(props);
        emf.setPersistenceUnitName("employeePU");

        return emf;
    }

}
