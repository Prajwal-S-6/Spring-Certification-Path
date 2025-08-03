package com.certification.spring.preparation.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class SingletonBean1  {
    // public class SingletonBean1 implements ApplicationContextAware {


    /// returns only one instance of Prototype bean whenever requested
    @Autowired
    private PrototypeBean1 prototypeBean1;

    public PrototypeBean1 getPrototypeBean1() {
        return prototypeBean1;
    }

    /// ---------------------------------------------------------------------------------------------------------

    ///1. returns new instance each time - using @Lookup
//    @Lookup
//    public PrototypeBean1 getPrototypeBean1() {
//        return null;
//    }


    /// ---------------------------------------------------------------------------------------------------------

//    @Autowired
//    private ObjectFactory<PrototypeBean1> prototypeBean1ObjectFactory;


    /// 2. returns new instance each time - using ObjectFactory
//    public PrototypeBean1 getPrototypeBean1() {
//        return prototypeBean1ObjectFactory.getObject();
//    }


    /// ---------------------------------------------------------------------------------------------------------


    /// 3. returns new instance each time - using ApplicationContext(not recommended asit tightly binds to container)
//    @Autowired
//    private ApplicationContext context;
//
//    public PrototypeBean1 getPrototypeBean1() {
//        return context.getBean(PrototypeBean1.class);
//    }


    /// 4. returns new instance each time - using ApplicationContextAware
//    private ApplicationContext applicationContext;
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    public PrototypeBean1 getPrototypeBean1() {
//        return applicationContext.getBean(PrototypeBean1.class);
//    }


}
