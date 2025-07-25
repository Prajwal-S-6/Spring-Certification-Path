package com.spring.test.context.aproach1;

import com.spring.test.configuration.ApplicationConfiguration;
import com.spring.test1.configuration.TestConfiguration;
import com.spring.test1.configuration.TestDataConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class, TestDataConfiguration.class, TestConfiguration.class})
@ActiveProfiles("test")
@Sql(value = "/test-data-guests.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class IntegrationTestBase1 {
}
