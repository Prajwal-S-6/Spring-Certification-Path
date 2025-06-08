package com.certification.spring.aop.example9;

import com.certification.spring.aop.example9.beans.TransactionHistoryServiceClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        TransactionHistoryServiceClient transactionHistoryServiceClient = context.getBean(TransactionHistoryServiceClient.class);
        transactionHistoryServiceClient.saveTransactionData("123", "abc", "password");
    }
}
