package com.certification.spring.preparation.definition.configuration.level;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({DatabaseApplicationConfiguration.class, FileApplicationConfiguration.class})
public class ApplicationConfiguration {
}
