package com.spring.boot;

import com.spring.boot.service.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import other.service.ServiceB;

//@SpringBootApplication(scanBasePackages = {"com.spring.boot", "other.service"})
@SpringBootApplication(scanBasePackageClasses = {Main.class, ServiceB.class})
public class Main implements CommandLineRunner {

    @Autowired
    private ServiceA serviceA;

    @Autowired
    private ServiceB serviceB;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        serviceA.print();
        serviceB.print();
    }
}