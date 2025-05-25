package com.certification.spring.preparation.configuration.level;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseApplicationConfiguration.class, FileStoreApplicationConfiguration.class})
public class ApplicationConfiguration {
}
