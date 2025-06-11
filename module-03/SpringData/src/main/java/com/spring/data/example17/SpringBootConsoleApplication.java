package com.spring.data.example17;

import com.spring.data.example17.service.TransactionIsolationExample;
import com.spring.data.example17.service.TransactionIsolationExampleInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private TransactionIsolationExampleInvoker transactionIsolationExampleInvoker;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        transactionIsolationExampleInvoker.execute();
    }
}
