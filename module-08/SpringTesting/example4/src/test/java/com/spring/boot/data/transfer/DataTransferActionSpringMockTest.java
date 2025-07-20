package com.spring.boot.data.transfer;

import com.spring.boot.data.layer.FtpDataLayer;
import com.spring.boot.data.layer.HttpDataLayer;
import com.spring.boot.ds.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = DataTransferAction.class)
class DataTransferActionSpringMockTest {

    private static final List<Person> PERSON_LIST = Arrays.asList(
            new Person(98, "Test1"),
            new Person(99, "Test2")
    );

    @MockitoBean
    private FtpDataLayer ftpDataLayer;

    @MockitoBean
    private HttpDataLayer httpDataLayer;

    @Autowired
    private DataTransferAction dataTransferAction;

    @Test
    public void shouldSaveData() {
        when(ftpDataLayer.getData()).thenReturn(PERSON_LIST);

        dataTransferAction.transfer();

        verify(httpDataLayer).saveData(PERSON_LIST);
    }

}