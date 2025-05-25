package com.certification.spring.preparation.beans2;


import com.certification.spring.preparation.beans2.mappers.DataMapper;
import com.certification.spring.preparation.beans2.processors.MultiSourceDataProcessor;
import com.certification.spring.preparation.beans2.readers.DataReader;
import com.certification.spring.preparation.beans2.writer.DataWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("file", "prod");
        context.register(ApplicationConfiguration2.class);
        context.refresh();

        System.out.println(context.getBean(DataMapper.class).getClass().getSimpleName());
        System.out.println(context.getBean(MultiSourceDataProcessor.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataReader.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataWriter.class).getClass().getSimpleName());
    }
}
