package com.certification.spring.autowired.bls;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class DbRecordsProcessor implements RecordsProcessor {
    @Override
    public Collection<Record> processRecords(Collection<Record> records) {
        return Collections.emptyList();
    }
}
