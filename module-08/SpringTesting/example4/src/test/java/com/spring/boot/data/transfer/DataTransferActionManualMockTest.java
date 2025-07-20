package com.spring.boot.data.transfer;

import com.spring.boot.data.layer.FtpDataLayer;
import com.spring.boot.data.layer.HttpDataLayer;
import com.spring.boot.ds.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class DataTransferActionManualMockTest {

    private static final List<Person> PERSON_LIST = Arrays.asList(
            new Person(98, "Test1"),
            new Person(99, "Test2")
    );

    @InjectMocks
    private DataTransferAction dataTransferAction;

    @Mock
    private FtpDataLayer ftpDataLayer;

    @Mock
    private HttpDataLayer httpDataLayer;


    @Test
    public void shouldTransfer() {
        when(ftpDataLayer.getData()).thenReturn(PERSON_LIST);

        dataTransferAction.transfer();

        verify(httpDataLayer).saveData(PERSON_LIST);

    }

}