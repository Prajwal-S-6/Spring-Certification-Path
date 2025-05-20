package com.spring.professional.exam.tutorial.module01.closing.context.runners;

import com.spring.professional.exam.tutorial.module01.closing.context.ApplicationConfiguration;
import com.spring.professional.exam.tutorial.module01.closing.context.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// closing Application context using context.close()
public class Runner1 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        context.getBean(SpringBean1.class);

        context.close();
    }

}
