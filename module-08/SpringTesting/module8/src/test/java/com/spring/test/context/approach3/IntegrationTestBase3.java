package com.spring.test.context.approach3;

import com.spring.test.configuration.ApplicationConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@ActiveProfiles("test")
@Sql(value = "/test-data-guests.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public @interface IntegrationTestBase3 {
}
