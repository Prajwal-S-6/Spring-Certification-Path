package com.certification.spring.preparation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@TestPropertySource(properties = "spring.application.name=" + "SpringTest")

public class SpringBeanTest {
    @InjectMocks
    private SpringBean springBean;

    @Mock
    private SpringBean1 springBean1;

    @Test
    public void testGetApplicationName() {
        springBean.useProperty();
        verify(springBean1).usePropertyValue(eq("SpringTest"));
    }
}

