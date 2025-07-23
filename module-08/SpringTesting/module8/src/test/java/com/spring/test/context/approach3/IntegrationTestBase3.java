package com.spring.test.context.approach3;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test1.configuration.TestConfiguration;
import com.spring.test1.configuration.TestDataConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = {ApplicationConfiguration.class, TestDataConfiguration.class, TestConfiguration.class})
@ActiveProfiles("test")
@Sql(value = "/test-data-guests.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public @interface IntegrationTestBase3 {
}
