package com.spring.data.example28.configurations;

import com.spring.data.example28.dao.custom.base.CustomBaseJpaRepository;
import jakarta.persistence.EntityManagerFactory;
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
@EnableJpaRepositories(basePackages = "com.spring.data.example28.dao",
repositoryBaseClass = CustomBaseJpaRepository.class,
entityManagerFactoryRef = "entityManagerFactoryBean",
transactionManagerRef = "platformTransactionManager")
public class JpaConfiguration {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setScriptEncoding("UTF-8")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);

        localContainerEntityManagerFactoryBean.setPackagesToScan("com.spring.data.example28.ds");

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties props = new Properties();
        props.put("hibernate.hbm2ddl.auto", "create"); // or "update"
        props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
//        props.put("hibernate.show_sql", "true");
        localContainerEntityManagerFactoryBean.setJpaProperties(props);

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
