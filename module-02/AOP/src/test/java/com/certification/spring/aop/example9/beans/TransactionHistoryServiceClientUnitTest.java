package com.certification.spring.aop.example9.beans;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionHistoryServiceClientUnitTest {

    TransactionHistoryServiceClient transactionHistoryServiceClient = new TransactionHistoryServiceClient();


    @Test
    void shouldLogTheOutput() {
        Logger logger = (Logger) LoggerFactory.getLogger(TransactionHistoryServiceClient.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        transactionHistoryServiceClient.saveTransactionData("123", "abc", "password");

        List<ILoggingEvent> logs = listAppender.list;
        assertEquals(1, logs.size());
        assertThat(logs.get(0).getFormattedMessage()).isEqualTo("Sending data, identifier = [123], data = [abc], privateKey = [password]");
    }
}