package com.certification.spring.preparation.example5;
import com.certification.spring.preparation.example5.beans.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private SpringBean springBean;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("getAppDefaultProperty: " + springBean.getAppDefaultProperty());
        System.out.println("getAppDevProperty: " + springBean.getAppDevProperty());
        /// vm option -> -Dapp.vm.property
        System.out.println("getAppVmProperty: " + springBean.getAppVmProperty());
        /// env variable
        System.out.println("getAppEnvProperty: " + springBean.getAppEnvProperty());
        /// env variablle -> SPRING_APPLICATION_JSON={"app": "json":{"property":"test"}}}
        System.out.println("getAppJsonProperty: " + springBean.getAppJsonProperty());
        /// program arguments
        System.out.println("getAppCliProperty: " + springBean.getAppCliProperty());
        /// random value
        System.out.println("getAppRandomProperty: " + springBean.getAppRandomStringProperty());
        System.out.println("getAppRandomProperty: " + springBean.getRandomIntProperty());
    }
}
