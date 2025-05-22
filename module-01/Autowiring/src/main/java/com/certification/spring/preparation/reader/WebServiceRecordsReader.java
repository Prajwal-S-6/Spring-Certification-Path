package com.certification.spring.preparation.reader;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import java.util.Collection;

@Component
//@Priority(2)
// @Order(1)
public class WebServiceRecordsReader implements RecordsReader {
    @Override
    public Collection<Record> readRecords() {
        return null;
    }
}
