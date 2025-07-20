package com.spring.boot.test;

import com.spring.boot.dao.CityDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.spring.boot.dao", "com.spring.boot.ds", "com.spring.boot.service", "com.spring.boot.controller"})
@EnableJpaRepositories(basePackages = "com.spring.boot.dao")
@EntityScan("com.spring.boot.ds")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}