package com.certification.spring.preparation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ComponentScan
//@PropertySource("classpath:application.properties")
@PropertySources({@PropertySource("classpath:application.properties"),
                    @PropertySource("file:D:\\dev\\Spring-Certification-Path\\Spring-Certification-Path\\module-01\\ReadingFromProperty\\db.properties")})
public class ApplicationConfiguration {
}
