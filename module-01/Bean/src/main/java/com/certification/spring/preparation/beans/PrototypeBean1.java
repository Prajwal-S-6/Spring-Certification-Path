package com.certification.spring.preparation.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.stereotype.Component;

import static org.springframework.boot.BootstrapRegistry.Scope.PROTOTYPE;

@Component
//@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean1 implements SomeInterface{
}
