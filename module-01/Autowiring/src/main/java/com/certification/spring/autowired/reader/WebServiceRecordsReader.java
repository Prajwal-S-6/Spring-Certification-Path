package com.certification.spring.autowired.reader;

import org.springframework.stereotype.Component;

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
