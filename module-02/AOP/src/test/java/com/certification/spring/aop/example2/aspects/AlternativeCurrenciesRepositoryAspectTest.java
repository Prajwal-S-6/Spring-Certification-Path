package com.certification.spring.aop.example2.aspects;

import ch.qos.logback.core.Appender;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.LoggerFactory;
import org.slf4j.event.LoggingEvent;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(OutputCaptureExtension.class)
class AlternativeCurrenciesRepositoryAspectTest {
    private AlternativeCurrenciesRepositoryAspect alternativeCurrenciesRepositoryAspect;
    @BeforeEach
    void setUp() {
        alternativeCurrenciesRepositoryAspect = new AlternativeCurrenciesRepositoryAspect();
    }

    @Test
    void shouldLogAlternativeCurrenciesRepositoryTwice(CapturedOutput capturedOutput) {
        alternativeCurrenciesRepositoryAspect.beforeThisCurrenciesRepository();

        assertThat(capturedOutput.getOut()).contains("Before - this(AlternativeCurrenciesRepository)");
    }

}