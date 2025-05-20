package com.spring.professional.exam.tutorial.dependencyInjection.annotations.advanced;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class RunnerAdvancedConfiguration {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfigurationAdvanced.class);

        context.registerShutdownHook();

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------------------------------------");

        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(ApplicationConfigurationSimple.class);

        context1.registerShutdownHook();

        Arrays.stream(context1.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
