package com.certification.spring.preparation;

import com.certification.spring.preparation.beans.PrototypeBean1;
import com.certification.spring.preparation.beans.SingletonBean1;
import com.certification.spring.preparation.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        springBean1.printDependencies();

        SingletonBean1 singletonBean1 = context.getBean(SingletonBean1.class);
        System.out.println(singletonBean1);
        System.out.println(singletonBean1.getPrototypeBean1());
        System.out.println(singletonBean1.getPrototypeBean1());

        SingletonBean1 singletonBean2 = context.getBean(SingletonBean1.class);
        System.out.println(singletonBean2);
        System.out.println(singletonBean2.getPrototypeBean1());




    }
}
