package com.spring.data.example23.jta.transaction.manager.configuration;

import bitronix.tm.resource.jdbc.PoolingDataSource;
import org.hibernate.engine.transaction.jta.platform.internal.BitronixJtaPlatform;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.spring.data.example23.jta.transaction.manager.db.products.dao",
        entityManagerFactoryRef = "productEntityManagerFactoryBean",
        transactionManagerRef = "jtaTransactionManager"
)
public class ProductDbConfiguration {

    @Bean(name = "productXADataSource", destroyMethod = "close")
    public PoolingDataSource productXADataSource() {
        PoolingDataSource ds = new PoolingDataSource();
        ds.setClassName("org.hsqldb.jdbc.pool.JDBCXADataSource");
        ds.setUniqueName("productDb");
        ds.setMaxPoolSize(5);
        ds.setMinPoolSize(1);
        ds.setAllowLocalTransactions(true);
        ds.getDriverProperties().put("databaseName", "productDb");
        ds.getDriverProperties().put("url", "jdbc:hsqldb:mem:productDb;shutdown=true");
        ds.getDriverProperties().put("user", "praj");
        ds.getDriverProperties().put("password", "");
        ds.init();
        return ds;
    }

    @Bean(name = "productEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactoryBean(
            @Qualifier("productXADataSource") DataSource productsDataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("com.spring.data.example23.jta.transaction.manager.db.products.ds");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJtaDataSource(productsDataSource);

        Properties props = new Properties();
        props.put("hibernate.transaction.jta.platform", BitronixJtaPlatform.class.getName());
        props.put("hibernate.transaction.coordinator_class", "jta");
        props.put("hibernate.hbm2ddl.auto", "create-drop");
        props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");

        emf.setJpaProperties(props);
        emf.setPersistenceUnitName("productPU");

        return emf;
    }
}
