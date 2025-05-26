package com.certification.spring.preparation.activation.springboot.programmatically;

import com.certification.spring.preparation.activation.springboot.programmatically.dao.FinancialDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    private FinancialDataDao financialDataDao;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Runner.class).profiles("file").run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(financialDataDao.getClass().getSimpleName());
    }
}
