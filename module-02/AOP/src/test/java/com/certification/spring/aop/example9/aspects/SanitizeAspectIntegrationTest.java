package com.certification.spring.aop.example9.aspects;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.certification.spring.aop.example9.ApplicationConfig;
import com.certification.spring.aop.example9.beans.TransactionHistoryServiceClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = ApplicationConfig.class)
class SanitizeAspectIntegrationTest {

    @Autowired
    private TransactionHistoryServiceClient transactionHistoryServiceClient;


    @Test
    void shouldSanitizeTheArgs(CapturedOutput capturedOutput) {
        transactionHistoryServiceClient.saveTransactionData("123", "abc", "password");
        assertThat(capturedOutput.getOut())
                .containsIgnoringNewLines("Sending data, identifier = [123], data = [***sanitized***], privateKey = [***sanitized***]");
    }
}