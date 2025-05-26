package com.certification.spring.preparation.activation.junit;

import com.certification.spring.preparation.activation.junit.dao.FinancialDataDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@ActiveProfiles("database")
public class ApplicationConfigTest {
    @Autowired
    private FinancialDataDao financialDataDao;

    @Test
    public void shouldTestFinancialDataDao() {
        assertEquals(financialDataDao.getClass().getSimpleName(), "DatabaseStoreFinancialDataDao");
    }
}