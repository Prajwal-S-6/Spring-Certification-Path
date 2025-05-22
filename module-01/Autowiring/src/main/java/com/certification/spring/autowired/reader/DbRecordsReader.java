package com.certification.spring.autowired.reader;


import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class DbRecordsReader implements RecordsReader {
    @Override
    public Collection<Record> readRecords() {
        return Collections.emptyList();
    }
}
