package com.certification.spring.aop.example3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
///  enables CGLIB proxy even though the bean implements the interface
@EnableAspectJAutoProxy(proxyTargetClass = true)
// @EnableAspectJAutoProxy
public class ApplicationConfig {
}
