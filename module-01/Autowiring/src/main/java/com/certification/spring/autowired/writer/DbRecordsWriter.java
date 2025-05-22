package com.certification.spring.autowired.writer;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DbRecordsWriter implements RecordsWriter {
    @Override
    public void writeRecords(Collection<Record> records) {

    }
}
