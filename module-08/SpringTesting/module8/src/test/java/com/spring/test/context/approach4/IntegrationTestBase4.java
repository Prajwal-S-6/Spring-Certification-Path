package com.spring.test.context.approach4;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test1.configuration.TestConfiguration;
import com.spring.test1.configuration.TestDataConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;

@Configuration
@Import({TestConfiguration.class, TestDataConfiguration.class})
public class IntegrationTestBase4 extends ApplicationConfiguration {
}
