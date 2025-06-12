package com.spring.data.example23.jta.transaction.manager.configuration;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@EnableTransactionManagement
public class JtaTransactionConfig {

    @Bean
    public UserTransaction userTransaction() throws Throwable {
        UserTransactionImp ut = new UserTransactionImp();
        ut.setTransactionTimeout(300);
        return (UserTransaction) ut;
    }

    @Bean
    public UserTransactionManager btmTransactionManager() throws Throwable {
        UserTransactionManager utm = new UserTransactionManager();
        utm.init();
        return utm;
    }

    @Bean
    public PlatformTransactionManager jtaTransactionManager(UserTransaction ut, TransactionManager tm) {
        return new JtaTransactionManager(ut, tm);
    }

}
