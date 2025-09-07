package com.certification.spring.aop.example9.beans;


import com.certification.spring.aop.example9.annotations.Sanitize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TransactionHistoryServiceClient {
    Logger LOG = LoggerFactory.getLogger(TransactionHistoryServiceClient.class);

    public void saveTransactionData(String identifier, @Sanitize String data, @Sanitize String privateKey) {
        LOG.info("Sending data, identifier = [{}], data = [{}], privateKey = [{}]", identifier, data, privateKey);
    }
}
