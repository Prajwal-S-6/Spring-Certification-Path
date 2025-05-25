package com.certification.spring.preparation.beans1;

import com.certification.spring.preparation.beans1.mappers.DataMapper;
import com.certification.spring.preparation.beans1.processors.MultiSourceDataProcessor;
import com.certification.spring.preparation.beans1.readers.DataReader;
import com.certification.spring.preparation.beans1.writer.DataWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("database", "dev");
        context.register(ApplicationConfiguration1.class);
        context.refresh();

        System.out.println(context.getBean(DataMapper.class).getClass().getSimpleName());
        System.out.println(context.getBean(MultiSourceDataProcessor.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataReader.class).getClass().getSimpleName());
        System.out.println(context.getBean(DataWriter.class).getClass().getSimpleName());
    }
}
