package com.spring.professional.exam.tutorial.dependencyInjection.annotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpringBean1 {
//    @Autowired
//    private SpringBean2 springBean2;
//    @Autowired
//    private SpringBean3 springBean3;

    private SpringBean2 springBean2;
    private SpringBean3 springBean3;

    public SpringBean1(SpringBean2 springBean2, SpringBean3 springBean3) {
        System.out.println(getClass().getSimpleName() + "::constructor");
        this.springBean2 = springBean2;
        this.springBean3 = springBean3;
    }

//    public SpringBean1() {
//        System.out.println(getClass().getSimpleName() + "::constructor");
//    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(String.format("%s postConstruct with %s and %s",
                getClass().getSimpleName(),
                springBean2.getClass().getSimpleName(),
                springBean3.getClass().getSimpleName()
        ));
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
