package com.certification.spring.aop.example7;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class ApplicationConfig {
}
