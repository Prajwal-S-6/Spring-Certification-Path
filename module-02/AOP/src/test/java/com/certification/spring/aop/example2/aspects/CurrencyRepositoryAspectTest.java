package com.certification.spring.aop.example2.aspects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class CurrencyRepositoryAspectTest {

    @InjectMocks
    private CurrencyRepositoryAspect currencyRepositoryAspect;

    @Mock
    private Logger logger;

    @Test
    public void shouldLogOnceForBeforeAdviceThisPointcut() {
        currencyRepositoryAspect.beforeThisCurrencyRepositoryPointcut();
        verify(logger, times(1)).info(anyString());
    }

    @Test
    public void shouldLogOnceForBeforeAdviceTargetPointcut() {
        currencyRepositoryAspect.beforeTargetCurrencyRepositoryPointcut();
        verify(logger, times(1)).info(anyString());
    }

    @Test
    public void shouldLogOnceForAfterAdviceThisPointcut() {
        currencyRepositoryAspect.afterThisCurrencyRepositoryPointcut();
        verify(logger, times(1)).info(anyString());
    }

    @Test
    public void shouldLogOnceForAfterAdviceTargetPointcut() {
        currencyRepositoryAspect.afterTargetCurrencyRepositoryPointcut();
        verify(logger, times(1)).info(anyString());
    }

}