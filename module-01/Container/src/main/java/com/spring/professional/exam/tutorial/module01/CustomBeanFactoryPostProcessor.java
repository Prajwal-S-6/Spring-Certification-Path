package com.spring.professional.exam.tutorial.module01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("----------------BeanFactoryPostProcessor starts-----------------------");
        System.out.println(getClass().getSimpleName() + "::postProcessBeanFactory Listing Beans Start");
        Arrays.stream(configurableListableBeanFactory.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(getClass().getSimpleName() + "::postProcessBeanFactory Listing Beans End\n");
        System.out.println("----------------BeanFactoryPostProcessor ends-----------------------");
    }
}
