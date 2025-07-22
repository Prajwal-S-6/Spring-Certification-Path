package com.spring.test.context.aproach2;

import com.spring.test.configuration.ApplicationConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = ApplicationConfiguration.class)
@ActiveProfiles("test")
public interface IntegrationTestBase2 {
}
