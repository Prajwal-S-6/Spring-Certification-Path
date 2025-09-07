package com.certification.spring.aop.example9.beans;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionHistoryServiceClientUnitTest {

    @InjectMocks
    TransactionHistoryServiceClient transactionHistoryServiceClient;

    @Mock
    Logger LOG;

    @Test
    void shouldLogTheOutput() {
        transactionHistoryServiceClient.saveTransactionData("123", "abc", "password");
        verify(LOG, times(1)).info("Sending data, identifier = [{}], data = [{}], privateKey = [{}]", "123", "abc", "password");
    }
}