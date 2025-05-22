package com.certification.spring.preparation.reader;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Order(8)
public class SocketRecordsReader implements RecordsReader {
    @Override
    public Collection<Record> readRecords() {
        return null;
    }
}
