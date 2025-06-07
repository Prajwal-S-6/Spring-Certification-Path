package com.certification.spring.aop.example7.beans;


import com.certification.spring.aop.example7.annotations.CustomTransaction;
import com.certification.spring.aop.example7.ds.Person;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("hello_child_bean")
public class HelloChildBean extends HelloBean {
    @Override
    public void sayHello(String name, int ex) {
        System.out.println("Hello from Spring Child Bean for " + name);
    }

    public void validateName(String name) throws IOException {
        System.out.println("Validating name, which throws IO exception");
    }

    @CustomTransaction
    public void saveCounterValue(int counterValue) {
        System.out.println("Save Counter value");
    }

    @CustomTransaction
    public void savePerson(Person person) {
        System.out.println("Save person");
    }

    public void deletePerson(Person person) {
        System.out.println("Delete person");
    }
}
