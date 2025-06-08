package com.certification.spring.aop.example9.beans;


import com.certification.spring.aop.example9.annotations.Sanitize;
import org.springframework.stereotype.Component;

@Component
public class TransactionHistoryServiceClient {
    public void saveTransactionData(String identifier, @Sanitize String data, @Sanitize String privateKey) {
        System.out.println(
                String.format(
                        "Sending data, identifier = [%s], data = [%s], privateKey = [%s]",
                        identifier, data, privateKey
                )
        );
    }
}
