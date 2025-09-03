package com.certification.spring.aop.example2.aspects;

import com.certification.spring.aop.example2.ApplicationConfig;
import com.certification.spring.aop.example2.bls.CurrencyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
class CurrencyServiceAspectIntegrationTest {

    @Autowired
    private CurrencyService currencyService;


    @Test
    public void shouldLogForGetExchangeRate() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));

        currencyService.getExchangeRate("USD", "INR");

        System.setOut(originalSystemOut);
        String logMessage = byteArrayOutputStream.toString();

        assertThat(logMessage).contains("Before - transactionAnnotationPointcut");
        assertThat(logMessage).contains("Before - blsPackagePointcut");
        assertThat(logMessage).contains("After - blsPackagePointcut");
        assertThat(logMessage).contains("After - blsPackageAndInTransactionPointcut");
        assertThat(logMessage).contains("Before - securedClassPointcut");
        assertThat(logMessage).contains("Before - getExchangeRateMethodPointcut");
        assertThat(logMessage).contains("After - getExchangeRateMethodPointcut");
        assertThat(logMessage).contains("After - namedBeanPointcut");
        assertThat(logMessage).contains("After - currencyServiceTargetPointcut");
        assertThat(logMessage).contains("After - currencyServiceSecuredTargetPointcut");




    }
}